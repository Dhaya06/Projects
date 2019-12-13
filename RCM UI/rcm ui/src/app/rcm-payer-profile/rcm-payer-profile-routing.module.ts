import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RcmPayerProfileComponent } from './rcm-payer-profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { ProductEditGuard } from './rcm-payer-profile.guard.service'

const routes: Routes = [
  {
    path: '',
    component: RcmPayerProfileComponent
  },{
      path: ':profile_id',
      canDeactivate: [ ProductEditGuard ],
      component: UpdateProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RcmPayerProfileRoutingModule { }
