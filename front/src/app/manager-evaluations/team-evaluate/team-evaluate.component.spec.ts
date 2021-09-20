import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { TeamEvaluateComponent } from './team-evaluate.component';

describe('TeamEvaluateComponent', () => {
  let component: TeamEvaluateComponent;
  let fixture: ComponentFixture<TeamEvaluateComponent>;

  beforeEach(waitForAsync(() => {
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
