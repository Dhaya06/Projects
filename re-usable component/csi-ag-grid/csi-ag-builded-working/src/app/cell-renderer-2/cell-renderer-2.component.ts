import { Component, OnInit, DoCheck } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';
import { IAfterGuiAttachedParams } from 'ag-grid';
import { GridService } from '../grid-service';
@Component({
  selector: 'app-cell-renderer-2',
  templateUrl: './cell-renderer-2.component.html',
  styleUrls: ['./cell-renderer-2.component.scss']
})
export class CellRenderer2Component implements OnInit, 
ICellRendererAngularComp, DoCheck {
  ngOnInit(): void {
    
  }

  constructor(private gridService: GridService) {
    
  }
    refresh(params: any): boolean {
        return false;
    }
    afterGuiAttached?(params?: IAfterGuiAttachedParams): void {
        
    }
    private params: any;
  
    isEdited:boolean=true;
    selectedBeforeEdit:boolean=false;
    checkselectedBeforeEdit()
    {
      if(this.params.node.data==undefined)
      {return;}
     let items=this.gridService.selectedItemsBeforeEditClick;

      for(let item of items) 
      {
          if(this.params.node.data.id==item.id )
          {
            this.selectedBeforeEdit=true;
          }    
      }
      // this.selectedBeforeEdit=false;
    }

    ngDoCheck(): void {
      if(this.gridService.isEditClicked!=this.isEdited)
      {
        this.isEdited=this.gridService.isEditClicked;
         
      
      } 
      this.checkselectedBeforeEdit();
     }

    isCheck=false;
    agInit(params: any): void {
        this.params = params;
        this.isCheck=params.node.selected;
        console.log("initi"+params.node.selected);
    
      
    }
}
