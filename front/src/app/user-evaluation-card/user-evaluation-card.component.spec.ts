import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserEvaluationCardComponent } from './user-evaluation-card.component';

describe('UserEvaluationCardComponent', () => {
  let component: UserEvaluationCardComponent;
  let fixture: ComponentFixture<UserEvaluationCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserEvaluationCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserEvaluationCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
