import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimSubmissionFooterComponent } from './claim-submission-footer.component';

describe('ClaimSubmissionFooterComponent', () => {
  let component: ClaimSubmissionFooterComponent;
  let fixture: ComponentFixture<ClaimSubmissionFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimSubmissionFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimSubmissionFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
