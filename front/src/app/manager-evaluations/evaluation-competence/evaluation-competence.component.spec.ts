import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { EvaluationCompetenceComponent } from './evaluation-competence.component';

describe('EvaluationCompetenceComponent', () => {
  let component: EvaluationCompetenceComponent;
  let fixture: ComponentFixture<EvaluationCompetenceComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ EvaluationCompetenceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EvaluationCompetenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
