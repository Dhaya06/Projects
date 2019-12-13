import { TestBed, inject } from '@angular/core/testing';

import { DateConvertService } from './date-convert.service';

describe('DateConvertService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DateConvertService]
    });
  });

  it('should be created', inject([DateConvertService], (service: DateConvertService) => {
    expect(service).toBeTruthy();
  }));
});
