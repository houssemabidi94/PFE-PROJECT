import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CollabEvaluationComponent } from './collab-evaluation.component';

describe('CollabEvaluationComponent', () => {
  let component: CollabEvaluationComponent;
  let fixture: ComponentFixture<CollabEvaluationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CollabEvaluationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CollabEvaluationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
