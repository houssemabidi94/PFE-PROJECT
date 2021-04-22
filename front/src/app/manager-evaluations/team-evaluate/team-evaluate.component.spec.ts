import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamEvaluateComponent } from './team-evaluate.component';

describe('TeamEvaluateComponent', () => {
  let component: TeamEvaluateComponent;
  let fixture: ComponentFixture<TeamEvaluateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamEvaluateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamEvaluateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
