import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoevaluationComponent } from './autoevaluation.component';

describe('AutoevaluationComponent', () => {
  let component: AutoevaluationComponent;
  let fixture: ComponentFixture<AutoevaluationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AutoevaluationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoevaluationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
