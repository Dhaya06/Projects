import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcmRulesComponent } from './rcm-rules.component';

describe('RcmRulesComponent', () => {
  let component: RcmRulesComponent;
  let fixture: ComponentFixture<RcmRulesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcmRulesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcmRulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
