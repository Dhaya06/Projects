import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcmClaimComponent } from './rcm-claim.component';

describe('RcmClaimComponent', () => {
  let component: RcmClaimComponent;
  let fixture: ComponentFixture<RcmClaimComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcmClaimComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcmClaimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
