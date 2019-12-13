import { Component, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';

@Component({
  selector: 'app-diagnosis-remark-modal',
  templateUrl: './diagnosis-remark-modal.component.html',
  styleUrls: ['./diagnosis-remark-modal.component.scss']
})

@ComponentRegistry({
  componentId: "ee1afb5f-2802-4e47-85fb-8fa5ac820a8c"
  })
  
export class DiagnosisRemarkModalComponent extends CsiBaseComponent {

  constructor(public bsModalRef: BsModalRef) { 
    super(); 
  }

  ngOnInit() {
  }

}
