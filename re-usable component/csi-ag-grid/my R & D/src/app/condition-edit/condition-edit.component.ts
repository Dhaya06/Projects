import { Component, OnInit, DoCheck, NgZone, AfterViewInit, ViewChild, ViewContainerRef } from '@angular/core';
import { ICellRendererAngularComp, ICellEditorAngularComp } from 'ag-grid-angular';
import { IAfterGuiAttachedParams } from 'ag-grid';
import { GridService } from '../csi-grid/grid-service';

@Component({
  selector: 'app-condition-edit',
  templateUrl: './condition-edit.component.html',
  styleUrls: ['./condition-edit.component.css']
})
export class ConditionEditComponent implements OnInit,
  ICellEditorAngularComp, AfterViewInit, DoCheck {


  ngOnInit(): void {

  }
  isEdited: boolean = true;
  selectedBeforeEdit:boolean=false;
  constructor(private gridService: GridService) {


  }

  ngDoCheck(): void {
    if (this.gridService.isEditClicked != this.isEdited) {
      this.isEdited = this.gridService.isEditClicked;
      
    }
  }
  minutes: any;
  
  @ViewChild('container', { read: ViewContainerRef }) public container;
  public happy: boolean = false;
  private params: any;
  // dont use afterGuiAttached for post gui events - hook into ngAfterViewInit instead for this
  ngAfterViewInit() {
    this.container.element.nativeElement.focus();
  }

  agInit(params: any): void {
    this.selectedBeforeEdit=false;
    this.params = params;
    this.minutes=params.value;
    this.setHappy(params.value === "Happy");
    this.checkselectedBeforeEdit();

  }

  
  checkselectedBeforeEdit()
  {
  
    let items=this.gridService.selectedItemsBeforeEditClick;
    for(let item of items) {
      if(this.params.node.data.account==item.account)
      {
        this.selectedBeforeEdit=true;
      }
    }
  }
 
  getValue(): any {
 
    this.params.api.stopEditing();
    if(this.isEdited&&this.params.node.selected)
    {this.params.api.stopEditing();
      return this.minutes;
    }
    else{this.params.api.stopEditing();
      return this.params.value;
    }
    }

  isPopup(): boolean {
    return false;
  }

  setHappy(happy: boolean): void {
    this.happy = happy;
  }

  toggleMood(): void {
    this.setHappy(!this.happy);
  }

  onClick(happy: boolean) {
    // this.setHappy(happy);
    // this.params.api.stopEditing();

  }
  focusOutFunction()
  {
     this.params.api.stopEditing();
  }
  onKeyDown(event): void {
    let key = event.which || event.keyCode;
    if (key == 37 ||  // left
      key == 39) {  // right
      this.toggleMood();
      event.stopPropagation();
    }
  }


}
