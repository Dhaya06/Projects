import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { SearchTaskService } from './search-task.service';
import { CsiSelectOption } from '../../../../csi-web-base/csi-form-elements/models/csi-select.model';
import { FormGroup, FormControl,Validators } from '@angular/forms';
import { MasterDataService } from '../../rcm-master-data/master-data.service';
@Component({
  selector: 'rcm-search-task',
  templateUrl: './search-task.component.html',
  styleUrls: ['./search-task.component.scss']
})

@ComponentRegistry({
  componentId: "b130ebe8-c278-4292-b3c8-631954d561b6"
  })
export class SearchTaskComponent  extends CsiBaseComponent {
  constructor(private searchTaskService:SearchTaskService,private masterDataService: MasterDataService ) {
    super();
  }

  @Output() searchWorkListEvent = new EventEmitter();


  //user[]:any[];
  searchWorkList:FormGroup
  facilities:[CsiSelectOption]
  insuranceGroup:[CsiSelectOption]
  companies:[CsiSelectOption]
  periodType:[CsiSelectOption]
  users:[CsiSelectOption]

  ngOnInit() {
    this.searchWorkList = new FormGroup({
      name:new FormControl(),
      dateRange: new FormControl()
    });

    this.facilities  = this.masterDataService.GetActiveFacilities();
    this.masterDataService.GetActiveInsuranceGroup().subscribe(groups =>{
      this.insuranceGroup = groups.map(data => {
        return {id:data.group_id,name:data.group_name}
      });
    });
    this.masterDataService.GetActiveCompanies().subscribe(companies => {
      this.companies = companies.map(data =>{
        return {id:data.company_id,name:data.company_name}
      })
    });
    //this.users =[{id:1,name:"Ameen"},{id:2,name:"Raheel"},{id:3,name:"Muhammed"}];
  }

  onSubmit(){
    this.searchWorkListEvent.emit(null);
  }

}
