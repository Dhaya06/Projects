import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcmTaskManagerComponent } from './rcm-task-manager.component';

describe('RcmTaskManagerComponent', () => {
  let component: RcmTaskManagerComponent;
  let fixture: ComponentFixture<RcmTaskManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcmTaskManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcmTaskManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
