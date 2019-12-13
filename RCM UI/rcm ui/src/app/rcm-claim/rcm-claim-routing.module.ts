import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RcmClaimComponent } from './rcm-claim.component';
import { ClaimBodyComponent } from './claim-body/claim-body.component';

const routes: Routes = [
  {
    path: '',
    component: RcmClaimComponent
  },{
      path: ':claim_id',
      //canDeactivate: [ ProductEditGuard ],
      component: RcmClaimComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RcmClaimRoutingModule { }
