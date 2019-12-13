import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimSlidePanelComponent } from './claim-slide-panel.component';

describe('ClaimSlidePanelComponent', () => {
  let component: ClaimSlidePanelComponent;
  let fixture: ComponentFixture<ClaimSlidePanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimSlidePanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimSlidePanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
