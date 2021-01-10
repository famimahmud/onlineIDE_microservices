import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NzLayoutModule } from 'ng-zorro-antd/layout';

import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProjectListComponent } from './project-list/project-list.component';
import { StartScreenComponent } from './start-screen/start-screen.component';
import { EditorComponent } from './editor/editor.component';
import {Route, RouterModule} from '@angular/router';
import {MonacoEditorModule} from 'ngx-monaco-editor';
import { NzButtonModule } from 'ng-zorro-antd/button';
import {NzTableModule} from 'ng-zorro-antd/table';
import {NzPopconfirmModule} from 'ng-zorro-antd/popconfirm';
import {NzGridModule} from 'ng-zorro-antd/grid';
import {NzIconModule} from 'ng-zorro-antd/icon';
import {NzBreadCrumbModule} from 'ng-zorro-antd/breadcrumb';
import {NzMenuModule} from 'ng-zorro-antd/menu';
import { NzInputModule } from 'ng-zorro-antd/input';

registerLocaleData(en);

const routes: Route[] = [
  {path: '', pathMatch: 'full', redirectTo: 'start'},
  {path: 'start', component: StartScreenComponent},
  {path: 'project-list', component: ProjectListComponent},
  {path: 'editor/:projectId', component: EditorComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    StartScreenComponent,
    EditorComponent
  ],
  imports: [
    BrowserModule,
    NzPopconfirmModule,
    NzBreadCrumbModule,
    NzTableModule,
    NzInputModule,
    FormsModule,
    NzGridModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzLayoutModule,
    NzButtonModule,
    RouterModule.forRoot(routes),
    MonacoEditorModule.forRoot(),
    NzIconModule,
    NzMenuModule
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent]
})
export class AppModule { }
