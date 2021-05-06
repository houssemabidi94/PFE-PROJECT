import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EipEquipeComponent } from './eip-equipe.component';

describe('EipEquipeComponent', () => {
  let component: EipEquipeComponent;
  let fixture: ComponentFixture<EipEquipeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EipEquipeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EipEquipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
