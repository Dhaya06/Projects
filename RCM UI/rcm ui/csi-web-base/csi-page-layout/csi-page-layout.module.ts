import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CsiPageLayoutComponent } from './csi-page-layout.component';
import { CsiColomnComponent } from './components/csi-colomn/csi-colomn.component';
import { CsiDataParserModule } from '../csi-data-parser/csi-data-parser.module';
import { GridsterModule, GridsterConfig } from 'angular-gridster2';
import { CsiBaseModule } from 'csi-base';

@NgModule({
  imports: [
    CommonModule,
    CsiDataParserModule,
    GridsterModule
  ],
  declarations: [CsiPageLayoutComponent, CsiColomnComponent],
  exports: [CsiPageLayoutComponent, CsiColomnComponent]
})
export class CsiPageLayoutModule extends CsiBaseModule { 
  constructor(){
    super();
  }
}


export class CsiLayoutConfig implements GridsterConfig {
  editable: boolean;
}