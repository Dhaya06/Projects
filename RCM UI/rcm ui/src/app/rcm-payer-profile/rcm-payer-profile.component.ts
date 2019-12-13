import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rcm-payer-profile',
  templateUrl: './rcm-payer-profile.component.html',
  styleUrls: ['./rcm-payer-profile.component.scss']
})
export class RcmPayerProfileComponent implements OnInit {

  isformshow = false;

  constructor() { }

  ngOnInit() {
  }

  saveForm(data){
    console.log("save form triggered!", data);
  }

}
