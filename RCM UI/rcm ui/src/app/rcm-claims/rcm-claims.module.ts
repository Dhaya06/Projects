import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RcmClaimsRoutingModule } from './rcm-claims-routing.module';
import { RcmClaimsComponent } from './rcm-claims.component';
import { ClaimSummaryComponent } from './claim-summary/claim-summary.component';
import { ClaimSearchComponent } from './claim-search/claim-search.component';
import { ClaimGridComponent } from './claim-grid/claim-grid.component';
import { CsiGridModule } from '../../../csi-web-base/csi-grid/csi-grid.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CsiBaseModule } from 'csi-base';
import { FormElementsModule } from '../../../csi-web-base/csi-form-elements/form-elements.module';
import { MasterDataService } from '../rcm-master-data/master-data.service';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { CsiHttpService } from '../../../csi-web-base/csi-http-handler/csi-http.service';
import { DateConvertService } from '../_shared/date-convert.service';
import { SearchClaimService } from './claim-search/search-claim.service';
import { ClaimSubmissionComponent } from './claim-submission/claim-submission.component';
import { ModalModule } from 'ngx-bootstrap/modal';
import { ClaimSummaryBodyComponent } from './claim-submission/claim-summary-body/claim-summary-body.component';
import { ClaimSubmissionFooterComponent } from './claim-submission/claim-submission-footer/claim-submission-footer.component';
import { ClaimReviewComponent } from './claim-review/claim-review.component';
import { TotalClaimSummaryComponent } from './total-claim-summary/total-claim-summary.component';



@NgModule({
  imports: [
    CommonModule,
    RcmClaimsRoutingModule,
    CsiGridModule,
    FormsModule,
    FormElementsModule,
    ReactiveFormsModule,
    CsiBaseModule,
    BsDatepickerModule.forRoot(),
    ModalModule.forRoot()
  ],
  declarations: [
    RcmClaimsComponent, 
    ClaimSummaryComponent, 
    ClaimSearchComponent,
    ClaimGridComponent,
    ClaimSubmissionComponent,
    ClaimSummaryBodyComponent,
    ClaimSubmissionFooterComponent,
    ClaimReviewComponent,
    TotalClaimSummaryComponent
    ],
  providers: [
    MasterDataService,
    CsiHttpService,
    DateConvertService,
    SearchClaimService
  ]
})

export class RcmClaimsModule extends CsiBaseModule {
  constructor(){
    super();
  }
}