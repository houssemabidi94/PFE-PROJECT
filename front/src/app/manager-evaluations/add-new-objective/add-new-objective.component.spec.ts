import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewObjectiveComponent } from './add-new-objective.component';

describe('AddNewObjectiveComponent', () => {
  let component: AddNewObjectiveComponent;
  let fixture: ComponentFixture<AddNewObjectiveComponent>;

  beforeEach(async(() => {
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
