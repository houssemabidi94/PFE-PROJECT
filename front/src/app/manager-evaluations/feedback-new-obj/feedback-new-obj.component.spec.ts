import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackNewObjComponent } from './feedback-new-obj.component';

describe('FeedbackNewObjComponent', () => {
  let component: FeedbackNewObjComponent;
  let fixture: ComponentFixture<FeedbackNewObjComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedbackNewObjComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackNewObjComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
