import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pruebamaterial } from './pruebamaterial';

describe('Pruebamaterial', () => {
  let component: Pruebamaterial;
  let fixture: ComponentFixture<Pruebamaterial>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Pruebamaterial]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Pruebamaterial);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
