import { Component, OnInit, AfterViewInit, ViewChild, ViewContainerRef } from '@angular/core';
import { ICellEditorAngularComp } from 'ag-grid-angular';
import { ICellEditorParams, IAfterGuiAttachedParams } from 'ag-grid';

@Component({
  selector: 'app-editor-renderer',
  templateUrl: './editor-renderer.component.html',
  styleUrls: ['./editor-renderer.component.css']
})
export class EditorRendererComponent implements
 OnInit,ICellEditorAngularComp, AfterViewInit {


  ngOnInit(): void {
    
  }
//   private params: any;

//   @ViewChild('container', {read: ViewContainerRef}) public container;
//   public happy: boolean = false;


// // dont use afterGuiAttached for post gui events - hook into ngAfterViewInit instead for this
// ngAfterViewInit() {
//   this.container.element.nativeElement.focus();
// }

// agInit(params: any): void {
//   this.params = params;
//   this.setHappy(params.value === "Happy");
// }

// getValue(): any {
//   return this.happy ? "Happy" : "Sad";
// }

// // isPopup(): boolean {
// //   return true;
// // }


//   // isCancelBeforeStart?(): boolean {
    
//   // }
//   // isCancelAfterEnd?(): boolean {
    
//   // }
//   // focusIn?(): void {
//   //   throw new Error("Method not implemented.");
//   // }
//   focusOut?(): void {
//     throw new Error("Method not implemented.");
//   }

//   afterGuiAttached?(params?: IAfterGuiAttachedParams): void {
//     throw new Error("Method not implemented.");
//   }
//   constructor() { }
//   setHappy(happy: boolean): void {
//     this.happy = happy;
// }

// toggleMood(): void {
//     this.setHappy(!this.happy);
// }

// onClick(happy:boolean) {
//     this.setHappy(happy);
//     this.params.api.stopEditing();
// }

// onKeyDown(event): void {
//     let key = event.which || event.keyCode;
//     if (key == 37 ||  // left
//         key == 39) {  // right
//         this.toggleMood();
//         event.stopPropagation();
//     }
// }
//   ngOnInit() {
//   }
@ViewChild('container', {read: ViewContainerRef}) public container;
    public happy: boolean = false;
    private params: any;
    // dont use afterGuiAttached for post gui events - hook into ngAfterViewInit instead for this
    ngAfterViewInit() {
        this.container.element.nativeElement.focus();
    }

    agInit(params: any): void {
        this.params = params;
        this.setHappy(params.value === "Happy");
    }

    getValue(): any {
        return this.happy ? "Happy" : "Sad";
    }

    isPopup(): boolean {
        return true;
    }

    setHappy(happy: boolean): void {
        this.happy = happy;
    }

    toggleMood(): void {
        this.setHappy(!this.happy);
    }

    onClick(happy:boolean) {
        this.setHappy(happy);
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
