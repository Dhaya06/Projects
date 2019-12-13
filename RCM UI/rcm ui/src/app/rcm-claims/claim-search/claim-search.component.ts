import { Component, OnInit,EventEmitter,Output } from '@angular/core';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { CsiSelectOption } from '../../../../csi-web-base/csi-form-elements/models/csi-select.model';
import { FormGroup, FormControl,Validators } from '@angular/forms';
import { MasterDataService } from '../../rcm-master-data/master-data.service';

@Component({
  selector: 'rcm-claim-search',
  templateUrl: './claim-search.component.html',
  styleUrls: ['./claim-search.component.scss']
})

@ComponentRegistry({
  componentId: "45f6ac5e-fafa-4b7c-9ae3-b9013fb9c077"
  })
export class ClaimSearchComponent extends CsiBaseComponent   {

  searcClaim:FormGroup
  facilities:[CsiSelectOption]
  insuranceGroups:[CsiSelectOption]
  insuranceCompanies:[CsiSelectOption]
  claimLabels:[CsiSelectOption]
  claimLabelTypes:[CsiSelectOption]
  claimStatus:[CsiSelectOption]
  policy :[CsiSelectOption]
  memberids:[CsiSelectOption]
  encounterTypes:[CsiSelectOption]
  clinics:[CsiSelectOption]
  assignee =[{name:"Ameen",id:1},{name:"Raheel",id:2},{name:"Muhammed",id:3}]

  @Output() claimsearchEvent = new EventEmitter();

  constructor(private masterDataService:MasterDataService) {
    super();
   }

  ngOnInit() {
    this.initForm();
    this.searcClaim = new FormGroup({
      facilities: new FormControl(),
      users:new FormControl(),
      dateRange: new FormControl(),
      claimLabel:new FormControl(),
      claimLabelType:new FormControl(),
      claimStatus:new FormControl(),
      companies:new FormControl(),
      dateFilterField: new FormControl()
    });
  }

  initForm(){
    this.masterDataService.GetActiveFacilities().subscribe(facilities => {
      this.facilities = facilities.map(facility => {
        return { id:facility.hospital_id,name:facility.hospital_name }
      });
    });
    this.masterDataService.GetActiveInsuranceGroup().subscribe(groups =>{
      this.insuranceGroups = groups.map(data => {
        return {id:data.group_id,name:data.group_name}
      });
    });
    this.masterDataService.GetActiveCompanies().subscribe(companies => {
      this.insuranceCompanies = companies.map(data =>{
        return {id:data.company_id,name:data.company_name +' - '+data.company_id}
      })
    });
    this.claimLabels = this.masterDataService.GetActiveClaimLabels();
    this.claimLabelTypes =  this.masterDataService.GetActiveClaimLabelTypes();
    this.claimStatus = this.masterDataService.GetActiveClaimStatus();
    this.policy = this.masterDataService.GetActivePolicy();
    this.masterDataService.GetActiveEncounterTypes().subscribe(encounterTypes =>{
      this.encounterTypes = encounterTypes.map(data => {
        return {id:data.encounter_id, name:data.name};
      })
    });
    this.masterDataService.GetActiveClinics().subscribe(clinics => {
      this.clinics = clinics.map(data => {
        return {id:data.clinic_id, name: data.clinic_description};
      })
    });
    this.masterDataService.GetActivePatients().subscribe(patient => {
      this.memberids = patient.map( data => {
        return {id:data.patient_id,name:data.patient_name}
      })
    })
  }

  onSubmit(){
    this.claimsearchEvent.emit(null);
  }

}
