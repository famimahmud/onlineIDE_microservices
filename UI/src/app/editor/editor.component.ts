import {Component, Injectable, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {SourceFile} from "../sourcefile";
import {catchError, tap} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Project} from "../project";
import { NzInputModule } from 'ng-zorro-antd/input';

@Injectable()
@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {
  constructor(
    private _route: ActivatedRoute,
    private http: HttpClient
  ) { }

  // Static params
  private BASE_URL = 'http://localhost:4200' // TODO: no absolute links

  // Project params
  projectId: string;
  projectName: string;

  // File params
  files: SourceFile[] = [];
  selected_file : SourceFile = new SourceFile(0, '', '');
  new_filename: string = '';

  // Interactive params
  isCollapsed = false;
  fileSelected = false;
  editorOptions = {theme: 'vs-light', language: 'c', readOnly: true};

  /**
   * On initialization open the desired project with id projectID
   */
  ngOnInit(): void {
    this._route.params.subscribe(params => {
      this.projectId = params['projectId'];
    });
    this.getProjectName(this.projectId);
    this.getFiles();
  }

  /**
   * Fetch the name of the currently opened project
   * @param id - projectId
   */
  getProjectName(id : string) {
    // Function to identify project
    function identify(element, index, array) {
      return (array[index].id == id);
    }

    // Fetch project list from server
    this.http.get<Project[]>(`${this.BASE_URL}/projects/all`)
      .pipe(
        tap(_ => console.log('fetching project name successful')),
        catchError(this.handleError<Project[]>('getProjects', []))
      ).subscribe(
      projects => this.projectName = projects.filter(identify)[0].name
    );
  }

  /**
   * Fetch all files from the server
   */
  getFiles() : void{
    this.http.get<SourceFile[]>(`${this.BASE_URL}/projects/${this.projectId}/source_files`)
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
    if (this.new_filename == ''){
      // check for duplicate names
      this.getFiles();
      let i = 0;
      for(let j = 0; j<this.files.length; j++){
        if (this.files[j].name.indexOf('file_' + i + '.c') > -1){
          i++;
          j = -1;
        }
      }
      this.new_filename = 'file_' + i + '.c';
    }

    // generate new file
    const new_file = {
      name: this.new_filename,
      sourceCode : 'function x() {\n\tconsole.log("Hello world!");\n}',
    }
    this.new_filename = '';

    // add file to backend and reload frontend list
    this.http.post<Map<String, String>>(`${this.BASE_URL}/projects/${this.projectId}/source_files`, new_file, {}).pipe(
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
    this.editorOptions = {...this.editorOptions, language: this.selected_file.name.split('.')[1], readOnly: !this.fileSelected};
  }

  /**
   * Delete a specified file from the project
   */
  deleteFile() : void {
    // Re-load file list from backend for stability
    this.getFiles();

    // Delete file
    this.http.delete(`${this.BASE_URL}/projects/${this.projectId}/source_files/${this.selected_file.id}`, {responseType: "text"}).pipe(
      tap(_ => console.log(`deleted file id ${_}`)),
      catchError(this.handleError<number>('deleteFile'))
    ).subscribe();

    // Update the file list and selected
    this.selected_file = new SourceFile(0, '', '');
    this.fileSelected = false;
    this.editorOptions = {...this.editorOptions, readOnly: !this.fileSelected};
    this.getFiles();
  }

  /**
   * Save a file to the persisted database
   */
  saveFile(): void{
    // Send update request to database
    this.http.put(`${this.BASE_URL}/projects/${this.projectId}/source_files`, this.selected_file, {responseType: "json"}).pipe(
      tap(_ => console.log(`saved file id=${this.selected_file.id}`)),
      catchError(this.handleError<any>('saveFile'))
    ).subscribe();
  }

  /**
   * Compile the current source file
   */
  compile(): void {
    this.saveFile();
    // TODO: Compile file
  }

  /**
   * Switch between light and dark colored editor
   */
  darkMode() { // TODO: Add microcontroller support
    if(this.editorOptions.theme == 'vs-light') {
      this.editorOptions = {...this.editorOptions, theme: 'vs-dark'};
    }
    else {
      this.editorOptions = {...this.editorOptions, theme: 'vs-light'};
    }
  }

  /**
   * Function to share the current project with other GitLab users
   */
  shareProject(): void { // TODO: implement sharing functionality
  }
}
