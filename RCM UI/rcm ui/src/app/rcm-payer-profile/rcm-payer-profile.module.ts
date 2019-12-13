import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RcmPayerProfileRoutingModule } from './rcm-payer-profile-routing.module';
import { CreateNewProfileComponent } from './create-new-profile/create-new-profile.component';
import { PayerGridComponent } from './payer-grid/payer-grid.component';
import { RcmPayerProfileComponent } from './rcm-payer-profile.component';
import { CsiGridModule } from '../../../csi-web-base/csi-grid/csi-grid.module';
import { FormElementsModule } from '../../../csi-web-base/csi-form-elements/form-elements.module';
import { ReactiveFormsModule } from '@angular/forms';
import { CsiBaseModule } from 'csi-base';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { ConvertToDays } from '../_shared/convet-to-days.pipe';
import { ConvertToYesNo } from '../_shared/convert-to-yesno.pipe';
import { ProductEditGuard } from './rcm-payer-profile.guard.service';
import { ButtonsModule } from 'ngx-bootstrap';

@NgModule({
  imports: [
    CommonModule,
    CsiGridModule,
    FormElementsModule,
    ReactiveFormsModule,
    CsiBaseModule,
    RcmPayerProfileRoutingModule,
    ButtonsModule.forRoot()
  ],
  declarations: [CreateNewProfileComponent, PayerGridComponent, 
               RcmPayerProfileComponent, UpdateProfileComponent,
               ConvertToDays,ConvertToYesNo],
  providers: [ProductEditGuard]
})
export class RcmPayerProfileModule { 

  
}
