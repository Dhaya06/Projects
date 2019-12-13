import { Component } from '@angular/core';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { PayerProfileService } from './rcm-payer-profile/rcm-payer-profile.service';
import { CompanyGroupService } from './rcm-company-group/rcm-company-group.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers:[PayerProfileService,CompanyGroupService]
})

@ComponentRegistry({
  componentId: "d2491339-622a-4dc5-8b34-8cf10bbdb481",
})
export class AppComponent extends CsiBaseComponent {
  constructor(){
    super();
  }
}