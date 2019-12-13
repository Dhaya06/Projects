import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagnosisRemarkModalComponent } from './diagnosis-remark-modal.component';

describe('DiagnosisRemarkModalComponent', () => {
  let component: DiagnosisRemarkModalComponent;
  let fixture: ComponentFixture<DiagnosisRemarkModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiagnosisRemarkModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiagnosisRemarkModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
