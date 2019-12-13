import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RcmClaimsComponent } from './rcm-claims.component';
import { ClaimReviewComponent } from './claim-review/claim-review.component';

const routes: Routes = [
  {
    path: '',
    component: RcmClaimsComponent
  },
  {
    path: 'claimreview',
    component: ClaimReviewComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RcmClaimsRoutingModule { }
