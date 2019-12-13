import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalClaimSummaryComponent } from './total-claim-summary.component';

describe('TotalClaimSummaryComponent', () => {
  let component: TotalClaimSummaryComponent;
  let fixture: ComponentFixture<TotalClaimSummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TotalClaimSummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TotalClaimSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
