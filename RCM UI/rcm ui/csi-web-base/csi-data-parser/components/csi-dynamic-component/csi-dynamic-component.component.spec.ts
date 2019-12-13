import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CsiDynamicComponentComponent } from './csi-dynamic-component.component';

describe('CsiDynamicComponentComponent', () => {
  let component: CsiDynamicComponentComponent;
  let fixture: ComponentFixture<CsiDynamicComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CsiDynamicComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CsiDynamicComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
