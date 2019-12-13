import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcmDashboardComponent } from './rcm-dashboard.component';

describe('RcmDashboardComponent', () => {
  let component: RcmDashboardComponent;
  let fixture: ComponentFixture<RcmDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcmDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcmDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
