import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcmCompanyGroupComponent } from './rcm-company-group.component';

describe('RcmCompanyGroupComponent', () => {
  let component: RcmCompanyGroupComponent;
  let fixture: ComponentFixture<RcmCompanyGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcmCompanyGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcmCompanyGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
