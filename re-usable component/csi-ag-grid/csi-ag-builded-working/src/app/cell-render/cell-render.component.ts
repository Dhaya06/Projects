import { Component, OnInit,DoCheck } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';
import { IAfterGuiAttachedParams } from 'ag-grid';
import { GridService } from '../grid-service';
@Component({
  selector: 'app-cell-render',
  templateUrl: './cell-render.component.html',
  styleUrls: ['./cell-render.component.scss']
})
export class CellRenderComponent implements OnInit, 
ICellRendererAngularComp, DoCheck {
    isEdit:boolean;
  ngOnInit(): void {
    
  }
    refresh(params: any): boolean {
        return true;
    }
    afterGuiAttached?(params?: IAfterGuiAttachedParams): void {
        
    }
    
    constructor(private gridService: GridService) {
   
    }
    
   


    ngDoCheck(): void {
       
        
     }

    private params;
    agInit(params: any): void {
        this.params = params;
        this.isEdit=false;
       
    }

}
