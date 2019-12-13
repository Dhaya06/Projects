import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class GridService {
  public isEditClicked:boolean=false;
  public selectedItems:any[]=[];
  public changeContent:boolean=false;
  public selectedItemsBeforeEditClick:any[]=[];

  constructor()  {
  }

  public EditClicked(){
   this.isEditClicked =  !this.isEditClicked ;
  }

  public UnEditClicked(){
    this.isEditClicked = false;
  }

  public DoEditClicked(){
    this.isEditClicked = true;
  }

}
