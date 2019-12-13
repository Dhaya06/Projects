import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorDateTimeComponent } from './editor-date-time.component';

describe('EditorDateTimeComponent', () => {
  let component: EditorDateTimeComponent;
  let fixture: ComponentFixture<EditorDateTimeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditorDateTimeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorDateTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
