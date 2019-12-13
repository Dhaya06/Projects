import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { CsiAgGridModule } from './csi-ag-grid/csi-ag-grid.module';
import { CellRenderComponent } from './cell-render/cell-render.component';
import {AgGridModule} from "ag-grid-angular/main";
import { CellEditorComponent } from './cell-editor/cell-editor.component';
import { GridService } from './grid-service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CellRenderer2Component } from './cell-renderer-2/cell-renderer-2.component';

@NgModule({
  declarations: [
    AppComponent,
    CellEditorComponent,
    CellRenderer2Component
  ],
  imports: [
    BrowserModule,
    CsiAgGridModule,
    AgGridModule.withComponents([CellRenderComponent,
      CellEditorComponent, CellRenderer2Component]),
    FormsModule
  ],
  providers: [GridService],
  bootstrap: [AppComponent]
})
export class AppModule { }
