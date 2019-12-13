import { TestBed, inject } from '@angular/core/testing';

import { CsiFormBuilderService } from './csi-form-builder.service';

describe('CsiFormBuilderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CsiFormBuilderService]
    });
  });

  it('should be created', inject([CsiFormBuilderService], (service: CsiFormBuilderService) => {
    expect(service).toBeTruthy();
  }));
});
