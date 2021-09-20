import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjetProfessionelComponent } from './projet-professionel.component';

describe('ProjetProfessionelComponent', () => {
  let component: ProjetProfessionelComponent;
  let fixture: ComponentFixture<ProjetProfessionelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjetProfessionelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjetProfessionelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
