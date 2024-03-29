import { Component, OnInit } from '@angular/core';
import {Project} from '../project';
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of, throwError} from 'rxjs';
import {catchError, retry, tap, map} from 'rxjs/operators';
import {AuthService} from "../auth.service";

@Injectable()
@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  constructor(private http: HttpClient, public authService: AuthService) { }

  projects: Project[] = [];
  editId: string | null = null;

  /**
   * Starting to edit name cell
   * @param id - id of project that gets edited
   */
  startEdit(id: string): void {
    this.editId = id;
    console.log(this.projects);
  }

  /**
   * End to edit name cell. Changes are persisted in database
   */
  stopEdit(): void {
    // Send update request to database
    this.http.put('/api/projects', this.projects.find(i => i.id.toString() === this.editId), {responseType: "json"}).pipe(
      tap(_ => console.log(`updated project id=${this.editId}`)),
      catchError(this.handleError<any>('updateProjects'))
    ).subscribe();
    this.editId = null;
  }

  /**
   * Adding a new project to the persisted database and display in frontend
   */
  addRow(): void {
    // Re-load projects list from backend for stability
    this.getProjects();

    // Check for duplicate names
    let i = 0;
    for(let j = 0; j<this.projects.length; j++){
      if (this.projects[j].name.indexOf('New Project ' + i) > -1){
        i++;
        j = -1;
      }
    }
    const new_project = 'New Project ' + i;

    // Add project to backend and reload frontend list
    this.http.post<String>('/api/projects', new_project).pipe(
      tap(_ => console.log(console.log('added new project:' + new_project))),
      catchError(this.handleError<String>('newProject'))
      ).subscribe();

    // Update the project list
    this.getProjects();
    //window.location.reload(); // activate for improved stability (costing usability)
  }

  /**
   * Delete a project from the database and frontend
   *
   */
  deleteRow(id: number): void {
    // Re-load projects list from backend for stability
    this.getProjects();

    // Delete project
    this.http.delete(`/api/projects/${id}`, {responseType: "text"}).pipe(
      tap(_ => console.log(`deleted project id=${id}`)),
      catchError(this.handleError<number>(`deleteProject`))
    ).subscribe();

    // Update the project list
    this.getProjects();
    //window.location.reload(); // activate for improved stability (costing usability)
  }


  /**
   * Get all projects from backend server
   * Inspired by: https://angular.io/tutorial/toh-pt6
   */
  getProjects(): void {
    // Fetch project list from server
    this.http.get<Project[]>('/api/projects/all')
      .pipe(
        tap(_ => console.log('fetching projects successful')),
        catchError(this.handleError<Project[]>('getProjects', []))
      ).subscribe(
        projects => this.projects = projects
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
   * Component initializing function that loads all persisted projects from backend
   */
  ngOnInit(): void {
    this.getProjects();
  }
}
