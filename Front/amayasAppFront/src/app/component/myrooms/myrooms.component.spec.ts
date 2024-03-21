import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyroomsComponent } from './myrooms.component';

describe('MyroomsComponent', () => {
  let component: MyroomsComponent;
  let fixture: ComponentFixture<MyroomsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MyroomsComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(MyroomsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
