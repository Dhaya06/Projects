import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CsiFormComponent } from './csi-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormElementsModule } from '../csi-form-elements/form-elements.module';
import { CsiPageLayoutModule } from '../csi-page-layout/csi-page-layout.module';
import { CsiFormBuilderService } from './services/csi-form-builder/csi-form-builder.service';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormElementsModule,
    CsiPageLayoutModule
  ],
  declarations: [CsiFormComponent],
  providers: [CsiFormBuilderService],
  exports: [CsiFormComponent]
})
export class CsiFormModule { }
