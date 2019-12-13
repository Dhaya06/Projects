import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CsiColomnComponent } from './csi-colomn.component';

describe('CsiColomnComponent', () => {
  let component: CsiColomnComponent;
  let fixture: ComponentFixture<CsiColomnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CsiColomnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CsiColomnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
