import { Component, OnInit, AfterViewInit, DoCheck, ViewChild, ViewContainerRef } from '@angular/core';
import { ICellRendererAngularComp, ICellEditorAngularComp } from 'ag-grid-angular';
import { IAfterGuiAttachedParams } from 'ag-grid';
import { GridService } from '../grid-service';


@Component({
  selector: 'app-cell-editor',
  templateUrl: './cell-editor.component.html',
  styleUrls: ['./cell-editor.component.scss']
})
export class CellEditorComponent implements  OnInit,
ICellEditorAngularComp, AfterViewInit, DoCheck {


ngOnInit(): void {

}
isEdited: boolean = true;
checkBool:boolean=false;
selectedBeforeEdit:boolean=false;

    clickedTime=0;
constructor(private gridService: GridService) {


}

ngDoCheck(): void {
  // if(this.gridService.isEditClicked!=this.isEdited)
  //       {
  //         this.isEdited=this.gridService.isEditClicked;
           
  //         this.checkselectedBeforeEdit();
  //       }

  //       if(this.gridService.countofClick!=this.clickedTime)
  //       {this.clickedTime=this.gridService.countofClick;
         
  //         this.checkselectedBeforeEdit();
  //       }
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
  this.params = params;
  this.minutes=params.value;
}
checkselectedBeforeEdit()
    {
      if(this.params.node.data==undefined)
      {return;}
     let items=this.gridService.selectedItemsBeforeEditClick;

      for(let item of items) 
      {
          if(this.params.node.data.ValueBasedResultID==item.ValueBasedResultID )
          {
            this.selectedBeforeEdit=true;
          }    
          // if (this.params.node.data.account==undefined)
          // {
          //   this.selectedBeforeEdit=false;
          // }
      }
      // this.selectedBeforeEdit=false;
    }

getValue(): any {
  return this.params.value;
}

isPopup(): boolean {
  return false;
}

focusOutFunction()
{
   this.params.api.stopEditing();
}
}

