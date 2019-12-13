import { NgModule, QueryList, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CsiBaseComponent } from './csi-base.component';
import { CsiBaseService } from './csi-base.service';

let entryComponents: any[] = [];

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [CsiBaseComponent],
  providers: [CsiBaseService],
  exports: [CsiBaseComponent],
  entryComponents: entryComponents
})
export class CsiBaseModule {
  constructor(){
    if(this.constructor && this.constructor["__annotations__"] && this.constructor["__annotations__"][0] && this.constructor["__annotations__"][0].declarations){
      let components = this.constructor["__annotations__"][0].declarations;
      this.constructor["__annotations__"][0]["entryComponents"] = components
      new CsiBaseService().RegisterComponent(components);
    }
  }
}