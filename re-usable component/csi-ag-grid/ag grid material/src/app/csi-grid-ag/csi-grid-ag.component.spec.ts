import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CsiGridAgComponent } from './csi-grid-ag.component';

describe('CsiGridAgComponent', () => {
  let component: CsiGridAgComponent;
  let fixture: ComponentFixture<CsiGridAgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CsiGridAgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CsiGridAgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
