import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimBodyComponent } from './claim-body.component';

describe('ClaimBodyComponent', () => {
  let component: ClaimBodyComponent;
  let fixture: ComponentFixture<ClaimBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
