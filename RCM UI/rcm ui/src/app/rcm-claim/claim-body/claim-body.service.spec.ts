import { TestBed, inject } from '@angular/core/testing';

import { ClaimBodyService } from './claim-body.service';

describe('ClaimBodyService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClaimBodyService]
    });
  });

  it('should be created', inject([ClaimBodyService], (service: ClaimBodyService) => {
    expect(service).toBeTruthy();
  }));
});
