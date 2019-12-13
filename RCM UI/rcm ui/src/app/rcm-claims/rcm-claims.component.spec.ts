import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcmClaimsComponent } from './rcm-claims.component';

describe('RcmClaimsComponent', () => {
  let component: RcmClaimsComponent;
  let fixture: ComponentFixture<RcmClaimsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcmClaimsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcmClaimsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
