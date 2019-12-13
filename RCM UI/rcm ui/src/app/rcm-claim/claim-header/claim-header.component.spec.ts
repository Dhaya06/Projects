import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimHeaderComponent } from './claim-header.component';

describe('ClaimHeaderComponent', () => {
  let component: ClaimHeaderComponent;
  let fixture: ComponentFixture<ClaimHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
