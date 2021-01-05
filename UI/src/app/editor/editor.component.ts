import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {
  editorOptions = {theme: 'vs-dark', language: 'javascript'}; //TODO: Add darkmode
  code = 'function x() {\nconsole.log("Hello world!");\n}';

  constructor() { }

  ngOnInit(): void {
  }

  isCollapsed = false;

  saveFile() {
      //TODO: add functionality
  }

  compile() {
    //TODO: add functionality
  }

  newFile() {
    //TODO: add functionality
  }

  ShareProject() {
    //TODO: add functionality
  }
}
