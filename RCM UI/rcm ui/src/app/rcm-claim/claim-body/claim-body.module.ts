import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { ClaimBodyComponent } from './claim-body.component';
import { ClaimBodyService } from './claim-body.service';
import { CsiGridModule } from '../../../../csi-web-base/csi-grid/csi-grid.module';
import { ReactiveFormsModule } from '@angular/forms';
import {CsiWidjetSideTogglerModule} from 'csi-side-widget';

@NgModule({
  declarations: [
    ClaimBodyComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    CsiGridModule,
    ReactiveFormsModule,
    CsiGridModule,
    CsiWidjetSideTogglerModule
  ],
  providers: [ClaimBodyService],
  bootstrap: [ClaimBodyComponent]
})
export class ClaimBodyModule { }
