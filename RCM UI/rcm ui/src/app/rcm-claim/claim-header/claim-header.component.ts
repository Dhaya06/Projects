import {Component, OnInit} from '@angular/core';
import {CsiBaseComponent, ComponentRegistry} from 'csi-base';
import {CsiSelectOption} from '../../../../csi-web-base/csi-form-elements/models/csi-select.model';
import {MasterDataService} from '../../rcm-master-data/master-data.service';
import {AbstractControl, AsyncValidatorFn, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {ClaimService} from "../claim.service";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'rcm-claim-header',
  templateUrl: './claim-header.component.html',
  styleUrls: ['./claim-header.component.scss']
})

@ComponentRegistry({
  componentId: '3d3a796b-1549-4361-9d8f-aadac9ce653d'
})

export class ClaimHeaderComponent extends CsiBaseComponent {

  filterTypes: any;

  claimHeader: FormGroup
  facilities: [CsiSelectOption]
  clinics: any[]
  isuranceGroups: [CsiSelectOption]
  isuranceCompanies: [CsiSelectOption]
  policy: [CsiSelectOption]
  encounterTypes: [CsiSelectOption]
  doctors = []
  claimlistId: number;
  claim: any = {};
  patient:any = {}
  doctor:any = {}
  clinic:any = {}
  clinicId:number;
  medErrorMap:any;
  claimLable:any;
  claimLableType:any;
  appointments = []
  value = 0.00;

  claimStatus= 'NEW';

  claimFilters = Array<ClaimFilter>();

  constructor(private masterDataService: MasterDataService, private route: ActivatedRoute,
              private router: Router, private claimService: ClaimService) {
    super();
  }

  ngOnInit() {
    this.initForm();
    this.claimHeader = new FormGroup({
      payerId: new FormControl(),
      companyId: new FormControl(),
      policy: new FormControl(),
      policyNumber: new FormControl(),
      encounterStartType: new FormControl(),
      encounterEndType: new FormControl(),
      encounterType: new FormControl(),
      id: new FormControl(),
      referenceNo: new FormControl(),
      invoiceNo: new FormControl(),
      companyShare: new FormControl(),
      patientShare: new FormControl(),
      encounterId: new FormControl(),
      serviceEndTime: new FormControl(),
      serviceStartTime: new FormControl()
    });
   
  }


  public setClaim(claim:any){
    if(claim != null){
      this.claimlistId = claim.id;
      this.claim = claim;
      this.patient = this.claim.patient

      this.appointments = claim.appointments
      this.medErrorMap = claim.medErrorMap;
      this.claimLable = claim.claimLable;
      this.claimLableType = claim.claimLableType

      for(let appointment of this.appointments ){
        this.value = this.value + appointment.grossAmount;
      }

      this.claimHeader.patchValue({
        policyNumber: claim.policyNumber,
        payerId: claim.payerId,
        companyId: claim.companyId,
        policy : 3,
        encounterStartType: claim.encounterStartType,
        encounterEndType: claim.encounterEndType,
        encounterType: claim.encounterType,
        id: claim.id,
        referenceNo: claim.referenceNo,
        invoiceNo: claim.invoiceNo,
        companyShare: claim.companyShare,
        patientShare: claim.patientShare,
        encounterId: claim.encounterId,
        serviceEndTime: claim.serviceEndTime,
        serviceStartTime: claim.serviceStartTime
      })

      this.updateComanyList();
      this.doctor =  this.getDoctorFromId(claim.doctorId);
      this.clinic = this.getClinicFromId(claim.clinicId);
    }
  }

  initForm() {
    this.masterDataService.GetActiveFacilities().subscribe(facilities => {
      this.facilities = facilities.map(facility => {
        return { id:facility.hospital_id,name:facility.hospital_name }
      });
    });
    this.masterDataService.GetActiveInsuranceGroup().subscribe(groups =>{
      this.isuranceGroups = groups.map(data => {
        return {id:data.group_id,name:data.group_name}
      });
    });
    this.masterDataService.GetActiveCompanies().subscribe(companies => {
      this.isuranceCompanies = companies.map(data =>{
        return {id:data.company_id,name:data.company_name}
      })
    });
    this.policy = this.masterDataService.GetActivePolicy();
    this.masterDataService.GetActiveEncounterTypes().subscribe(encounterTypes =>{
      this.encounterTypes = encounterTypes.map(data => {
        return {id:data.encounter_id, name:data.name};
      })
    });
    this.masterDataService.GetActiveClinics().subscribe(clinics => {
      this.clinics = clinics;
    });

    this.masterDataService.GetActiveDoctors().subscribe(doctors => {
      this.doctors = doctors;
    });

  }

  updateComanyList(){
    this.masterDataService.GetActiveCompaniesByGroup(this.claimHeader.get('payerId').value).subscribe(companies => {
      this.isuranceCompanies = companies.map(data =>{
        return {id:data.company_id,name:data.company_name}
      })
    });
  }

  private getDoctorFromId(id:any){
    if(this.doctors == null){
      return {doctor_id:""};
    }
    for(let data of this.doctors){
      if(data.doctor_id === id){
        return data;
      }
    }
    return {doctor_id:""};
  }

  private getClinicFromId(id:any){
    if(this.clinics == null){
      return {};
    }
   
    for(let data of this.clinics){
      if(data.clinic_id === id){
        return data;
      }
    }
    return {};
  }


  diffYears(dt2:Date) {
    alert(dt2);
    if(dt2 == null || dt2 == undefined){
      return;
    }

    var diff =(dt2.getTime() - new Date().getTime()) / 1000;
    diff /= (60 * 60 * 24);
    return Math.abs(Math.round(diff/365.25));
    
  }

  getValueFromList(list:any[],id:any){
    if(list == null){
      return {name:""};
    }
    for(let data of list){
      if(data.id === id){
        return data;
      }
    }
    return {name:""};
  }


  public getClaimHeaderValue():any
  {
    let value = this.claimHeader.value;
    value['patient'] = this.patient;
    value['clinicId'] = this.clinicId;
    value['claimStatus'] = this.claimStatus;
    value['medErrorMap'] = this.medErrorMap;
    value['claimLable'] = this.claimLable;
    value['claimLableType'] = this.claimLableType;
    return value;
  }

}

class ClaimFilter {
  id: number;
  order: number;
  filterType: { name: string, type: string, id: number, values: [any] } = {name: "", type: "", id: 0, values: [{}]};
  filterValues: Array<{ name: string, filterId: string, dateFrom: string, dateTo: string }> = [];
}
