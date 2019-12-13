import { Component, OnInit, ViewChild, TemplateRef, Input, Output,EventEmitter, ContentChildren } from '@angular/core';
import { CsiGridColumn, CsiGridOptions } from '../../../../csi-web-base/csi-grid/csi-grid.model';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { DateConvertService } from '../../_shared/date-convert.service';
import {URLSearchParams} from '@angular/http'
import { SearchClaimService } from '../claim-search/search-claim.service';
import { MasterDataService } from '../../rcm-master-data/master-data.service';
import { Router, ActivatedRoute} from "@angular/router";
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service'
import { ClaimSubmissionComponent } from '../claim-submission/claim-submission.component';

@Component({
  selector: 'rcm-claim-grid',
  templateUrl: './claim-grid.component.html',
  styleUrls: ['./claim-grid.component.scss'],
  providers:[BsModalService]
})

@ComponentRegistry({
  componentId: "8d801687-d7e6-4dff-a370-c5f694be15e6"
  })

export class ClaimGridComponent extends CsiBaseComponent {

  constructor(private searchClaimService : SearchClaimService,private dateConverter:DateConvertService,
    private masterDataService:MasterDataService, private router: Router , private modalService: BsModalService) {
    super();
  }

  @Input() isClaimReview = false;
  @Output() publishClaims = new EventEmitter();

  loggedUser:any
  dataSet:any[] = [];
  claims:any[] = [];
  columns:CsiGridColumn[] = [];
  gridOptions: CsiGridOptions;
  gridOptions2:CsiGridOptions; 
  gridOptions3:CsiGridOptions;
  modalRef: BsModalRef;
  config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };


  facilities:any
  insuranceGroups:any
  insuranceCompanies:any
  claimLabels:any
  claimLabelTypes:any
  claimStatus:any
  policy :any
  memberids:any
  encounterTypes:any
  clinics:any
  selectedGrop: any[] = [];
  selectedCompany: any[] = [];
  selectedClaims: any[] = [];


  @ViewChild('insuranceGroup') private insuranceGroupTemplate: TemplateRef<any>;
  @ViewChild('company') private companyTemplate: TemplateRef<any>;
  @ViewChild('encounterType') private encounterTypeTemplate: TemplateRef<any>;
  @ViewChild('claimStatus') private claimStatusTemplate: TemplateRef<any>;
  @ViewChild('thumbnailTemplate') private thumbnailTemplate: TemplateRef<any>;
  @ViewChild('layer1Template') private layer1Template: TemplateRef<any>;
  @ViewChild('layer1Template2') private layer1Template2: TemplateRef<any>;

  @ViewChild('submission') claimSubmission:ClaimSubmissionComponent;
  
  ngOnInit() {

  this.initForm();
  //Define grid columns
  this.gridOptions = {
    pageable: true,
    pageSize: 10,
    rowDetailsTemplate: this.layer1Template,
    skip: 0,
    selectable: {
      enable: true,
      selectedRows: this.selectedGrop,
      width: 40
    }
  };

  this.gridOptions2 = {
    rowDetailsTemplate: this.layer1Template2,
    skip: 0,
    selectable: {
      enable: true,
      selectedRows: this.selectedCompany,
      width: 40
    }
  };

  this.gridOptions3 = {
    skip: 0,
    selectable: {
      enable: true,
      selectedRows: this.selectedClaims,
      width: 40
    }
  };

  this.columns = [
    {
      field : "companyId", // -> fields from database array
      title: "Insurance Group",     // -> Display name of the columns
      template: this.insuranceGroupTemplate
    }, {
      field: "companyId",
      title: "Company Name / ID",
      template:this.companyTemplate
    }, {
      field: "encounterId",
      title: "Encounter Number",
      template: this.thumbnailTemplate
    }, {
      field: "encounterType",
      title: "Encounter Type",
      template:this.encounterTypeTemplate
    }, {
      field: "patient.memberId",
      title: "Member ID"
    }, {
      field: "patient.patientId",
      title: "Patient ID"
    }, {
      field: "claimStatus",
      title: "Claim Status",
      template:this.claimStatusTemplate
    }, {
      field: "id",
      title: ""
    }
  ];

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
        return {id:data.company_id,name:data.company_name}
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
    // this.assignee = this.masterDataService.

    this.searchClaimService.Search(new URLSearchParams()).subscribe(res => {
      this.claims = res;
      this.dataSet =  res.group(function (item) {
        return item.payerId;
      });

      for(let item of  this.dataSet){
        item['data'] = item.data.group(function (data) {
          return data.companyId;
        });
      }

      console.log(this.dataSet);
      this.publishClaims.emit(null)
    });
  }

  update(id:number){
    this.router.navigate(['/claim/'+id]);
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

  getStatusFromList(id:any){
    for(let data of this.claimStatus){
      if(data.id === id){
        return data;
      }
    }
    return {name:""};

  }

  openModal(template: TemplateRef<any>) {
    
    this.modalRef = this.modalService.show(template,
      Object.assign({}, this.config, { class: 'gray modal-lg' }));

      console.log(this.selectedGrop);
      console.log(this.selectedCompany);
      console.log(this.selectedClaims);

    this.claimSubmission.setDataItem(this.selectedGrop);
  }


  hideModal(){
    this.modalService.hide(1);
  }

  searchClaims(options:any){
    let params = new URLSearchParams();
    params.append("name", options["name"]);

    params.append("dateFilterField", options["dateFilterField"]);

    if(options["dateRange"] != null){
      let fromDateString = this.dateConverter.convertDateToString(options["dateRange"][0],"/");
      let toDateString = this.dateConverter.convertDateToString(options["dateRange"][1],"/");

      params.append("dateFrom", fromDateString);
      params.append("dateTo", toDateString);
    }
    let facilities:any = options["facilities"];
    if(facilities != null ){
      for(let facility of facilities){
        params.append("facilities", facility.id);
      }
    }

    let claimLabels = options["claimLabels"];
    if(claimLabels != null ){
      for(let claimLabel of claimLabels){
        params.append("claimLabels", claimLabel.id);
      }
    }

    let claimLabelTypes = options["claimLabelTypes"];
    if(claimLabelTypes != null ){
      for(let claimLabelType of claimLabelTypes){
        params.append("claimLabelTypes", claimLabelType.id);
      }
    }

    let insuranceGroups = options["insuranceGroups"];
    if(insuranceGroups != null ){
      for(let insuranceGroup of insuranceGroups){
        params.append("insuranceGroups", insuranceGroup.id);
      }
    }

    let companyIDs = options["companyIDs"];
    if(companyIDs != null ){
      for(let companyID of companyIDs){
        params.append("companyIDs", companyID.id);
      }
    }

    let companyNames = options["companyNames"];
    if(companyNames != null ){
      for(let companyName of companyNames){
        params.append("companyNames", companyName.id);
      }
    }

    let memberIds = options["memberIds"];
    if(memberIds != null ){
      for(let memberId of memberIds){
        params.append("memberIds", memberId.id);
      }
    }

    let policies = options["policies"];
    if(policies != null ){
      for(let policiy of policies){
        params.append("policies", policiy.id);
      }
    }

    let encounterTypes = options["encounterTypes"];
    if(encounterTypes != null ){
      for(let encounterType of encounterTypes){
        params.append("encounterTypes", encounterType.id);
      }
    }

    let clinics = options["clinics"];
    if(encounterTypes != null ){
      for(let clinic of clinics){
        params.append("clinics", clinic.id);
      }
    }

    let assignees = options["assignees"];
    if(assignees != null ){
      for(let assignee of assignees){
        params.append("assignees", assignee.id);
      }
    }

    let claimStatus = options["claimStatus"];
    if(claimStatus != null ){
      for(let status of claimStatus){
        params.append("claimStatus", status.id);
      }
    }

    this.searchClaimService.Search(params).subscribe(res => {
      this.claims = res;
      this.dataSet =  res.group(function (item) {
        return item.payerId;
      });

      for(let item of  this.dataSet){
        item['data'] = item.data.group(function (data) {
          return data.companyId;
        });
      }
      this.publishClaims.emit(null)
    });
  }

  

}

Object.defineProperty(Array.prototype, 'group', {
  enumerable: false,
  value: function (key) {
    var map = {};
    this.forEach(function (e) {
      var k = key(e);
      map[k] = map[k] || [];
      map[k].push(e);
    });
    return Object.keys(map).map(function (k) {
      return {key: k, data: map[k]};
    });
  }
});