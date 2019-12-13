import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

import { GridOptions } from "ag-grid/main";
import { CsiAgGridOptions, CsiAgGridColumn } from './csi-ag-grid-service';
import { Observable } from 'rxjs/Observable';
import { CellRenderComponent } from '../cell-render/cell-render.component';
@Component({
  selector: 'csi-ag-grid',
  templateUrl: './csi-ag-grid.component.html',
  styleUrls: ['./csi-ag-grid.component.scss']
})
export class CsiAgGridComponent implements OnInit {
  public gridOptions: GridOptions;
  @Input() public csiaggridoptions: CsiAgGridOptions;
  @Input() public csiaggridcolumn: CsiAgGridColumn[] = [];
  @Input() Tabledata: any[];
  @Input() testing: any;
  //properties 
  private gridApi;
  private gridColumnApi;
  private columnDefs: CsiAgGridColumn[] = [];
  private detailCellRendererParams = {};
  private frameworkComponents = {};
  private selectedItems: any[] = [];
  private columnTypes;

  //event emiters
  @Output() getDetailRowData = new EventEmitter();
  @Output() getRowStyle = new EventEmitter()
  // @Output()   getRowClass= new EventEmitter();
  @Output() onCellEditingStopped = new EventEmitter()
  @Output() onCellEditingStarted = new EventEmitter()
  @Output() onRowClicked = new EventEmitter()
  @Output() onCellClicked = new EventEmitter()
  @Output() onSelectrionChanged = new EventEmitter();
  @Output() onRowSelectedemiter = new EventEmitter();
  @Output() griReadyEvent = new EventEmitter();
  @Output() onRowSelected = new EventEmitter();
  constructor() {
    // this.gridOptions = <GridOptions>{};

  }

  ngOnInit() {
    this.getDataPath = this.getDataPath.bind(this);
    this.getRowClass = this.getRowClass.bind(this);
    // this.isRowSelectable=this.isRowSelectable.bind(this);
    //this.initialization();
    this.gridOptions = <GridOptions>{};

    var onrowclick = this.onRowClicked;
    this.gridOptions.onRowClicked = function () {
      onrowclick.emit();
    }
    var oncellclick = this.onCellClicked;
    this.gridOptions.onCellClicked = function () {
      oncellclick.emit();
    }

    var oncelleditingstart = this.onCellEditingStarted;
    this.gridOptions.onCellEditingStarted = function () {
      oncelleditingstart.emit();
    }
    var oncelledithingstart = this.onCellEditingStopped;
    this.gridOptions.onCellEditingStopped = function () {
      oncelledithingstart.emit();
    }

    // this.frameworkComponents= {
    //   countryCellRenderer: CellRenderComponent
    //  };

    // +++++++++++++++

    //   if(this.csiaggridoptions != undefined && this.csiaggridoptions.frameworkComponents!=null )  
    //  this.frameworkComponents= this.gridOptions.frameworkComponents= this.csiaggridoptions.frameworkComponents;


    if (this.csiaggridoptions != undefined && this.csiaggridoptions.groupDefaultExpanded != null && this.csiaggridoptions.groupDefaultExpanded && undefined)
      this.gridOptions.groupDefaultExpanded = this.csiaggridoptions.groupDefaultExpanded;

    if (this.csiaggridoptions != undefined && this.csiaggridoptions.singleClickEdit != null && this.csiaggridoptions.singleClickEdit && undefined)
      this.gridOptions.singleClickEdit = this.csiaggridoptions.singleClickEdit;

    if (this.csiaggridoptions != undefined && this.csiaggridoptions.floatingFilter != null && this.csiaggridoptions.floatingFilter != undefined)
      this.gridOptions.floatingFilter = this.csiaggridoptions.floatingFilter;

    if (this.csiaggridoptions != undefined && this.csiaggridoptions.suppressRowClickSelection != null && this.csiaggridoptions.suppressRowClickSelection != undefined)
      this.gridOptions.suppressRowClickSelection = this.csiaggridoptions.suppressRowClickSelection;

    if (this.csiaggridoptions != undefined && this.csiaggridoptions.treeData != null && this.csiaggridoptions.treeData != undefined)
      this.gridOptions.treeData = this.csiaggridoptions.treeData;

    if (this.csiaggridoptions.masterDetail != null && this.csiaggridoptions.masterDetail != undefined)
      this.gridOptions.masterDetail = this.csiaggridoptions.masterDetail;


      if (this.csiaggridoptions.pagination != null && this.csiaggridoptions.pagination != undefined)
      this.gridOptions.pagination = this.csiaggridoptions.pagination;


      if (this.csiaggridoptions.suppressClickEdit != null && this.csiaggridoptions.suppressClickEdit != undefined)
      this.gridOptions.suppressClickEdit = this.csiaggridoptions.suppressClickEdit;

    if (this.csiaggridoptions.rowMultiSelectWithClick != null && this.csiaggridoptions.rowMultiSelectWithClick != undefined)
      this.gridOptions.rowMultiSelectWithClick = this.csiaggridoptions.rowMultiSelectWithClick;

    if (this.csiaggridoptions.toolPanelSuppressColumnExpandAll != null && this.csiaggridoptions.toolPanelSuppressColumnExpandAll != undefined)
      this.gridOptions.toolPanelSuppressColumnExpandAll = this.csiaggridoptions.toolPanelSuppressColumnExpandAll;

    if (this.csiaggridoptions.toolPanelSuppressPivots != null && this.csiaggridoptions.toolPanelSuppressPivots != undefined)
      this.gridOptions.toolPanelSuppressPivots = this.csiaggridoptions.toolPanelSuppressPivots;

    if (this.csiaggridoptions.groupSelectsChildren != null && this.csiaggridoptions.groupSelectsChildren != undefined)
      this.gridOptions.groupSelectsChildren = this.csiaggridoptions.groupSelectsChildren;

    if (this.csiaggridoptions.showToolPanel != null && this.csiaggridoptions.showToolPanel != undefined)
      this.gridOptions.showToolPanel = this.csiaggridoptions.showToolPanel;

    if (this.csiaggridoptions.suppressCsvExport != null && this.csiaggridoptions.suppressCsvExport != undefined)
      this.gridOptions.suppressCsvExport = this.csiaggridoptions.suppressCsvExport;

    if (this.csiaggridoptions.suppressMiddleClickScrolls != null && this.csiaggridoptions.suppressMiddleClickScrolls != undefined)
      this.gridOptions.suppressMiddleClickScrolls = this.csiaggridoptions.suppressMiddleClickScrolls;

    if (this.csiaggridoptions.enableSorting != null && this.csiaggridoptions.enableSorting != undefined)
      this.gridOptions.enableSorting = this.csiaggridoptions.enableSorting;

    if (this.csiaggridoptions.defaultColDef != null && this.csiaggridoptions.defaultColDef != undefined)
      this.gridOptions.defaultColDef = this.csiaggridoptions.defaultColDef;

    if (this.csiaggridoptions.rowHeight != null && this.csiaggridoptions.rowHeight != undefined)
      this.gridOptions.rowHeight = this.csiaggridoptions.rowHeight;

    if (this.csiaggridoptions.groupDefaultExpanded != null && this.csiaggridoptions.groupDefaultExpanded != undefined)
      this.gridOptions.suppressRowClickSelection = this.csiaggridoptions.suppressRowClickSelection;

    if (this.csiaggridoptions.autoGroupColumnDef != null && this.csiaggridoptions.autoGroupColumnDef != undefined)
      this.gridOptions.autoGroupColumnDef = this.csiaggridoptions.autoGroupColumnDef;

    if (this.csiaggridoptions.groupColumnDef != null && this.csiaggridoptions.groupColumnDef != undefined)
      this.gridOptions.groupColumnDef = this.csiaggridoptions.groupColumnDef;

    if (this.csiaggridoptions.rowSelection != null && this.csiaggridoptions.rowSelection != undefined)
      this.gridOptions.rowSelection = this.csiaggridoptions.rowSelection;

    if (this.csiaggridoptions.scrollbarWidth != null && this.csiaggridoptions.scrollbarWidth != undefined)
      this.gridOptions.scrollbarWidth = this.csiaggridoptions.scrollbarWidth;
 
    // +++++++++++++++

    this.gridOptions.getRowStyle = this.csiaggridoptions.getRowStyle;
    this.gridOptions.columnDefs = this.csiaggridcolumn;
    this.gridOptions.rowData = this.Tabledata;
    // this.gridOptions.isRowSelectable=(rowNode=>{
    //   console.log(rowNode)
    //   if(rowNode.data.value==21) 
    //   return false; 
    //   else return true;
    // });
    this.gridOptions.isRowSelectable = (rowNode => {
      if (this.csiaggridoptions.isRowSelectable)
        return this.isRowSelectable(rowNode);
      else
        return true;
    });
    // this.gridOptions.getRowHeight=(rowNode=>{
    //   if(rowNode.data.value==21)
    //   return 40;
    //   else
    //   return 20;
    // });
    this.gridOptions.getRowHeight=this.csiaggridoptions.getRowHeight;
    this.gridOptions.columnTypes=this.csiaggridoptions.columnTypes;





  }


  onGridReady(params) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
    this.griReadyEvent.emit(params);
  }

  onSelectionChanged($event) {
    this.onSelectrionChanged.emit($event);
    console.log($event);
  }

  private getDataPath($event) {
    // if(this.csiaggridoptions && this.csiaggridoptions.getDataPath){
    //   return this.csiaggridoptions.getDataPath($event.data);
    // }
    // return {};
  }
  private getRowClass($event) {
    if (this.csiaggridoptions && this.csiaggridoptions.getRowClass) {
      return this.csiaggridoptions.getRowClass($event.data);
    }
    return {};
  }
  private isRowSelectable($event) {
    if (this.csiaggridoptions && this.csiaggridoptions.isRowSelectable) {
      return this.csiaggridoptions.isRowSelectable($event.data);
    }
    return {};

  }

  //donno what this blog doing. its not necessary
  // private getRowHeight($event){
  //   if (this.csiaggridoptions && this.csiaggridoptions.getRowHeight) {
  //     return this.csiaggridoptions.getRowHeight($event.data);
  //   }
  //   // return {};
  // }

  onRowSelectedf($event) {
    this.onRowSelected.emit($event);


  }
}
