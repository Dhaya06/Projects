import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CsiAgGridComponent } from './csi-ag-grid.component';
import {BrowserModule} from "@angular/platform-browser";
import {AgGridModule} from "ag-grid-angular/main";
import { CellRenderComponent } from '../cell-render/cell-render.component';
@NgModule({
  imports: [
    CommonModule,        
    AgGridModule.withComponents([CellRenderComponent]),
   ],
   
  declarations: [CsiAgGridComponent,
    CellRenderComponent],
  exports:[CsiAgGridComponent]
})
export class CsiAgGridModule { }
