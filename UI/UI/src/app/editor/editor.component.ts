import {Component, Injectable, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {SourceFile} from "../sourcefile";
import {catchError, tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Project} from "../project";
import {NzMessageService} from "ng-zorro-antd/message";
import {AuthService} from "../auth.service";

@Injectable()
@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {
  constructor(
    private _route: ActivatedRoute,
    private http: HttpClient,
    private message: NzMessageService,
    public authService: AuthService
  ) {
  }

  // Project params
  projectId: string;
  project: {
    id: number;
    name: string;
    users: string[];
  };

  // File params
  files: SourceFile[] = [];
  selected_file: SourceFile = new SourceFile(0, '', '');
  new_filename: string = '';
  compiler_out: string = '';

  // Interactive params
  isCollapsed = false;
  fileSelected = false;
  editorOptions = {theme: 'vs-light', language: 'c', readOnly: true};
  isVisible = false;
  shareUser: string = '';

  /**
   * On initialization open the desired project with id projectID
   */
  ngOnInit(): void {
    this._route.params.subscribe(params => {
      this.projectId = params['projectId'];
    });
    this.getProject(this.projectId);
    this.getFiles();
  }

  /**
   * Fetch the currently opened project
   * @param id - projectId
   */
  getProject(id: string) {
    // Function to identify project
    function identify(element, index, array) {
      return (array[index].id == id);
    }

    this.http.get<Project[]>('/api/projects/all')
      .pipe(
        tap(_ => console.log('fetching project name successful')),
        catchError(this.handleError<Project[]>('getProjects', []))
      ).subscribe(
      projects => this.project = projects.filter(identify)[0]
    );
  }

  /**
   * Fetch all files from the server
   */
  getFiles(): void {
    this.http.get<SourceFile[]>(`/api/projects/${this.projectId}/source_files`)
      .pipe(
        tap(_ => console.log('fetching source files successful')),
        catchError(this.handleError<SourceFile[]>('getFiles', []))
      ).subscribe(
      files => this.files = files
    );
  }

  /**
   * ALL COPYRIGHTS FOR THIS METHOD TO: https://angular.io/tutorial/toh-pt6
   * Handle Http operation that failed. Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      //Log error, should be remote and not local
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result
      return of(result as T);
    };
  }

  /**
   * Add new files to the backend and update the frontend file list
   */
  newFile(): void {
    // optionally generate standard name
    if (this.new_filename == '') {
      // check for duplicate names
      this.getFiles();
      let i = 0;
      for (let j = 0; j < this.files.length; j++) {
        if (this.files[j].name.indexOf('file_' + i + '.c') > -1) {
          i++;
          j = -1;
        }
      }
      this.new_filename = 'file_' + i + '.c';
    }

    const index = this.new_filename.lastIndexOf('.');
    let language = '';
    if (index > 0) {
      language = this.new_filename.substring(index + 1);
    }
    const name = this.new_filename.substring(0, index);
    let sourceC = '';
    if (language === 'c') {
      sourceC = '#include<stdio.h>\n' +
        '\n' +
        'int main() {\n' +
        '\tprintf("Hello World\\n");\n' +
        '\treturn 0;\n' +
        '}';
    } else if (language === 'java') {
      sourceC = 'public class ' + name + ' {\n' +
        '    public static void main(String[] args) {\n' +
        '        System.out.println("Hello, World!");\n' +
        '    }\n' +
        '}';
    } else {
       sourceC = 'This language is not supported!';
    }

    // generate new file
    const new_file = {
      name: this.new_filename,
      sourceCode: sourceC
    };
    this.new_filename = '';

    // add file to backend and reload frontend list
    this.http.post<Map<String, String>>(`/api/projects/${this.projectId}/source_files`, new_file, {}).pipe(
      tap(_ => console.log(console.log('added new file: ' + new_file.name))),
      catchError(this.handleError<String>('newFile'))
    ).subscribe();

    // update the file list
    this.getFiles();
  }

  /**
   * Load the currently selected source file
   * @param id
   */
  loadFile(id: number) {
    // identify selected file
    function identify(element, index, array) {
      return (array[index].id == id);
    }

    // load in code
    this.selected_file = this.files.filter(identify)[0];
    console.log('Displaying file: ' + this.selected_file.name);
    this.fileSelected = true;

    // change syntax highlighting for the respective language
    this.editorOptions = {
      ...this.editorOptions,
      language: this.selected_file.name.split('.')[1],
      readOnly: !this.fileSelected
    };
  }

  /**
   * Delete a specified file from the project
   */
  deleteFile(): void {
    // Re-load file list from backend for stability
    this.getFiles();

    // Delete file
    this.http.delete(`/api/projects/${this.projectId}/source_files/${this.selected_file.id}`, {responseType: "text"}).pipe(
      tap(_ => console.log(`deleted file id ${_}`)),
      catchError(this.handleError<number>('deleteFile'))
    ).subscribe();
    this.message.create('success', 'File ' + this.selected_file.name + ' deleted!');

    // Update the file list and selected
    this.selected_file = new SourceFile(0, '', '');
    this.fileSelected = false;
    this.editorOptions = {...this.editorOptions, readOnly: !this.fileSelected};
    this.getFiles();
  }

  /**
   * Save a file to the persisted database
   */
  saveFile(): void {
    // Send update request to database
    this.http.put(`/api/projects/${this.projectId}/source_files`, this.selected_file, {responseType: "json"}).pipe(
      tap(_ => console.log(`saved file id=${this.selected_file.id}`)),
      catchError(this.handleError<any>('saveFile'))
    ).subscribe();
    this.message.create('success', 'Saved file ' + this.selected_file.name + '!');
  }

  /**
   * Compile the current source file
   */
  compile(): void {
    // Save file before compiling
    this.saveFile();

    // Notify user about compiling
    this.compiler_out = '';
    const id = this.message.loading('Compiling ' + this.selected_file.name + '...', {nzDuration: 0}).messageId;
    setTimeout(() => {
      this.message.remove(id);
    }, 1250);

    // generate matching file for compiler
    let sourceCode = {
      code: this.selected_file.sourceCode,
      fileName: this.selected_file.name,
      stdout: '',
      stderr: '',
    }

    // compile selected file with the compiler microservice
    this.http.post<any>(`/compile`, sourceCode).pipe(
      tap(_ => console.log(console.log('compiled file: ' + this.selected_file.name))),
      catchError(this.handleError<String>('newFile'))
    ).subscribe(compiledFile => this.compiler_out = this.compiler_out.concat(compiledFile.stdout, compiledFile.stderr));
  }

  /**
   * Switch between light and dark colored editor
   */
  darkMode() { // TODO: Add microcontroller support
    if (this.editorOptions.theme == 'vs-light') {
      this.editorOptions = {...this.editorOptions, theme: 'vs-dark'};
    } else {
      this.editorOptions = {...this.editorOptions, theme: 'vs-light'};
    }
  }

  /**
   * Cancel the sharing process
   */
  handleCancel(): void {
    this.shareUser = '';
    this.isVisible = false;
  }

  /**
   * Share a project with the specified user
   */
  handleOk(): void {
    // add new user to local entity
    this.project.users.push(this.shareUser);

    // push local project entity to project service
    this.http.put('/api/projects', this.project, {responseType: "json"}).pipe(
      tap(_ => console.log(`updated project`)),
      catchError(this.handleError<any>('updateProjects'))
    ).subscribe();

    // pull server project entity to ensure backend persistence (i.e. shared user was rejected)
    this.getProject(this.projectId);

    // reset user functionality
    this.shareUser = '';
    this.isVisible = false;
  }

  /**
   * Open sharing dialog
   */
  showModal(): void {
    this.isVisible = true;
  }
}
