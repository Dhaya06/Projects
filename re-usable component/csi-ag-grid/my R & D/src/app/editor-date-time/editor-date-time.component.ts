import { Component, OnInit, AfterViewInit, ViewContainerRef, ViewChild } from '@angular/core';
import { ICellEditorAngularComp } from 'ag-grid-angular';

@Component({
  selector: 'app-editor-date-time',
  templateUrl: './editor-date-time.component.html',
  styleUrls: ['./editor-date-time.component.css']
})
export class EditorDateTimeComponent implements OnInit, ICellEditorAngularComp, AfterViewInit {
  public dateTimeExample = null;
	public dateExample = null;
	public timeExample = null;
  @ViewChild('container', {read: ViewContainerRef}) public container;
  @ViewChild('input', {read: ViewContainerRef}) public input;  
  public happy: boolean = false;
    private params: any;
    // dont use afterGuiAttached for post gui events - hook into ngAfterViewInit instead for this
    ngAfterViewInit() {
       // this.container.element.nativeElement.focus();
       this.input.element.nativeElement.focus();
    }
    setToNow(): void{
      this.dateExample = new Date();
      this.timeExample = `${this.dateExample.getHours()}:${this.dateExample.getMinutes()} ${(this.dateExample.getHours() > 11 ? 'am' : 'pm')}`;
      this.dateTimeExample = new Date();
    }
    agInit(params: any): void {
        this.params = params;
        
    }

    getValue(): any {
        return this.dateExample? this.dateExample: 'not initiated ';
    }

    isPopup(): boolean {
      return true;
  }

    

    onClick(happy:boolean) {
      if(this.dateExample)
      this.params.api.stopEditing();
    }

   
  ngOnInit() {
  }

}
