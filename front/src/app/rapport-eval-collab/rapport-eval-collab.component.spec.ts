import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RapportEvalCollabComponent } from './rapport-eval-collab.component';

describe('RapportEvalCollabComponent', () => {
  let component: RapportEvalCollabComponent;
  let fixture: ComponentFixture<RapportEvalCollabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RapportEvalCollabComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RapportEvalCollabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
