import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CsiGridAgComponent } from './csi-grid-ag.component';
// import {  AgGridModule } from 'ag-grid-angular';
import { AgGridMaterialTextEditorComponent } from './ag-grid-material-text-editor/ag-grid-material-text-editor.component';
import { AgGridMaterialSelectEditorComponent } from './ag-grid-material-select-editor/ag-grid-material-select-editor.component';
import { AgGridMaterialCheckboxCellComponent } from './ag-grid-material-checkbox-cell/ag-grid-material-checkbox-cell.component';
import { AgGridMaterialDatepickerEditorComponent } from './ag-grid-material-datepicker-editor/ag-grid-material-datepicker-editor.component';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { FormsModule } from '@angular/forms';

// import { AppRoutingModule } from './app-routing.module';

// material components
import {MdIconModule, MdButtonModule, MdCheckboxModule, MdInputModule, MdToolbarModule, MdCardModule, MdSelectModule, MdDatepickerModule, MdNativeDateModule} from '@angular/material';

import {AgGridModule} from "ag-grid-angular/main";
@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    MdButtonModule, 
    MdCheckboxModule,
    MdIconModule,
    MdInputModule,
    MdToolbarModule,
    MdCardModule,
    MdSelectModule,
    MdDatepickerModule,
    MdNativeDateModule,
    AgGridModule.withComponents([
      AgGridMaterialTextEditorComponent,
      AgGridMaterialSelectEditorComponent,
      AgGridMaterialCheckboxCellComponent,
      AgGridMaterialDatepickerEditorComponent
  ])
]
  ,
  declarations: [CsiGridAgComponent,
    AgGridMaterialTextEditorComponent,
    AgGridMaterialSelectEditorComponent,
    AgGridMaterialCheckboxCellComponent,
    AgGridMaterialDatepickerEditorComponent,],
    exports:[CsiGridAgComponent]
})
export class CsiGridAgModule { }
