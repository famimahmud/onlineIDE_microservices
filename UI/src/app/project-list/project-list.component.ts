import { Component, OnInit } from '@angular/core';
import {Project} from '../project';

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
        id: this.i, //TODO: get out of database?
        name: `Project ${this.i}`,
        users: 1, //TODO: get out of database?
      }
    ];
    this.i++;
  }

  deleteRow(id: number): void {
    this.projects = this.projects.filter(d => d.id !== id);
  }

  ngOnInit(): void {
    this.addRow();
    this.addRow();
  }
}
