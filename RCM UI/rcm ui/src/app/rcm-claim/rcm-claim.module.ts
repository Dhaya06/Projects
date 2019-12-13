import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RcmClaimRoutingModule } from './rcm-claim-routing.module';
import { RcmClaimComponent } from './rcm-claim.component';
import { ClaimHeaderComponent } from './claim-header/claim-header.component';
import { ClaimBodyComponent } from './claim-body/claim-body.component';
import { ClaimSlidePanelComponent } from './claim-slide-panel/claim-slide-panel.component';
import { DiagnosisModalComponent } from './_modal/diagnosis-modal/diagnosis-modal.component';
import { DiagnosisRemarkModalComponent } from './_modal/diagnosis-remark-modal/diagnosis-remark-modal.component';
import { BsModalService, ModalModule } from 'ngx-bootstrap';
import { CsiGridModule } from '../../../csi-web-base/csi-grid/csi-grid.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormElementsModule } from '../../../csi-web-base/csi-form-elements/form-elements.module';
import { MasterDataService } from '../rcm-master-data/master-data.service';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import {ClaimService} from "./claim.service";
import { CsiBaseModule } from 'csi-base';
import { CsiWidjetSideTogglerModule } from 'csi-side-widget';
import { ActivatedRoute } from '@angular/router';


@NgModule({
  imports: [
    CommonModule,
    RcmClaimRoutingModule,
    ModalModule.forRoot(),
    CsiGridModule,
    FormsModule,
    FormElementsModule,
    ReactiveFormsModule,
    CsiBaseModule,
    BsDatepickerModule.forRoot(),
    CsiWidjetSideTogglerModule
  ],
  declarations: [RcmClaimComponent, ClaimHeaderComponent, ClaimBodyComponent, ClaimSlidePanelComponent, DiagnosisModalComponent, DiagnosisRemarkModalComponent],
  providers: [BsModalService, MasterDataService, ClaimService],

  entryComponents : [ DiagnosisModalComponent, DiagnosisRemarkModalComponent ]
})
export class RcmClaimModule extends CsiBaseModule {
  constructor(){
    super();
  }
 }
