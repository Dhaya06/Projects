import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailCellRenderAgentComponent } from './detail-cell-render-agent.component';

describe('DetailCellRenderAgentComponent', () => {
  let component: DetailCellRenderAgentComponent;
  let fixture: ComponentFixture<DetailCellRenderAgentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailCellRenderAgentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailCellRenderAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
