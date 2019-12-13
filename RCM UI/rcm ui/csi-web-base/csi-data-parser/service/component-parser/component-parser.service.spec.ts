import { TestBed, inject } from '@angular/core/testing';

import { ComponentParserService } from './component-parser.service';

describe('ComponentParserService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ComponentParserService]
    });
  });

  it('should be created', inject([ComponentParserService], (service: ComponentParserService) => {
    expect(service).toBeTruthy();
  }));
});
