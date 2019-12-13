import {Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import { CsiGridColumn, CsiGridOptions } from "../../../../../csi-web-base/csi-grid/csi-grid.model";

@Component({
  selector: 'app-claim-summary-body',
  templateUrl: './claim-summary-body.component.html',
  styleUrls: ['./claim-summary-body.component.scss']
})
export class ClaimSummaryBodyComponent implements OnInit {

  dataSet: any[] = [];
  @Input() dataItem: any[] = [];

  totaldataSet: any[] = [];
  cleanDataSet: any[] = [];
  errorDataSet: any[] = [];

 cleanCompany: any[] = [];
 errorCompany: any[] = [];

  cleanEncounter: any[] = [];
  errorEncounter: any[] = [];

  cleanCount: number =0;
  errorCount: number =0;
  totoalCount: number =0;

  cleanAmount: number = 0;
  errorAmount: number = 0;
  totoalAmount: number = 0;

  selectedAssigneeCount: number = 0;
  columns: CsiGridColumn[] = [];
  Assignees: any[]= [];
  totalAssignees: any[]= [];
  errorAssignees: any[]= [];
  cleanAssignees: any[]= [];


  public gridOptions1: CsiGridOptions;
  public gridOptions2: CsiGridOptions;
  public gridOptions3: CsiGridOptions;

  selectedItems: any[] = [];
  selectedItems2: any[] = [];
  selectedItems3: any[] = [];


  cleanTitle: String = "CLEAN CLAIMS";
  errorTitle: String = "ERROR CLAIMS";
  totalTitle: String = "TOTAL CLAIMS";
  SelectedTitle: String;

  @ViewChild('layer1Template') private layer1TemplateTpl: TemplateRef<any>;
  @ViewChild('layer2Template') private layer2TemplateTpl: TemplateRef<any>;


  constructor() {

  }

  ngOnInit() {
    /*this.cleanCount = 10;*/

    this.gridOptions1 = {
      sortable: true,
      pageable: true,
      pageSize: 30,
      scrollable: true,
      filterable: true,
      groupable: true,
      skip: 0,
      selectable: {
        enable: true,
        selectedRows: this.selectedItems,
        width: 40
      },
      /*editable: {
        enable: false,
        onUpdate: this.updateRow,
        formGroup: this.UpdateFormGroup
      },*/
      /*rowDisabled: (dataItem => {
        return dataItem.id == 3;
      }),*/
      rowDetailsTemplate: this.layer1TemplateTpl
    };

    this.gridOptions2 = {
      sortable: false,
      pageable: false,
      pageSize: 20,
      scrollable: false,
      filterable: false,
      groupable: false,
      skip: 0,
      selectable: {
        enable: true,
        selectedRows: this.selectedItems2,
        width: 40
      },
      /*editable: {
        enable: false,
        onUpdate: this.updateRow,
        formGroup: this.UpdateFormGroup
      },*/
      rowDetailsTemplate: this.layer2TemplateTpl
    };

    this.gridOptions3 = {
      sortable: false,
      pageable: false,
      pageSize: 50,
      scrollable: false,
      filterable: false,
      groupable: false,
      skip: 0,
      selectable: {
        enable: true,
        selectedRows: this.selectedItems3,
        width: 40
      },
      /*editable: {
        enable: false,
        onUpdate: this.updateRow,
        formGroup: this.UpdateFormGroup
      }*/
    };

    this.dataItem =  [
      {
        "insuranceGroup": "BUPA",
        "companies": [
          {
            "companyId": "ARAMCO",
            "encounters": [
              {
                "encounterId": "ENC123",
                "amount": 10000,
                "assignTo": "Aziz",
                "claimlabel": "CLEAN"
              },
              {
                "encounterId": "ENC124",
                "amount": 20000,
                "assignTo": "Aziz",
                "claimlabel": "ERROR"
              }
            ]
          },
          {
            "companyId": "AL-RAJHI",
            "encounters": [
              {
                "encounterId": "ENC125",
                "amount": 30000,
                "assignTo": "Saleem",
                "claimlabel": "ERROR"
              },
              {
                "encounterId": "ENC126",
                "amount": 40000,
                "assignTo": "Saleem",
                "claimlabel": "ERROR"
              }
            ]
          }
        ]
      },
      {
        "insuranceGroup": "MEDGULF",
        "companies": [
          {
            "companyId": "SAMBA",
            "encounters": [
              {
                "encounterId": "ENC127",
                "amount": 5000,
                "assignTo": "Aziz",
                "claimlabel": "CLEAN"
              },
              {
                "encounterId": "ENC128",
                "amount": 6000,
                "assignTo": "Aziz",
                "claimlabel": "ERROR"
              }
            ]
          },
          {
            "companyId": "ARAMCO",
            "encounters": [
              {
                "encounterId": "ENC129",
                "amount": 7000,
                "assignTo": "Saleem",
                "claimlabel": "CLEAN"
              },
              {
                "encounterId": "ENC130",
                "amount": 8000,
                "assignTo": "Saleem",
                "claimlabel": "ERROR"
              }
            ]
          }
        ]
      },
      {
        "insuranceGroup": "TAWUNIYA",
        "companies": [
          {
            "companyId": "ARAMCO",
            "encounters": [
              {
                "encounterId": "ENC123",
                "amount": 10000,
                "assignTo": "Aziz",
                "claimlabel": "CLEAN"
              },
              {
                "encounterId": "ENC124",
                "amount": 20000,
                "assignTo": "Aziz",
                "claimlabel": "ERROR"
              }
            ]
          },
          {
            "companyId": "AL-RAJHI",
            "encounters": [
              {
                "encounterId": "ENC125",
                "amount": 30000,
                "assignTo": "Saleem",
                "claimlabel": "ERROR"
              },
              {
                "encounterId": "ENC126",
                "amount": 40000,
                "assignTo": "Saleem",
                "claimlabel": "ERROR"
              }
            ]
          }
        ]
      }
    ];

    this.columns = [
      {
        field: "insuranceGroup", // -> fields from database array
        title: "Insurance Group"
      }, {
        field: "companyId",
        title: "Company Name / ID"
      }, {
        field: "encounterId",
        title: "Encounter Number"
      }, {
        field: "amount",
        title: "Amount"
      }, {
        field: "assignTo",
        title: "Assign To"
      }
    ];

    this.SelectedTitle = this.totalTitle;

    this.totaldataSet = this.dataItem;
    this.cleanDataSet = JSON.parse(JSON.stringify(this.dataItem));
    this.errorDataSet = JSON.parse(JSON.stringify(this.dataItem));

    for (let insuranceGroup of this.dataItem) {
      for (let company of insuranceGroup.companies){
        for (let encounter of company.encounters) {
          this.totoalAmount = this.totoalAmount + encounter.amount;
          this.totoalCount += 1;
          this.totalAssignees.push(encounter.assignTo + " ");

          if (encounter.claimlabel === "CLEAN") {
            this.cleanAmount += encounter.amount;
            this.cleanCount += 1;
            this.cleanAssignees.push(encounter.assignTo + " ");
          }
          if (encounter.claimlabel === "ERROR") {
            this.errorAmount += encounter.amount;
            this.errorCount += 1;
            this.errorAssignees.push(encounter.assignTo + " ");
          }
        }
      }
    }

    this.errorDataSet.forEach(i => {
      i.companies.forEach(c => {
        c.encounters = c.encounters.filter(e => e.claimlabel === "ERROR");
        console.log(c.encounters);
      });
    });

    /*this.errorDataSet.forEach(i => {
      if (i.companies.encounters === 0) {
        this.errorDataSet.splice(i,1);
      }
    });*/

    this.cleanDataSet.forEach(i => {
      i.companies.forEach(c => {
        c.encounters = c.encounters.filter(e => e.claimlabel === "CLEAN");
      });
    });

    /*this.cleanDataSet.forEach(i => {
      if (i.companies.length === 0) {
        this.cleanDataSet.splice(i,1);
      }
    });*/

    console.log(this.errorDataSet);
    console.log(this.cleanDataSet);
    console.log(this.dataItem);

    this.totalAssignees = this.removeDuplicateUsingFilter(this.totalAssignees);
    this.cleanAssignees = this.removeDuplicateUsingFilter(this.cleanAssignees);
    this.errorAssignees = this.removeDuplicateUsingFilter(this.errorAssignees);
    this.selectedAssigneeCount = this.totalAssignees.length;
    this.Assignees = this.totalAssignees;
  }

  toggleClean_list() {

    this.SelectedTitle = this.cleanTitle;
    this.Assignees = this.cleanAssignees;
    this.selectedAssigneeCount = this.cleanAssignees.length;
    // dataItem=null;
    this.dataItem = this.cleanDataSet;
    console.log(this.dataItem);

  }

  toggleTotal_list() {
    this.SelectedTitle = this.totalTitle;
    this.dataItem = this.totaldataSet;
    this.Assignees = this.totalAssignees;
    this.selectedAssigneeCount = this.totalAssignees.length;
    console.log(this.dataItem);
  }

  toggleError_list() {
    /*this.dataSet = this.totaldataSet.filter(entry => entry.status === "ERROR");*/
    this.SelectedTitle = this.errorTitle;
    this.Assignees = this.errorAssignees;
    this.selectedAssigneeCount = this.errorAssignees.length;
    // dataItem=null;
    this.dataItem = this.errorDataSet;
    console.log(this.dataItem);
  }

  rowClicked($event) {
    console.log($event);
  }

  removeDuplicateUsingFilter(arr){
    let unique_array = arr.filter(function(elem, index, self) {
      return index == self.indexOf(elem);
    });
    return unique_array;
  }

  setDataItemforComponent (dataItem) {
    this.dataItem = dataItem;
  }

}
