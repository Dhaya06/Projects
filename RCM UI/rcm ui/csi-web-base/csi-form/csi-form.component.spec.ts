import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CsiFormComponent } from './csi-form.component';

describe('CsiFormComponent', () => {
  let component: CsiFormComponent;
  let fixture: ComponentFixture<CsiFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CsiFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CsiFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
