import { TemplateRef } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { GridOptions } from "ag-grid/main";


// export class CsiAgGridOptions {
    
//    public groupDefaultExpanded? :number;
//     public floatingFilter?:boolean=false;
//     public treeData?:boolean=false;
//     public masterDetail?:boolean=false;
//     public suppressRowClickSelection?:boolean=false;//to diable the select when having checkbox 
//     public suppressClickEdit?:boolean=false;
//     public rowMultiSelectWithClick?:boolean=false;
//     public rowHeight?:number;
//     public toolPanelSuppressColumnExpandAll?:boolean=false;
//     public toolPanelSuppressPivots?:boolean=false;
//     public groupSelectsChildren?:boolean=false;
//     public rowSelection?:string;
//     public scrollbarWidth?:number;
//     public showToolPanel?:boolean=false;
//     public suppressCsvExport?:boolean=false;
//     public suppressMiddleClickScrolls?:boolean=false;
//     public autoGroupColumnDef?:{}
//     public groupColumnDef?:{}
//     public defaultColDef?:{}
//     public enableSorting?:boolean=false;
//     public columnTypes?:{};//specify number column and you can use this inside col def
//     // this.columnTypes = 
//     // {
//     //     numberColumn: {
//     //       width: 83,
//     //       filter: "agNumberColumnFilter"
//     //     },
//     //     medalColumn: {
//     //       width: 100,
//     //       columnGroupShow: "open",
//     //       suppressFilter: true
//     //     }
//     // }
//     public detailCellRenderAgent?:string;
//     public frameworkComponents?: {};
//     // frameworkComponents: {
//     //     countryCellRenderer: CountryCellRenderer
//     // },
//     public  detailsCellRendererParams?:{
//         detailsGridOptions?:{},
//         onGridReady?:Function,
//         floatingFilter?:true,
//         masterDetail?:true,
//         template?:Function,
//         getDetailRowData?:Function,
//         detailCellRendererParams?:{}
//     };
//     public  getDetailRowData?:Function;
//     public  getRowStyle?:Function
//     public  getRowHeight?:Function
//     public  getRowClass?:Function;
//     public  getDataPath?:Function; //tree data
//     public  onCellEditingStopped?:Function
//     public  onCellEditingStarted?:Function
//     public  onRowClicked?:Function
//     public  onCellClicked?:Function
//     public  isRowSelectable?:Function

// }

// export class CsiAgGridColumn {
//      public headerName?: string;
//      public headerTooltip?:string;
//      public field?:string;
//      public cellRenderer?: string;
//      public editable?: boolean=false;
//      public checkboxSelection?: boolean=false;
//      public headerCheckboxSelection?: boolean=false
//      public filter?:string;
//      public width?: number;
//      public type?:string;
//      public filterable?: boolean=false;
//      public cellEditor?:string;
//      public sortable?: boolean=false;
//      public aggFunc?:string;// "sum" or null
//      public enableRowGroup?: boolean=false;
//      public // hide?: boolean=false
//      public rowGroupIndex?:number;
//      public pinned?:string //left or right
//      public children?:[{}]
// } 


export interface CsiAgGridOptions {
    
     groupDefaultExpanded? :number;
      floatingFilter?:boolean;
      treeData?:boolean;
      masterDetail?:boolean;
      suppressRowClickSelection?:boolean;//to diable the select when having checkbox 
      suppressClickEdit?:boolean;
      enableFilter?:any;
      rowMultiSelectWithClick?:boolean;
      rowHeight?:number;
      toolPanelSuppressColumnExpandAll?:boolean;
      toolPanelSuppressPivots?:boolean;
      groupSelectsChildren?:boolean;
      rowSelection?:string;
      pagination?:boolean;
      scrollbarWidth?:number;
      showToolPanel?:boolean;
      suppressCsvExport?:boolean;
      suppressMiddleClickScrolls?:boolean;
      autoGroupColumnDef?:any
      groupColumnDef?:{}
      defaultColDef?:{}
      singleClickEdit?:boolean
      enableColResize?:boolean
      debug?:boolean
      enableSorting?:boolean;
      columnTypes?:{};//specify number column and you can use this inside col def
     // this.columnTypes = 
     // {
     //     numberColumn: {
     //       width: 83,
     //       filter: "agNumberColumnFilter"
     //     },
     //     medalColumn: {
     //       width: 100,
     //       columnGroupShow: "open",
     //       suppressFilter: true
     //     }
     // }
      detailCellRenderAgent?:string;
      frameworkComponents?: {};
     // frameworkComponents: {
     //     countryCellRenderer: CountryCellRenderer
     // },
       detailsCellRendererParams?:{
         detailsGridOptions?:{},
         onGridReady?:Function,
         floatingFilter?:true,
         masterDetail?:true,
         template?:Function,
         getDetailRowData?:Function,
         detailCellRendererParams?:{}
     };
       getDetailRowData?:Function;
       getRowStyle?:Function
       getRowHeight?:Function
       getRowClass?:Function;
       getDataPath?:Function; //tree data
       onCellEditingStopped?:Function
       onCellEditingStarted?:Function
       onRowClicked?:Function
       onCellClicked?:Function
       isRowSelectable?:Function
 
 }
 
 export interface CsiAgGridColumn {
       headerName?: string;
       headerTooltip?:string;
       field?:string;
       cellRenderer?: string;
       editable?: boolean;
       checkboxSelection?: boolean;
       headerCheckboxSelection?: boolean
       filter?:string;
       width?: number;
       cellRendererFramework?:any
      cellEditorFramework?:any
       type?:string;
       filterable?: boolean;
       cellEditor?:string;
       sortable?: boolean;
       aggFunc?:any;// "sum" or null
       enableRowGroup?: boolean;
       // hide?: boolean=false
       rowGroupIndex?:number;
       pinned?:string //left or right
       children?:[{}],
       valueGetter?:any
 } 
 
 