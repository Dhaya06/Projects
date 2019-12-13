import { Component, OnInit } from '@angular/core';
import { CsiBaseComponent } from 'csi-base';

@Component({
  selector: 'app-rcm-dashboard',
  templateUrl: './rcm-dashboard.component.html',
  styleUrls: ['./rcm-dashboard.component.scss']
})
export class RcmDashboardComponent extends CsiBaseComponent {
  
  revenuSummery : any = ['Average Claim','Errors','Hightest Denials'];
  selectedrevenuSummery = this.revenuSummery[0];
  revenuSummerySub : any = ['By Doctor','By Diagnosis','By CPT','By Speciality'];
  selectedrevenuSummerySub = this.revenuSummerySub[0];
  status:boolean = false;

  constructor() { 
    super();
  }

  ngOnInit() {
  }

  onChange(newValue) {
    this.status = !this.status;
  }


  public series1: any[] = [{
    name: "RCM Data",
    data: [2.907, 5.943, 6.848, 2.284, 5.263, 19.801, 11.890, 9.238, 6.552, 0.855]
  }];

  public series2: any[] = [{
    name: "RCM Data",
    data: [3.907, 7.943, 7.848, 9.284, 9.263, 9.801, 3.890, 8.238, 9.552, 6.855]
  }];
  public categories: number[] = [2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011];

}
