import { Component, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';


@Component({
  selector: 'rcm-diagnosis-modal',
  templateUrl: './diagnosis-modal.component.html',
  styleUrls: ['./diagnosis-modal.component.scss']
})

@ComponentRegistry({
componentId: "6e47bc93-8d4e-4bcd-9f51-9fe21e119fa1"
})
export class DiagnosisModalComponent extends CsiBaseComponent {

  constructor(public bsModalRef: BsModalRef) {
    super();
  }

  ngOnInit() {
    
  }

}
