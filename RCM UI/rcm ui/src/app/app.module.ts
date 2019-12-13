import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { RcmLayoutComponent } from './rcm-layout/rcm-layout.component';
import { RcmAppRoutingModule } from './app.route';
import { LeftMenuComponent } from './rcm-layout/left-menu/left-menu.component';
import { TopHeaderComponent } from './rcm-layout/top-header/top-header.component';
import { RcmClaimModule } from './rcm-claim/rcm-claim.module';

import { CsiToastsModule, CsiToastsServiceService } from 'csi-toastr';
import { ExpandableListModule } from 'angular2-expandable-list';
import {CsiAlertModule, CsiAlertService} from 'csi-alert';
import { CsiPageLayoutModule } from '../../csi-web-base/csi-page-layout/csi-page-layout.module';
import { CsiDataParserModule } from '../../csi-web-base/csi-data-parser/csi-data-parser.module';
import { CsiHttpService } from '../../csi-web-base/csi-http-handler/csi-http.service';
import { RcmCompanyGroupComponent } from './rcm-company-group/rcm-company-group.component';
import { CsiBaseModule } from 'csi-base';




@NgModule({
  declarations: [
    AppComponent,
    RcmLayoutComponent,
    LeftMenuComponent,
    TopHeaderComponent,
    RcmCompanyGroupComponent
  ],
  imports: [
    BrowserModule,
    //RcmClaimModule,
    CsiToastsModule, 
    CsiAlertModule,
    ExpandableListModule, // import Angular's ExpandableListModule modules
    CsiPageLayoutModule,
    CsiDataParserModule,
    CsiBaseModule,
    FormsModule,
    HttpClientModule,
    RcmAppRoutingModule,HttpModule
    
  ],
  providers: [CsiToastsServiceService,CsiAlertService,CsiHttpService],
  bootstrap: [AppComponent]
})
export class AppModule extends CsiBaseModule {
  constructor(){
    super();
  }
 }
