import { Component, OnInit } from '@angular/core';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { SearchClaimService } from '../claim-search/search-claim.service';
import {URLSearchParams} from '@angular/http'


@Component({
  selector: 'rcm-claim-summary',
  templateUrl: './claim-summary.component.html',
  styleUrls: ['./claim-summary.component.scss']
})

@ComponentRegistry({
  componentId: "b030e953-5326-45e2-b458-5e6f1a40cba3"
  })
export class ClaimSummaryComponent  extends CsiBaseComponent    {

  myClaims:any[] = []
  completedClaims = []
  pendingClaims = []

  constructor(private searchClaimService : SearchClaimService) { 
    super();
  }
 
  ngOnInit() {
    this.searchClaimService.Search(new URLSearchParams()).subscribe(res => {
      this.myClaims = res;
      this.pendingClaims = res.filter(function(el){
        if(el.claimStatus === "NEW"){
          return el;
        }
      });

      this.completedClaims = res.filter(function(el){
        if(el.claimStatus !== "NEW" && el.claimStatus !== "INPROGRESS" ){
          return el;
        }
      });

    });
  }

}
