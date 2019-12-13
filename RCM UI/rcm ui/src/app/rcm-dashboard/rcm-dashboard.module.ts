import { NgModule   } from '@angular/core';
import { FormsModule   } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { RcmDashboardRoutingModule } from './rcm-dashboard-routing.module';
import { RcmDashboardComponent } from './rcm-dashboard.component';
import { ChartModule } from '@progress/kendo-angular-charts';
import 'hammerjs';

@NgModule({
  imports: [
    CommonModule,
    RcmDashboardRoutingModule,
    ChartModule,
    FormsModule 
  ],
  declarations: [RcmDashboardComponent]
})
export class RcmDashboardModule { }
