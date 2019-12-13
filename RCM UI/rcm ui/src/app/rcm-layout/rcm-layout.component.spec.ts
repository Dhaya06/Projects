import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcmLayoutComponent } from './rcm-layout.component';

describe('RcmLayoutComponent', () => {
  let component: RcmLayoutComponent;
  let fixture: ComponentFixture<RcmLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcmLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcmLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
