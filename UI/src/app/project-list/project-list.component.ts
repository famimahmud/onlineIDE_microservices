import { Component, OnInit } from '@angular/core';
import {Project} from '../project';
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of, throwError} from 'rxjs';
import {catchError, retry, tap, map} from 'rxjs/operators';

@Injectable()
@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  constructor(private http: HttpClient) { }

  i = 0;
  projects: Project[] =  [];
  editId: string | null = null;
  private BASE_URL = 'http://localhost:8080' // TODO: no absolute links

  startEdit(id: string): void {
    this.editId = id;
  }

  stopEdit(): void {
    this.editId = null;
  }

  addRow(): void {
    this.projects = [
      ...this.projects,
      {
        id: this.i,
        name: `Project ${this.i}`,
      }
    ];
    this.i++;
  }

  deleteRow(id: number): void {
    this.projects = this.projects.filter(d => d.id !== id);
  }

  getProjects(): Observable<Project[]> {
    const url = this.BASE_URL + '/projects/all';
    return this.http.get<Project[]>(url)
      .pipe(
        tap(_ => console.log('fetched projects')),
        catchError(this.handleError<Project[]>('getProjects', []))
      );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


  ngOnInit(): void {
    this.getProjects().subscribe(projects => this.projects = projects);
  }
}
