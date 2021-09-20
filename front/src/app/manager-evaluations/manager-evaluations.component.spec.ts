import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ManagerEvaluationsComponent } from './manager-evaluations.component';

describe('ManagerEvaluationsComponent', () => {
  let component: ManagerEvaluationsComponent;
  let fixture: ComponentFixture<ManagerEvaluationsComponent>;

  beforeEach(waitForAsync(() => {
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
