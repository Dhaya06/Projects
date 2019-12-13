import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'total-claim-summary',
  templateUrl: './total-claim-summary.component.html',
  styleUrls: ['./total-claim-summary.component.scss']
})
export class TotalClaimSummaryComponent implements OnInit {

  totalClaims = []
  newClaims = []
  errorClaims = []
  cleanClaims = []
  completedClaims = []
  pendingClaims = []
  avgClaimperUser = "-"

  constructor() { }

  ngOnInit() {
  }

  initData(){
    this.totalClaims = []
    this.newClaims = []
    this.errorClaims = []
    this.cleanClaims = []
    this.completedClaims = []
    this.pendingClaims = []
    this.avgClaimperUser = "-"
  }

  setClaims(data:any){
    this.initData();
    if(data.length > 0){
      this.totalClaims = data;
      this.setupClaims();
    }
  }

  private setupClaims(){
    this.newClaims = this.totalClaims.filter(function(el){
      if(el.claimStatus === "NEW"){
        return el;
      }
    });

    this.errorClaims = this.totalClaims.filter(function(el){
      if(el.techErrorMap != null || el.medErrorMap != null){
        return el;
      }
    });
   
    this.cleanClaims = this.totalClaims.filter(function(el){
      if(el.techErrorMap == null && el.medErrorMap == null){
        return el;
      }
    });
    
    this.completedClaims = this.totalClaims.filter(function(el){
      if(el.claimStage == "INPROGRESS"){
        return el;
      }
    });

    this.pendingClaims = this.totalClaims.filter(function(el){
      if(el.claimStage != "COMPLETE"){
        return el;
      }
    });
 
    let assignedClaims = this.totalClaims.filter(function(el){
      if(el.process != null && el.process.length > 0){
        return el;
      }
    });

    let process = assignedClaims.map(claim => {
      return claim.process;
    })

    let users = [];
    for(let processUsers of process){
      for(let user of processUsers){
        users.push(user);
      }
    }

    if(users.length > 0){
      let average = Math.round(this.totalClaims.length / users.length);
      users = this.removeDuplicates(users);
      this.avgClaimperUser = average+"";
    }

  }

  private removeDuplicates(arr){
    let unique_array = []
    for(let i = 0;i < arr.length; i++){
        if(unique_array.indexOf(arr[i]) == -1){
            unique_array.push(arr[i])
        }
    }
    return unique_array
  }

}
