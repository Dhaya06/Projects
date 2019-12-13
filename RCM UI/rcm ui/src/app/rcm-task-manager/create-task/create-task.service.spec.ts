import { TestBed, inject } from '@angular/core/testing';

import { CreateTaskService } from './create-task.service';

describe('CreateTaskService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CreateTaskService]
    });
  });

  it('should be created', inject([CreateTaskService], (service: CreateTaskService) => {
    expect(service).toBeTruthy();
  }));
});
