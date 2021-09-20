import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { AddNewObjectiveComponent } from './add-new-objective.component';

describe('AddNewObjectiveComponent', () => {
  let component: AddNewObjectiveComponent;
  let fixture: ComponentFixture<AddNewObjectiveComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNewObjectiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewObjectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
