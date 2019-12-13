import {Component, Input, DoCheck, NgZone} from "@angular/core";
import { GridService } from './../csi-grid/grid-service';
import { ICellRendererAngularComp } from "ag-grid-angular";
import { IAfterGuiAttachedParams } from "ag-grid";

@Component({
    selector: 'app-red-component',
    templateUrl: './red-component.component.html'
})
export class RedComponentComponent implements 
ICellRendererAngularComp, DoCheck {
   
    refresh(params: any): boolean {
          // console.log(params);
          // console.log("refresh");
        return false;
    }
    afterGuiAttached?(params?: IAfterGuiAttachedParams): void {
        
    }
    private params: any;
  
    isEdited:boolean=true;
    contentChange:boolean=false;
    constructor(private gridService: GridService,private zone:NgZone) {
     
    }
   
    ngDoCheck(): void {
        if(this.gridService.isEditClicked!=this.isEdited)
        {
            // this.zone.run(()=>{
            //   //  console.log("zone runnign");
            // });
        this.isEdited=this.gridService.isEditClicked;

        }
        if(this.gridService.changeContent!=this.contentChange)
        {
            this.contentChange=this.gridService.changeContent;
        }

    }
    isCheck=false;
    agInit(params: any): void {
        this.params = params;
        this.isCheck=params.node.selected;
        //console.log("initi"+params.node.selected);
       // console.log(params);
    }
}
