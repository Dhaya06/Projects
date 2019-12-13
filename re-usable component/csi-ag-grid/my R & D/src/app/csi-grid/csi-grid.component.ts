import { Component, OnInit, Input,ViewChild  } from '@angular/core';
import { RedComponentComponent } from "../red-component/red-component.component";
import {  Headers, Response } from '@angular/http';
import { HttpClient } from "@angular/common/http";
import { GridOptions } from "ag-grid/main";
import { DetailCellRenderer  } from '../detail-cell-render-agent/detail-cell-render-agent.component';
import {Observable} from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { GridService } from './grid-service';
import { EditorRendererComponent } from '../editor-renderer/editor-renderer.component';
import { EditorDateTimeComponent } from '../editor-date-time/editor-date-time.component';
import { IsEditCheckComponent } from '../is-edit-check/is-edit-check.component';
import { ConditionEditComponent } from '../condition-edit/condition-edit.component';
// import { FILE } from 'dns';
@Component({
  selector: 'app-csi-grid',
  templateUrl: './csi-grid.component.html',
  styleUrls: ['./csi-grid.component.scss']
})
export class CsiGridComponent implements OnInit {

  firstGrid=true;
  @Input() private gridOptions: GridOptions;

  @Input() public columnDefs: any[]
  @Input() public rowData: any[];
  @Input() public groupDefaultExpanded;
  @Input() public getDataPath;
  @Input() public autoGroupColumnDef;
  @Input() public columnTypes;
  @Input() public defaultColDef;
  @Input() public defaultColGroupDef;
  private selectedRows :any []=[];
  private selectedNode:any[]=[];
  private getRowHeight;
  ngOnInit(): void {
  }

  constructor(private http: HttpClient, private gridService:GridService) {

    
    this.gridOptions = <GridOptions>{};

    //this is to enable tree data
    this.gridOptions.treeData = true;
  
    this.gridOptions.enableFilter = true;
    this.columnDefs =
      [
     
        { headerName: "Jobsy", field: "jobTitle", cellRendererFramework: RedComponentComponent },
        { field: "employmentType" }];

    this.gridOptions.enableSorting = true;
    this.gridOptions.floatingFilter = true;
    this.rowData =[
      {
        orgHierarchy: ["Erica Rogers"],
        jobTitle: "CEO",
        employmentType: "Permanent"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett"],
        jobTitle: "Exec. Vice President",
        employmentType: "Permanent"
      },{
        orgHierarchy: ["Erica Rogers", ""],
        jobTitle: "Exec. Vice President",
        employmentType: "Permanent"
      },
      {
        orgHierarchy: ["Erica Rogers", "",""],
        jobTitle: "Exec. Vice President",
        employmentType: "Permanent"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Esther Baker"],
        jobTitle: "Director of Operations",
        employmentType: "Permanent"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Esther Baker", "Brittany Hanson"],
        jobTitle: "Fleet Coordinator",
        employmentType: "Permanent"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Esther Baker", "Brittany Hanson", "Leah Flowers"],
        jobTitle: "Parts Technician",
        employmentType: "Contract"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Esther Baker", "Brittany Hanson", "Tammy Sutton"],
        jobTitle: "Service Technician",
        employmentType: "Contract"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Esther Baker", "Derek Paul"],
        jobTitle: "Inventory Control",
        employmentType: "Permanent"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Francis Strickland"],
        jobTitle: "VP Sales",
        employmentType: "Permanent"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Francis Strickland", "Morris Hanson"],
        jobTitle: "Sales Manager",
        employmentType: "Permanent"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Francis Strickland", "Todd Tyler"],
        jobTitle: "Sales Executive",
        employmentType: "Contract"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Francis Strickland", "Bennie Wise"],
        jobTitle: "Sales Executive",
        employmentType: "Contract"
      },
      {
        orgHierarchy: ["Erica Rogers", "Malcolm Barrett", "Francis Strickland", "Joel Cooper"],
        jobTitle: "Sales Executive",
        employmentType: "Permanent"
      }
    ];
    this.getRowHeight = function(params) {
      return params.data.account==177001 ? 80:40  ;
    };

    //this is to tell group default expanded
    this.groupDefaultExpanded = -1;


    //this is to get data path of tree data
    this.getDataPath = function (data) {
      return data.orgHierarchy;
    };
    this.autoGroupColumnDef = {
      headerName: "Name of Employee",
      filter: "agTextColumnFilter",
      //  cellRenderer: "agGroupCellRenderer", 
      cellRendererParams: { suppressCount: true,
       checkbox: true},
      
    };


    //this is column types
    this.columnTypes = {
      numberColumn: {
        width: 83,
        filter: "agNumberColumnFilter"
      },
      medalColumn: {
        width: 100,
        columnGroupShow: "open",
        suppressFilter: true
      },
      nonEditableColumn: { editable: false },
      dateColumn: {
        filter: "agDateColumnFilter",
        filterParams: {
          comparator: function (filterLocalDateAtMidnight, cellValue) {
            var dateParts = cellValue.split("/");
            var day = Number(dateParts[2]);
            var month = Number(dateParts[1]) - 1;
            var year = Number(dateParts[0]);
            var cellDate = new Date(day, month, year);
            if (cellDate < filterLocalDateAtMidnight) {
              return -1;
            } else if (cellDate > filterLocalDateAtMidnight) {
              return 1;
            } else {
              return 0;
            }
          }
        }
      }
    };


    this.defaultColDef = {
      width: 150,
      editable: true,
      filter: "agTextColumnFilter"
    };
    //this.defaultColGroupDef = { marryChildren: true };


//+++++++++++++++++++++++++++   
    //initiating second grid
   this.SecondCtor();
    //+++++++++++++++++++++++++++
  }

  onGridReady(params) {
    params.api.sizeColumnsToFit();
  }

  selectAllRows() {
    this.gridOptions.api.selectAll();
  }


  //second grid starts here
  private gridApi;
  private gridColumnApi;
  private columnDefs2;
  private gridOptions2: GridOptions;
  private detailCellRendererParams;
  private detailCellRendererParams2;
  private detailCellRenderAgent;
  private frameworkComponents;
  private Items=[1,2,3,4];
  private selectedItemaBeforeEditClick:any[]=[];
  nGridReady2(params) {
    params.api.sizeColumnsToFit();
  }

  SecondCtor() {
    

    this.gridOptions2 = <GridOptions>{};
    // this.gridOptions2.rowModelType = 'infinite';
    //this enables server side pagination with latest machanism as
    //it mentioned in ag grid documentation. check infinite scrolling for 
    //enterprice edition
    this.detailCellRenderAgent = "myDetailCellRenderer";
    this.frameworkComponents = { myDetailCellRenderer: DetailCellRenderer  };
    
    this.columnDefs2 = [
      { headerName: "Name of the Employee ",
      headerTooltip:"Employee Name",
        field: "name",
        cellRenderer: "agGroupCellRenderer",
        
        editable: false,
        checkboxSelection: true,
        headerCheckboxSelection: true,
      },
      { field: "account",editable:true,
      cellRendererFramework: RedComponentComponent },
      { field: "calls",editable: true ,
      cellEditorFramework: EditorDateTimeComponent
      // cellEditorFramework: EditorRendererComponent,
      },
      {
        field: "minutes",
        cellRendererFramework: IsEditCheckComponent,
        cellEditorFramework: ConditionEditComponent,
        editable:true
        //valueFormatter: "x.toLocaleString() + 'm'"
      }
    ];

    
    //=+++++++++++++++++++++++++++
    this.detailCellRendererParams2 = {
      detailGridOptions: {
         columnDefs: [
          { field: "switchCode"},
         { field: "direction"}
        
        ],
        onGridReady: function (params) {
          params.api.sizeColumnsToFit();
        },
        floatingFilter:true,
      },
      getDetailRowData: function (params) {
        // console.log(params.data);
        params.successCallback(params.data);
      },
      template: function (params) {
        //console.log(params.data);
        var personName = params.data.name;
        return (
          '<div style="height: 100%; background-color: #EDF6FF; padding: 20px; box-sizing: border-box;">' +
          '  <div style="height: 10%;">Name: ' +
          personName +
          "</div>" +
         '  <div ref="eDetailGrid" style="height: 80%;"></div>' +
          "</div>"
        );
      }
    };

//=++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    this.detailCellRendererParams = {
      detailGridOptions: {
         columnDefs: [
          { field: "callId" ,  cellRenderer: "agGroupCellRenderer",    checkboxSelection: true,},
          { field: "direction" },
          { field: "number" },
          {
            field: "duration",
            valueFormatter: "x.toLocaleString() + 's'"
          },
          { field: "switchCode" }
        ],
        onGridReady: function (params) {
       //   params.api.sizeColumnsToFit();
          //params.api.getSelectedRow;
        },
        floatingFilter:true,
        masterDetail:true,
        detailCellRendererParams:this.detailCellRendererParams2,
      },
      getDetailRowData: function (params) {
        params.successCallback(params.data.callRecords);
      },
      template: function (params) {
        var personName = params.data.name;
       
        return (
          '<div style="height: 100%; background-color: #EDF6FF; padding: 20px; box-sizing: border-box;">' +
          '  <div style="height: 10%;">Name: ' +
          personName +
          "</div>" +
          '  <div ref="eDetailGrid" style="height:100%;"></div>' +
          "</div>"
        );
      }
    };
    
   this.gridOptions2.masterDetail=true;
   this.gridOptions2.enableFilter=false;
   this.gridOptions2.enableSorting=false;
    this.gridOptions2.rowHeight=50;
  this.gridOptions2.detailCellRendererParams=this.detailCellRendererParams;
    
  // this.gridOptions2.detailCellRenderer = "myDetailCellRenderer";
  // this.gridOptions2.frameworkComponents= { myDetailCellRenderer: DetailCellRenderer }
  // this.gridOptions2.detailRowHeight = 70;
  // this.gridOptions2.groupDefaultExpanded = 1;


 
  var setter=this.SetIsEditingnVariableValue();
  var getter=this.getIsEditingVariableValue();
   
    this.gridOptions2.getRowStyle = function(params) {
    //   if (params.node.rowIndex % 2 === 0) {
    //     return { background: 'red' }
    //  }
      if (params.node.data.calls>24) {
          return { background: '#F46F6F' }
      }
      else{
        return { background: '' }
      }
    }


    //all rows  assigned with this css class
    this.gridOptions2.rowClass = 'my-green-class';

    // all odd rows assigned 'my-shaded-effect'
    this.gridOptions2.getRowClass = function(params) {
        if (params.node.rowIndex % 2 === 0) {
            return 'my-shaded-effect';
        }
    }


    //this is helpfull when you want to apply multiple css classes with condition
    this.gridOptions2.rowClassRules={
      "sick-days-warning": function(params) {
        //params return each row data. as follow u can access
        var numSickDays = params.data.sickDays;
        return numSickDays > 5 && numSickDays <= 7;
      },
      "sick-days-breach": "data.sickDays > 8"
    };

    var selectedNodeLocal=this.selectedNode;
  var count=0;
    this.gridOptions2.onCellEditingStopped=function($event)
    {
       
  //  console.log("end edit");
    
  //    // console.log($event);
  //    if( selectedNodeLocal && selectedNodeLocal!=undefined)
  //    {
  //      selectedNodeLocal.forEach(element => {
  //        if(element.node.selected)
  //        element.node.gridApi.startEditingCell({
  //          rowIndex: element.node.rowIndex,
  //          colKey: "account"
  //        });
  //      });
  //    }
  //    console.log(selectedNodeLocal);

  //    $event.api.setFocusedCell(selectedNodeLocal[count].rowIndex, "account");
    
  //    count++;
    }

    var node;
    var gridService=this.gridService;
    var localGridOption=this.gridOptions2.columnApi;
    var localGriApi=this.gridApi;
    
    this.gridOptions2.onCellEditingStarted=function($event)
    { 
      if(!gridService.isEditClicked)
      {
        var b:any=this; 
        b.api.forEachNode(function (node) {
          node.gridApi.stopEditing();
          });
      }
      // if(!$event[0].node.selected)
      // {
      //   this.gridApi.stopEditing();
      // }
   
     //console.log($event);
    // setter;
    //   var b:any=this; 
    //  b.api.forEachNode(function (node) {
    //          node.gridApi.startEditingCell({
    //           rowIndex: node.rowIndex,
    //           colKey: "calls"
    //         });
    //       });
          
    //this wil create a functrionality report 
    // b.api.setFocusedCell(0, "calls");
    }
    this.gridOptions2.onRowClicked=function()
    {
      
    }
   
    this.gridOptions2.onCellClicked=function($event)
    {
      // console.log($event);
      // localGridOption.startEditingCell({
      //   rowIndex: $event.rowIndex,
      //   colKey: "minutes"})
      // debugger;

      // var b:any=this; 
      //  b.api.forEachNode(function (node) {
      //          node.gridApi.startEditingCell({
      //           rowIndex: $event.rowIndex,
      //           colKey: "minutes"
      //         });
      //       });


      //localGridOption.columnApi.getColumn('account').getColDef().editable = true;
      // element.node.gridApi.startEditingCell({
      //     rowIndex: element.node.rowIndex,
      //     colKey: "account"
      //   });
     
    //  console.log($event);
    //  if(getter)
    //  {return;}
    //  debugger;
    //  var b:any=this; 
    //  b.api.forEachNode(function (node) {
    //       //console.log(node);
    //         node.gridApi.startEditingCell({
    //           rowIndex: node.rowIndex,
    //           colKey: "calls"
    //         });
    //       });
    }
    this.gridOptions2.isRowSelectable= function(rowNode) {
      return rowNode.data.calls  ==23 ? false: true;
    }
    this.gridOptions2.rowSelection="multiple";
    
    
    //=++++++++++++++GIVE YOUR EDITOR COMPONENTS HERE
    // this.gridOptions2.frameworkComponents={
    //   moodRenderer: MoodRenderer,
    //   moodEditor: MoodEditor,
    //   numericEditor: NumericEditor
    // }
    // in the 'colDef' cellEditor:moodEditor
  }
 
  SetIsEditingnVariableValue()
  {
    this.isEditingModeRequired!=this.isEditingModeRequired;
  
  }

  btSelectedEditTest()
  {
    console.log("btSelectedEditTest CLicked");
    
    console.log(this.selectedRows);
    if( this.selectedNode && this.selectedNode!=undefined)
    {
      this.selectedNode.forEach(element => {
        if(element.node.selected)
        element.node.gridApi.startEditingCell({
          rowIndex: element.node.rowIndex,
          colKey: "account"
        });
      });
    }
    /*
    api.forEachNode(function (node) {
            //console.log(node);
              node.gridApi.startEditingCell({
                rowIndex: node.rowIndex,
                colKey: "calls"
              });
            });
            */

    // this.gridApi.setFocusedCell(0, "account");
    // this.gridApi.startEditingCell({
    //   rowIndex: 4,
    //   colKey: "account"
     
    // });
  }

  //this is to get current edit mode  cell
  onBtWhich() {
    let cellDefs = this.gridApi.getEditingCells();
    if (cellDefs.length > 0) {
      var cellDef = cellDefs[0];
      console.log(
         "editing cell is: row = " +
          cellDef.rowIndex +
          ", col = " +
          cellDef.column.getId() +
          ", floating = " +
          cellDef.floating
      );
    } else {
      console.log("no cells are editing");
    }
  }
  getIsEditingVariableValue()
  {
    return this.isEditingModeRequired;
  }
  modalProperty:any;

  getSelectedRow()
  {
    this.gridApi.stopEditing();
    
    //this.gridService.EditClicked();
    console.log(this.selectedRows);

   this.modalProperty=  this.selectedRows;
    //console.log(this.gridApi.getSelectedNodes());

  }
  
  private getRowNodeId;
  updateCellProgramatically() {
    var rowNode = this.gridApi.getRowNode("aa");
    var newPrice = Math.floor(Math.random() * 100000);
    rowNode.setDataValue("price", newPrice);
  }


  //programatically select grid row based on the row
  selectRowsProgrammatically() {
    this.gridApi.forEachNode(function(node) {
      if (node.data.country === "United States") {
        node.setSelected(true);
      }
    });
  }

 //in this way you can update a specific cell programatically
  updateRowData() {
    var itemsToUpdate = [];
    this.gridApi.forEachNode(function(rowNode) {
      var data = rowNode.data;
      data.sickDays = 23;
      itemsToUpdate.push(data);
    });
    this.gridApi.updateRowData({ update: itemsToUpdate });
  }


  
  onRowSelected($event) {
    // console.log($event);
    if($event.node.selected)
    {console.log('selected');
    
    //rasta
    this.selectedRows.push($event.data);
    if(!this.gridService.isEditClicked)
    {
      this.selectedItemaBeforeEditClick.push($event.data);
    }


    
    this.selectedNode.push($event);
    //console.log(this.selectedRows);
    } 
    else 
    {
      console.log($event.data);
      console.log('deselected')
      
    }


  }

  onSelectionChanged($event) {
  //  console.log($event);
  }


  private grid2Params;
  private editedCels;
  private isEditingModeRequired:boolean=false;
  onGridReady2(params) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
    console.log(params);
    this.http.get('../../assets/dataJson.json').subscribe(data => {
      params.api.setRowData(data);
    });
     
    // this.http
    //   .get(
    //     "https://raw.githubusercontent.com/ag-grid/ag-grid-docs/latest/src/javascript-grid-master-detail/template-callback-customisation/data/data.json"
    //   )
    //   .subscribe(data => {
    //      params.api.setRowData(data);
    //   });
    this.grid2Params=params;
    params.api.sizeColumnsToFit();
    setTimeout(function () {
      var rowCount = 0;
      params.api.forEachNode(function (node) {
     
        //this will expand a column in initiation
       node.setExpanded(rowCount++ === 6);
      });
    }, 500);


    this.SecondCtor();
    var obj= this.getAdvantageData();
     this.getAdvantageData();
  }  //ongridready 2() end

  getAdvantageData(){
     let apiUrl = '../../assets/dataJson.json';

    this.http.get(apiUrl).subscribe(data => {
  
   });
 }
  btStartEditClick(key, char, pinned)
  {
    this.gridService.isEditClicked=false;
    /*
      this.gridApi.startEditingCell({
        rowIndex: 1,
        colKey: "name"
      });
      */
     if(this.gridService.isEditClicked)
     {
      debugger;
      this.selectedItemaBeforeEditClick=this.selectedRows;
  
      this.gridService.selectedItemsBeforeEditClick=this.selectedItemaBeforeEditClick;
     
     }
     else
     {
      this.gridService.selectedItemsBeforeEditClick=this.selectedItemaBeforeEditClick;
      this.gridService.EditClicked();
     }
    // this.grid2Params.api.forEachNode(function (node) {
 
    

      // node.gridApi.startEditingCell({
      //   rowIndex: node.rowIndex,
      //   colKey: "calls"
      // });
    // });
    
  }


  
  // getRenderer() {
  //   function CellRenderer() {}
  //   CellRenderer.prototype.createGui = function() {
  //     var template =
  //       '<span><button id="theButton">#</button><span id="theValue" style="padding-left: 4px;"></span></span>';
  //     var tempDiv = document.createElement("div");
  //     tempDiv.innerHTML = template;
      
  //     this.eGui = tempDiv.firstElementChild;
  //   };
  //   CellRenderer.prototype.init = function(params) {
  //     this.createGui();
  //     this.params = params;
  //     var eValue = this.eGui.querySelector("#theValue");
  //     eValue.innerHTML = params.value;
  //     this.eButton = this.eGui.querySelector("#theButton");
  //     this.buttonClickListener = this.onButtonClicked.bind(this);
  //     this.eButton.addEventListener("click", this.buttonClickListener);
  //   };
  //   CellRenderer.prototype.onButtonClicked = function() {
  //     var startEditingParams = {
  //       rowIndex: this.params.rowIndex,
  //       colKey: this.params.column.getId()
  //     };
  //     this.params.api.startEditingCell(startEditingParams);
  //   };
  //   CellRenderer.prototype.getGui = function() {
  //     return this.eGui;
  //   };
  //   CellRenderer.prototype.destroy = function() {
  //     this.eButton.removeEventListener("click", this.buttonClickListener);
  //   };
  //   return CellRenderer;
  // }
  


 public btStartEditClick2()
  {
console.log('sdfsdf');
  //  this.grid2Params.api.forEachNode(function (node) {
 
  //     this.gridApi.startEditingCell({
  //       rowIndex: 1,
  //       colKey: "name"
  //     });
  //     node.gridApi.startEditingCell({
  //       rowIndex: node.rowIndex,
  //       colKey: "calls"
  //     });
  //   });
    
  }



  changeTD()
  {
    this.gridService.changeContent= !this.gridService.changeContent;
  }

}



//this is adding and removing row dynamically
//to the grid

//---------------------------------------------------
// var rowData = JSON.parse(JSON.stringify(selectedNode.data));
// gridOptions.api.insertItemsAtIndex(0, [rowData]);
// To remove a selected row:

// var selectedNodes = gridOptions.api.getSelectedNodes();
// gridOptions.api.removeItems(selectedNodes);




//GET COLUMN STATE AND RESTORE COLUMN STATE

// columnApi.getColumnState(): Returns the state of a particular column.
// columnApi.setColumnState(state):