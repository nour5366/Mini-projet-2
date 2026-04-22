import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSerieComponent } from './update-serie';

describe('UpdateSerieComponent', () => {
  let component: UpdateSerieComponent;
  let fixture: ComponentFixture<UpdateSerieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateSerieComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateSerieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
