import { Component, OnInit } from '@angular/core';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';

@Component({
  selector: 'app-claim-slide-panel',
  templateUrl: './claim-slide-panel.component.html',
  styleUrls: ['./claim-slide-panel.component.scss']
})

@ComponentRegistry({
  componentId: "d5167644-849b-4714-a8e1-2435960ba8a2"
  })
  
export class ClaimSlidePanelComponent extends CsiBaseComponent {

  constructor() { 
    super();
  }

  ngOnInit() {
  }

}
