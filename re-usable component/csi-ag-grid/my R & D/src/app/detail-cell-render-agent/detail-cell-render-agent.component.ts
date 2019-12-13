import { Component, OnInit } from '@angular/core';
import {ICellRendererAngularComp} from "ag-grid-angular";
import { IAfterGuiAttachedParams } from 'ag-grid';

@Component({
  selector: 'app-detail-cell-render-agent',
  templateUrl: './detail-cell-render-agent.component.html',
  styleUrls: ['./detail-cell-render-agent.component.css']
})
export class DetailCellRenderer  implements ICellRendererAngularComp  {

  refresh(params: any): boolean {
    return false;
}
  afterGuiAttached?(params?: IAfterGuiAttachedParams): void {
   
  }
  ngOnInit(): void {
    
  }
  params: any;
  colDefs: any;
  rowData:any;
  agInit(params: any): void {
     this.params = params;
     console.log(this.params);
    // this.colDefs = [
    //     {field: 'callId'},
    //     {field: 'direction'},
    //     {field: 'number'},
    //     {field: 'duration', valueFormatter: "x.toLocaleString() + 's'"},
    //     {field: 'switchCode'}
    // ];
  //  this.rowData = params.data.callRecords;
}

// called when the cell is refreshed


}
