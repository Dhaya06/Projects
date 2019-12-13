import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcmPayerProfileComponent } from './rcm-payer-profile.component';

describe('RcmPayerProfileComponent', () => {
  let component: RcmPayerProfileComponent;
  let fixture: ComponentFixture<RcmPayerProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcmPayerProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcmPayerProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
