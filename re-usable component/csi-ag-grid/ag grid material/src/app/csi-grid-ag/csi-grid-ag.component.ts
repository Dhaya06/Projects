import { Component, OnInit } from '@angular/core';
import { GridOptions } from "ag-grid/main";
import { AgGridMaterialTextEditorComponent } from "./ag-grid-material-text-editor/ag-grid-material-text-editor.component";
import { AgGridMaterialSelectEditorComponent } from "./ag-grid-material-select-editor/ag-grid-material-select-editor.component";
import { AgGridMaterialDatepickerEditorComponent } from "./ag-grid-material-datepicker-editor/ag-grid-material-datepicker-editor.component";
import { AgGridMaterialCheckboxCellComponent } from "./ag-grid-material-checkbox-cell/ag-grid-material-checkbox-cell.component";
import * as moment from 'moment';

@Component({
  selector: 'csi-grid-ag',
  templateUrl: './csi-grid-ag.component.html',
  styleUrls: ['./csi-grid-ag.component.scss']
})
export class CsiGridAgComponent implements OnInit {

  ngOnInit(): void {
    
  }
  private gridOptions:GridOptions = <GridOptions>{
    enableSorting: true,
    rowSelection: 'multiple',
    suppressRowClickSelection: true
};
public rowData:any[];
public gridApi ;
public gridColumnApi;
private columnDefs:any[];


constructor() {
    this.columnDefs = [
        {
            headerName: ' ',
            
            cellRendererFramework: AgGridMaterialCheckboxCellComponent,
            width: 80
        },
        {
            headerName: "Make", 
            field: "make", 
            editable: true, 
            cellEditorFramework: AgGridMaterialSelectEditorComponent ,
            cellEditorParams: {values: [ 'Toyota', 'Ford', 'Porsche' ]} 
        },
        {
            headerName: "Model", 
            field: "model", 
            editable: true, 
            cellEditorFramework: AgGridMaterialTextEditorComponent 
        },
        {   headerName: "Price", 
            field: "price"
        },
        {
            headerName: "Made on", 
            field: "madeOn", 
            editable: true, 
            cellEditorFramework: AgGridMaterialDatepickerEditorComponent,
            valueFormatter: (data) => moment(data.value).format('L')
        },
    ];
}

 createNewRowData() {
    var newData = {
        make: "Jeep <img style='width:50px;height:38px' src='assets/arrow-right.png' />  ",
         model: "Hummer", 
         price: 35000, 
         madeOn: new Date(2006, 10, 25)
    };
    
    return newData;
  }
onGridReady(params) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
    console.log(params);
    this.rowData = [
        {make: "Toyota", model: "Celica", price: 35000, madeOn: new Date(2006, 10, 25)},
        {make: "Ford", model: "Mondeo", price: 32000,  madeOn: new Date(2016, 2, 13)},
        {make: "Porsche", model: "Boxter", price: 72000, madeOn: new Date(2010, 7, 10)}
    ]
      params.api.setRowData(this.rowData);
    
}   

printResult(res) {
    console.log("---------------------------------------");
    if (res.add) {
      res.add.forEach(function(rowNode) {
        console.log("Added Row Node", rowNode);
      });
    }
    if (res.remove) {
      res.remove.forEach(function(rowNode) {
        console.log("Removed Row Node", rowNode);
      });
    }
    if (res.update) {
      res.update.forEach(function(rowNode) {
        console.log("Updated Row Node", rowNode);
      });
    }
}

addRow()
{
    debugger;
    for(let item of this.selectedRows)
    {
        //to verification function 

        
        var newItem = this.createNewRowData();
        var res = item.gridApi.updateRowData({
          add: [newItem],
          addIndex: 0
        });
    }

    //if you have only one row to be add use this method. 
    // var newItem = this.createNewRowData();
    // var res = this.gridApi.updateRowData({
    //   add: [newItem],
    //   addIndex: 2
    // });
    // this.printResult(res);
}


selectedRows:any []=[];
onRowSelected($event)
{     
        if($event.node.selected)
        {
            this.selectedRows.push($event.node);
        }
                  
}


deleteRow() {
    var selectedData = this.gridApi.getSelectedRows();
    var res = this.gridApi.updateRowData({ remove: selectedData });
    this.printResult(res);
  }


}
