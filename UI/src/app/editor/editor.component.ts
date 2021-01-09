import {Component, Injectable, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {SourceFile} from "../sourcefile";
import {catchError, tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";

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
  editorOptions = {theme: 'vs-light', language: 'javascript'};
  code = 'function x() {\nconsole.log("Hello world!");\n}';
  projectId: string;
  isCollapsed = false;
  files: SourceFile[] = [];
  private BASE_URL = 'http://localhost:4200' // TODO: no absolute links

  /**
   * On initialization open the desired project with id projectID
   */
  ngOnInit(): void {
    this._route.params.subscribe(params => {
      this.projectId = params['projectId'];
    });
    this.getFiles();
  }

  saveFile(): void{
  }

  compile(): void {
  }

  newFile(): void {
  }

  shareProject(): void {
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

  deleteFile() : void {

  }

  /**
   * Fetch all files from the server
   */
  getFiles() : void{
    console.log(this.files);
    this.http.get<SourceFile[]>(`${this.BASE_URL}/projects/${this.projectId}/source_files`)
      .pipe(
        tap(_ => console.log('fetching source files successful')),
        catchError(this.handleError<SourceFile[]>('getFiles', []))
      ).subscribe(
      files => this.files = files
    );
    console.log(this.files);
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
}
