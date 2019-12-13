import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RcmRulesComponent } from './rcm-rules.component';

const routes: Routes = [
  {
    path: '',
    component: RcmRulesComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RcmRulesRoutingModule { }
