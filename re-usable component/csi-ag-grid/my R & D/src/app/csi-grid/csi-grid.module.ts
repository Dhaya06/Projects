import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CsiGridComponent } from './csi-grid.component';
import { MyGridApplicationComponent } from '../my-grid-application/my-grid-application.component';
import { RedComponentComponent } from '../red-component/red-component.component';
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from "@angular/forms";
import {  DetailCellRenderer } from '../detail-cell-render-agent/detail-cell-render-agent.component';
import { BrowserModule } from "@angular/platform-browser";
import { EditorRendererComponent } from '../editor-renderer/editor-renderer.component';
import { ConditionEditComponent } from '../condition-edit/condition-edit.component';

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule, // <-- import the FormsModule before binding with [(ngModel)]
    HttpClientModule,
    AgGridModule.withComponents(
      [DetailCellRenderer,ConditionEditComponent]
  )
  
  ],
  declarations: [CsiGridComponent,
    MyGridApplicationComponent,
    RedComponentComponent,DetailCellRenderer],
    exports:[CsiGridComponent ],
})
export class CsiGridModule { }
