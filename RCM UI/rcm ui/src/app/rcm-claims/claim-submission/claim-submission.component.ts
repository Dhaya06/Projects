import {Component, OnInit, Output, EventEmitter, Input} from '@angular/core';

@Component({
  selector: 'app-claim-submission',
  templateUrl: './claim-submission.component.html',
  styleUrls: ['./claim-submission.component.scss']
})
export class ClaimSubmissionComponent implements OnInit {

  @Output() hideModal = new EventEmitter();

  dataSet: any[] = [];
  @Input() dataItem: any[] = [];

  groups: any[] = [];
  companies: any[] = [];

  constructor() { }

  ngOnInit() {

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
                "claimStatus": "CLEAN"
              },
              {
                "encounterId": "ENC124",
                "amount": 20000,
                "assignTo": "Aziz",
                "claimStatus": "ERROR"
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
                "claimStatus": "ERROR"
              },
              {
                "encounterId": "ENC126",
                "amount": 40000,
                "assignTo": "Saleem",
                "claimStatus": "ERROR"
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
                "claimStatus": "CLEAN"
              },
              {
                "encounterId": "ENC128",
                "amount": 6000,
                "assignTo": "Aziz",
                "claimStatus": "ERROR"
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
                "claimStatus": "CLEAN"
              },
              {
                "encounterId": "ENC130",
                "amount": 8000,
                "assignTo": "Saleem",
                "claimStatus": "ERROR"
              }
            ]
          }
        ]
      }
    ];

    for (let insuranceGroup of this.dataItem) {
      this.groups.push(insuranceGroup.insuranceGroup);
      for (let company of insuranceGroup.companies){
        if (!this.companies.includes(company)) {
          this.companies.push(company.companyId);
        }
      }
    }

    this.groups = this.removeDuplicateUsingFilter(this.groups);
    this.companies =this.removeDuplicateUsingFilter(this.companies);
  }

  closeModal() {
    this.hideModal.emit();
  }

  submitClaims() {
    this.hideModal.emit();
  }

  removeDuplicateUsingFilter(arr){
    let unique_array = arr.filter(function(elem, index, self) {
        return index == self.indexOf(elem);
    });
    return unique_array;
  }

  setDataItem (dataItem) {
    this.dataItem = dataItem;
    // 'app-claim-summary-body'.setDataItemforComponent(dataItem);
  }

}
