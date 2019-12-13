import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RcmTaskManagerComponent } from './rcm-task-manager.component';

const routes: Routes = [
  {
    path: '',
    component: RcmTaskManagerComponent
  },
  {
    path: ':task_id',
    component: RcmTaskManagerComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RcmTaskManagerRoutingModule { }
