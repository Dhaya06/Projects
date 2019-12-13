import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RcmMasterDataRoutingModule } from './rcm-master-data-routing.module';
import { RcmMasterDataComponent } from './rcm-master-data.component';
import { CsiHttpService } from '../../../csi-web-base/csi-http-handler/csi-http.service';

@NgModule({
  imports: [
    CommonModule,
    RcmMasterDataRoutingModule
  ],
  declarations: [RcmMasterDataComponent],
  providers:[CsiHttpService]
})
export class RcmMasterDataModule { }
