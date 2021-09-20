import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RapportEvalManagerComponent } from './rapport-eval-manager.component';

describe('RapportEvalManagerComponent', () => {
  let component: RapportEvalManagerComponent;
  let fixture: ComponentFixture<RapportEvalManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RapportEvalManagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RapportEvalManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
