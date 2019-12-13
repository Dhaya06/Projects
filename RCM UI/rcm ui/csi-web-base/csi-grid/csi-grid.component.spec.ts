import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CsiGridComponent } from './csi-grid.component';

describe('CsiGridComponent', () => {
  let component: CsiGridComponent;
  let fixture: ComponentFixture<CsiGridComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CsiGridComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CsiGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
