import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CsiPageLayoutComponent } from './csi-page-layout.component';

describe('CsiPageLayoutComponent', () => {
  let component: CsiPageLayoutComponent;
  let fixture: ComponentFixture<CsiPageLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CsiPageLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CsiPageLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
