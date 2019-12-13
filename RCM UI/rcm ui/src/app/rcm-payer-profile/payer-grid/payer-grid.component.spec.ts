import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PayerGridComponent } from './payer-grid.component';

describe('PayerGridComponent', () => {
  let component: PayerGridComponent;
  let fixture: ComponentFixture<PayerGridComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PayerGridComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PayerGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
