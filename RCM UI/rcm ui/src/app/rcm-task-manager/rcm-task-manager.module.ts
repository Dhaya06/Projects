import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RcmTaskManagerRoutingModule } from './rcm-task-manager-routing.module';
import { RcmTaskManagerComponent } from './rcm-task-manager.component';
import { CreateTaskComponent } from './create-task/create-task.component';
import { TaskListComponent } from './task-list/task-list.component';
import { SearchTaskComponent } from './search-task/search-task.component';
import { CsiGridModule } from '../../../csi-web-base/csi-grid/csi-grid.module';
import { TaskListService } from './task-list/task-list.service';
import { CsiHttpService } from '../../../csi-web-base/csi-http-handler/csi-http.service';
import { HttpClientModule } from '@angular/common/http';
import { NgDragDropModule } from 'ng-drag-drop';
import {SortablejsModule} from 'angular-sortablejs'
import { ModalModule } from 'ngx-bootstrap/modal';
import { DropDownsModule } from '@progress/kendo-angular-dropdowns';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { CreateTaskService } from './create-task/create-task.service';
import { SearchTaskService } from './search-task/search-task.service';
import { FormElementsModule } from '../../../csi-web-base/csi-form-elements/form-elements.module';
import { CsiBaseModule } from 'csi-base';
import { MasterDataService } from '../rcm-master-data/master-data.service';
import { DateConvertService } from '../_shared/date-convert.service';

@NgModule({
  imports: [
    CommonModule,
    RcmTaskManagerRoutingModule,
    CsiGridModule,
    HttpClientModule,
    NgDragDropModule.forRoot(),
    SortablejsModule.forRoot({ animation: 150 }),
    ModalModule.forRoot(),
    DropDownsModule,
    FormsModule,
    FormElementsModule,
    ReactiveFormsModule,
    BsDatepickerModule.forRoot(),
    CsiBaseModule
  ],
  declarations: [RcmTaskManagerComponent, CreateTaskComponent, TaskListComponent, SearchTaskComponent],
  providers: [
    TaskListService,
    CsiHttpService,
    CreateTaskService,
    SearchTaskService,
    MasterDataService,
    DateConvertService
  ]
})


export class RcmTaskManagerModule extends CsiBaseModule {
  constructor(){
    super();
  }
}