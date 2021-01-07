import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  constructor() { }
  editorOptions = {theme: 'vs-light', language: 'javascript'}; // TODO: Add darkmode and languages
  code = 'function x() {\nconsole.log("Hello world!");\n}';

  isCollapsed = false;

  ngOnInit(): void {
  }

  saveFile(): void{
    // TODO: add functionality
  }

  compile(): void {
     // TODO: add functionality
  }

  newFile(): void {
    // TODO: add functionality
  }

  ShareProject(): void {
    // TODO: add functionality
  }
}
