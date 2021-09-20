import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { NavLogoComponent } from './nav-logo.component';

describe('NavLogoComponent', () => {
  let component: NavLogoComponent;
  let fixture: ComponentFixture<NavLogoComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ NavLogoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavLogoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
