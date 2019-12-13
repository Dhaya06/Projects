import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RcmMasterDataComponent } from './rcm-master-data.component';

const routes: Routes = [
  {
    path: '',
    component: RcmMasterDataComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RcmMasterDataRoutingModule { }
