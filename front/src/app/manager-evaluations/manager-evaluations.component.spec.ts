import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerEvaluationsComponent } from './manager-evaluations.component';

describe('ManagerEvaluationsComponent', () => {
  let component: ManagerEvaluationsComponent;
  let fixture: ComponentFixture<ManagerEvaluationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerEvaluationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerEvaluationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
