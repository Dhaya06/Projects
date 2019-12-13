import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RcmDashboardComponent } from './rcm-dashboard.component';

const routes: Routes = [
  {
    path: '',
    component: RcmDashboardComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RcmDashboardRoutingModule { }
