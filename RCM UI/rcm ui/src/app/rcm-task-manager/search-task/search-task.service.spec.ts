import { TestBed, inject } from '@angular/core/testing';

import { SearchTaskService } from './search-task.service';

describe('SearchTaskService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SearchTaskService]
    });
  });

  it('should be created', inject([SearchTaskService], (service: SearchTaskService) => {
    expect(service).toBeTruthy();
  }));
});
