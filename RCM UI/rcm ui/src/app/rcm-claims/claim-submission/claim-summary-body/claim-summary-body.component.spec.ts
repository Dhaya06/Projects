import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimSummaryBodyComponent } from './claim-summary-body.component';

describe('ClaimSummaryBodyComponent', () => {
  let component: ClaimSummaryBodyComponent;
  let fixture: ComponentFixture<ClaimSummaryBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimSummaryBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimSummaryBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
