import { TestBed, inject } from '@angular/core/testing';

import { SearchClaimService } from './search-claim.service';

describe('SearchClaimService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SearchClaimService]
    });
  });

  it('should be created', inject([SearchClaimService], (service: SearchClaimService) => {
    expect(service).toBeTruthy();
  }));
});
