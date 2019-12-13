import { Component, OnInit, Input, ChangeDetectorRef, ChangeDetectionStrategy, Output, EventEmitter, SimpleChanges } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { CellContent } from './models/csi-page-layout.modal';
import { GridsterConfig, GridsterItem }  from 'angular-gridster2';
import { CsiLayoutConfig } from './csi-page-layout.module';

@Component({
  selector: 'csi-page-layout',
  templateUrl: './csi-page-layout.component.html',
  styleUrls: ['./csi-page-layout.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class CsiPageLayoutComponent implements OnInit {
  
  @Input() enableEditMode?: boolean = false;
  @Input() cellContents:CellContent[] = [];
  @Input() options?:GridsterConfig = {};

  @Input() componentId:any[] = [];
  
  @Output() itemChanged = new EventEmitter()
  
  
  //options: GridsterConfig;
  remove: boolean;
  
  static eventStop(item, itemComponent, event) {
    //console.info('eventStop', item, itemComponent, event);
  }
  
  itemChange(item, itemComponent) {
    console.info('itemChanged', item, itemComponent);
    console.log("Drag");
   
    //emit the function to the componnet.ts
    if(this["gridUpdatedCallbackEvent"] && this["items"]){
      this["gridUpdatedCallbackEvent"].emit({items : this["items"]});
    }
  }

  getClasses(){
    if(this.enableEditMode == true){
      return 'layout-edit-mode flex-dir'
    }else{
      return 'flex-dir'
    }
  }
  
  static itemResize(item, itemComponent) {
    //console.info('itemResized', item, itemComponent);
  }
  
  static itemInit(item, itemComponent) {
    //console.info('itemInitialized', item, itemComponent);
  }
  
  static itemRemoved(item, itemComponent) {
    //console.info('itemRemoved', item, itemComponent);
  }
  
  static gridInit(grid) {
    //console.info('gridInit', grid);
  }
  
  static gridDestroy(grid) {
    //console.info('gridDestroy', grid);
  }
  
  ngOnChanges(changes: SimpleChanges) {
    //console.log("changed from csi-page-layout");
    // console.log(this._cellContents);
    this.ngOnInit();
  }
  
  constructor(private sanitizer:DomSanitizer, private cdRef:ChangeDetectorRef) { }
  
  ngOnInit() {
 
    this.options = {
 
      gridType: 'verticalFixed',
      displayGrid:'always',
      emptyCellDragMaxCols: 15,
      maxItemCols: 50,
      minRows: 10,
      fixedRowHeight: 40,
      margin: 0,
      outerMargin: true,
      minCols: 12,
      maxCols: 12,
      draggable: {
        delayStart: 0,
        enabled: this.enableEditMode ? true : false,
        ignoreContentClass: 'gridster-item-content',
        dragHandleClass: 'drag-handler'
      },
      resizable: {
        enabled: this.enableEditMode ? true : false,
      }
    };
  } 
  
  removeItem($event, item) { 
    //$event.preventDefault();
    //$event.stopPropagation();

    //this.options.items.splice(this.options.items.indexOf(item), 1);
  }
  
  destroy() {
    this.remove = !this.remove;
  }
  
}
