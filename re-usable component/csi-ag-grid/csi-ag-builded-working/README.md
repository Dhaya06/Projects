# CsiAgGrid

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.6.8.

## Follow the instruction 

## Step 1: install 

npm install csi-ag-grid

##Step 2: Import Module 

Import 'CsiAgGridModule,' module to your application as follow. 

```
	import {CsiAgGridModule} from 'csi-ag-grid';    <<this

	@NgModule({
	 declarations: [
	   AppComponent
	 ],
	 imports: [
	   BrowserModule,
	   CsiAgGridModule    <<this
	 ],
	 providers: [],
	 bootstrap: [AppComponent]
	})

```
Note: Some cases you might required to import Ag Grid Base Module.(Implementing
Custom Cell Renderer, Cell Editor, or Custom Filters ). Please import AG Base Module
only if required. You have to tell that AG Grid module regarding your custom component which going to act as part of the ag grid component. 
```
    import {AgGridModule} from "ag-grid-angular/main";

    @NgModule({
    imports: [
            AgGridModule.withComponents([CellRenderComponent,            <<this
            CellEditorComponent])                                        <<this
    ]
    });

```
## Step 3: Import Interfaces

import following interfaces to your component

	```
         import { CsiAgGridColumn, CsiAgGridOptions } from 'csi-ag-grid';   
	```
	
## Step 4: Add NgSelector in HTML 

Add the following markup in your html file. You have to bind certain properties of
csi-grid-component. importantly you must bind 'Tabledata', 'csiaggridcolumn', and 'csiaggridoptions'. 

```
	<div style="width: 600px;">

            <csi-ag-grid 
            [csiaggridoptions]=gridOptions 
            [Tabledata]="dataSet" 
            [csiaggridcolumn]="colDef" 
            (onRowClicked)="onRowClick($event)"
            (onRowSelected)="onRowSelect($event)"
            (griReadyEvent)="griReadyEvent($event)"
            >
            </csi-ag-grid>
    </div>
 ```
 
 There are events which exposes api properties to the consumers. You need to subcsribe to those events and access event argumets for more details with a console log. 
  
  
## Step 5: Define Column Definitions

Define following properties in your component.ts file
    ```
        public gridOptions: CsiAgGridOptions;
        dataSet: any = [];
        private gridApi ;
        private gridColumnApi ;
        colDef: CsiAgGridColumn[] = [];

    ```
Column Definition contains some required properties and some optional properties Create column definition array as follow. 

```
     this.colDef = [
      {
        headerName: "ID", 
        field: "id",
        width: 200,
        editable: true,
        checkboxSelection: true,
        headerTooltip: 'Test ID',
        filter: 'agTextColumnFilter',
        cellEditorFramework: CellEditorComponent

      },
      {
        headerName: "value",
        field: "value",
        width: 200,
        cellRendererFramework: CellRenderer2Component,
        headerTooltip: 'Description',
      },.....
    ];

```

## Step 6: Define Data Set to the Grid

```
      this.dataSet = [
        { id: 5, value: 3434 },
        { id: 10, value: 15 },
        { id: 15, value: 20 },
        { id: 16, value: 20 },
        { id: 17, value: 20 },
        { id: 18, value: 20 }
      ]
```

## Step 7: Define grid options as follow

```
    this.gridOptions =
      {
        rowSelection: 'multiple',
        suppressClickEdit: false,
        singleClickEdit: false,
        floatingFilter: true,
        getRowStyle: function (params) {
          if (params.node.data.value == 15) {
            return { background: '#F46F6F' }
          }
          else {
            return { background: '' }
          }
        },
        isRowSelectable: function (params) {
          if (params.node.data.value == 15) {
            return { background: '#F46F6F' }
          }
          else {
            return { background: '' }
          }
        },
        showToolPanel: false
      }
```
##Importing Theem Styles
Modify styles array in angular.cli.json file and link ag grid theme

```
    "styles": [
        "styles.scss",
        "../node_modules/ag-grid/dist/styles/ag-grid.css",
        "../node_modules/ag-grid/dist/styles/ag-theme-balham.css"
      ],
```

##Licensing
In order to access enterprice features of this grid, Please register your license key as follow. (Note: We Recommend you to validate your license in main.ts file that helps to complete the validating process before component initiation). 


main.ts
```
    import {LicenseManager} from "ag-grid-enterprise/main";
    LicenseManager.setLicenseKey("License_Key_Here");

```

# API Reference

### Column Definition
```
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
       aggFunc?:string;  // "sum" or null
       enableRowGroup?: boolean;  
       rowGroupIndex?:number;
       pinned?:string //left or right
       children?:[{}]

```

### Grid Options

```
        groupDefaultExpanded? :number;
        floatingFilter?:boolean;
        treeData?:boolean;
        masterDetail?:boolean;
        suppressRowClickSelection?:boolean;//Disable when checkbox select=true 
        suppressClickEdit?:boolean;
        rowMultiSelectWithClick?:boolean;
        rowHeight?:number;
        toolPanelSuppressColumnExpandAll?:boolean;
        toolPanelSuppressPivots?:boolean;
        groupSelectsChildren?:boolean;
        rowSelection?:string;
        scrollbarWidth?:number;
        showToolPanel?:boolean;
        suppressCsvExport?:boolean;
        suppressMiddleClickScrolls?:boolean;
        autoGroupColumnDef?:{}
        groupColumnDef?:{}
        defaultColDef?:{}
        singleClickEdit?:boolean

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
        //eg:-
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
        getRowStyle?:Function  //specify anonymous funcion and return styles
        getRowHeight?:Function //Call Back function
        getRowClass?:Function; //Call Back function
        getDataPath?:Function; //return data to tree data view
        onCellEditingStopped?:Function //Event Emiter
        onCellEditingStarted?:Function //Event Emiter
        onRowClicked?:Function //Event Emiter
        onCellClicked?:Function //Event Emiter
        isRowSelectable?:Function //Call Back function

```
### Note: Event emiters are event binding same as 'griReadyEvent($event)'. You can subcribe to them : Example >> Step 4


## Further help
Contact CS-UIF Team 
