import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeEipsComponent } from './liste-eips.component';

describe('ListeEipsComponent', () => {
  let component: ListeEipsComponent;
  let fixture: ComponentFixture<ListeEipsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeEipsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeEipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
