import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RcmRulesRoutingModule } from './rcm-rules-routing.module';
import { RcmRulesComponent } from './rcm-rules.component';

@NgModule({
  imports: [
    CommonModule,
    RcmRulesRoutingModule
  ],
  declarations: [RcmRulesComponent]
})
export class RcmRulesModule { }
