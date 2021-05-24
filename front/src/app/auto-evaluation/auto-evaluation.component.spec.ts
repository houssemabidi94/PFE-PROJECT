import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { AutoEvaluationComponent } from './auto-evaluation.component';

describe('AutoEvaluationComponent', () => {
  let component: AutoEvaluationComponent;
  let fixture: ComponentFixture<AutoEvaluationComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoEvaluationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoEvaluationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
