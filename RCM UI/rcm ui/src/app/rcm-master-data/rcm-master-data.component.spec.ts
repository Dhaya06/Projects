import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcmMasterDataComponent } from './rcm-master-data.component';

describe('RcmMasterDataComponent', () => {
  let component: RcmMasterDataComponent;
  let fixture: ComponentFixture<RcmMasterDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcmMasterDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcmMasterDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
