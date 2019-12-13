import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CsiAgGridComponent } from './csi-ag-grid.component';

describe('CsiAgGridComponent', () => {
  let component: CsiAgGridComponent;
  let fixture: ComponentFixture<CsiAgGridComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CsiAgGridComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CsiAgGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
