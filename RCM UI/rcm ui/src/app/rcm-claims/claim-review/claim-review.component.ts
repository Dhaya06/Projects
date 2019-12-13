import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-claim-review',
  templateUrl: './claim-review.component.html',
  styleUrls: ['./claim-review.component.scss']
})
export class ClaimReviewComponent implements OnInit {

  public isClaimReview = true; 
  
  constructor() { }

  ngOnInit() {
  
  } 

}
