import { Component, OnInit } from '@angular/core';
import {Project} from '../project';
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable()
export class ConfigService {
  constructor(private http: HttpClient) { }
}

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  constructor() { }

  i = 0;
  projects: Project[] =  [];
  editId: string | null = null;

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

  ngOnInit(): void {
    /*HttpClient.get(
      "jdbc:postgresql://localhost:5432/my_db", // TODO: no hard coding
      {headers: HttpHeaders | {[header: string]: string | string[]},
        observe: 'body' | 'events' | 'response',
        params: HttpParams|{[param: string]: string | string[]},
        reportProgress: boolean,
        responseType: 'arraybuffer'|'blob'|'json'|'text',
        withCredentials: boolean,
    }
    )*/
  }
}
