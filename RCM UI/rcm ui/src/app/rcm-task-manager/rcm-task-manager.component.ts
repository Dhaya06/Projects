import { Component, OnInit } from '@angular/core';
import { CsiToastsServiceService } from 'csi-toastr';
import { CsiAlertService } from 'csi-alert';
import { FormGroup, FormControl } from '@angular/forms';
//import { CommonValidator } from 'csi-validation-library';

@Component({
  selector: 'app-rcm-task-manager',
  templateUrl: './rcm-task-manager.component.html',
  styleUrls: ['./rcm-task-manager.component.scss']
})
export class RcmTaskManagerComponent implements OnInit {

  public userForm : FormGroup;

  constructor(private toastr: CsiToastsServiceService,private csiAlertService: CsiAlertService) 
  { }

   
  ngOnInit() {
    this.userForm = new FormGroup({
      // userEmail: new FormControl('',""),
      // phoneNumber : new FormControl('',CommonValidator.phone)
    });
}

}
