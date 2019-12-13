import { Component, OnInit, Input, ViewChild, ViewContainerRef, ContentChild, TemplateRef, ComponentFactoryResolver, Output, SimpleChange, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { GridComponent,
  GridDataResult,
  DataStateChangeEvent } from '@progress/kendo-angular-grid';
  import { CsiGridOptions, CsiGridColumn } from './csi-grid.model';
  import { FormGroup } from '@angular/forms';
  
  import { map } from 'rxjs/operators/map';
  
  @Component({
    selector: 'csi-grid',
    templateUrl: './csi-grid.component.html',
    styleUrls: ['./csi-grid.component.scss']
  })
  
  export class CsiGridComponent implements OnInit {
    
    @Input() data: Observable<GridDataResult>;
    @Input() columns: CsiGridColumn[] = [];
    @Input() options?: CsiGridOptions = {};

    @Output() onRowClick = new EventEmitter();
    
    public editFormGroup: FormGroup;
    private editedRowIndex: number;
    
    constructor(private resolver: ComponentFactoryResolver,private _viewContainer: ViewContainerRef) {
    }
    
    selectedItems: any[] = [];
    
    ngOnInit() {
      this.getRowDisabled = this.getRowDisabled.bind(this);
    }
    
    ngOnChanges(changes: SimpleChange){
      console.log(changes);
    }
    
    // dataStateChange
    dataStateChange(state: DataStateChangeEvent){
    }
    
    // on items selection changed
    onSelectedKeysChange(e) {
    }
    
    
    /// Edit handler
    public editHandler({sender, rowIndex, dataItem}) {
      this.closeEditor(sender);
      this.editFormGroup = this.options.editable.formGroup(dataItem); //this.options.editable.formGroup
      this.editedRowIndex = rowIndex;
      sender.editRow(rowIndex, this.editFormGroup);
    }
    
    /// Cancel Handler
    public cancelHandler({sender, rowIndex}) {
      this.closeEditor(sender, rowIndex);
    }
    
    /// Save Handler
    public saveHandler({sender, rowIndex, formGroup, isNew}) {
      const product = formGroup.value;
      
      let rowData = this.data[rowIndex];
      Object.assign(rowData, product);
      
      sender.closeRow(rowIndex);
      this.options.editable.onUpdate(rowData);
    }
    
    /// Remove Handler
    public removeHandler({dataItem}) {
      //this.editService.remove(dataItem);
    }
    
    private closeEditor(grid, rowIndex = this.editedRowIndex) {
      grid.closeRow(rowIndex);
      this.editedRowIndex = undefined;
      this.editFormGroup = undefined;
    }   
    
    /// Row disabled
    private getRowDisabled($event){
      if(this.options && this.options.rowDisabled){
        return { 'k-disabled' : this.options.rowDisabled($event.dataItem) };
      }
      return {};
    }

    // On Row Click
    private rowClick($event){
      this.onRowClick.emit($event);
    }
    
  }
  