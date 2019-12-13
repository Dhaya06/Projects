import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CellRenderer2Component } from './cell-renderer-2.component';

describe('CellRenderer2Component', () => {
  let component: CellRenderer2Component;
  let fixture: ComponentFixture<CellRenderer2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CellRenderer2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CellRenderer2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
