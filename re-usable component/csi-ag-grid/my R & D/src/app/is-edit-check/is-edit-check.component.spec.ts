import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IsEditCheckComponent } from './is-edit-check.component';

describe('IsEditCheckComponent', () => {
  let component: IsEditCheckComponent;
  let fixture: ComponentFixture<IsEditCheckComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IsEditCheckComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IsEditCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
