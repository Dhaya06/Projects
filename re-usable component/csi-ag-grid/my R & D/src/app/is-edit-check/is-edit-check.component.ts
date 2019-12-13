import { Component, OnInit, DoCheck, NgZone } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';
import { IAfterGuiAttachedParams } from 'ag-grid';
import { GridService } from '../csi-grid/grid-service';

@Component({
  selector: 'app-is-edit-check',
  templateUrl: './is-edit-check.component.html',
  styleUrls: ['./is-edit-check.component.css']
})
export class IsEditCheckComponent implements OnInit, 
ICellRendererAngularComp, DoCheck {
   
  ngOnInit(): void {
    
  }
    refresh(params: any): boolean {
        return false;
    }
    afterGuiAttached?(params?: IAfterGuiAttachedParams): void {
        
    }
    private params: any;
  
    selectedBeforeEdit:boolean=false;
    isEdited:boolean=true;
    constructor(private gridService: GridService,private zone:NgZone) {
     
    }
   
    ngDoCheck(): void {
        if(this.gridService.isEditClicked!=this.isEdited)
        {
          
          this.isEdited=this.gridService.isEditClicked;
        }
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



    isCheck=false;
    agInit(params: any): void {
        this.params = params;
        this.isCheck=params.node.selected;
        console.log("initi"+params.node.selected);
       // console.log(params);
       
    }

    changeTD()
    {
      
    }

}
