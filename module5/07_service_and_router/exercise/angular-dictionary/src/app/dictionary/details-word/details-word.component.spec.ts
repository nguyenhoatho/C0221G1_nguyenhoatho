import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsWordComponent } from './details-word.component';

describe('DetailsWordComponent', () => {
  let component: DetailsWordComponent;
  let fixture: ComponentFixture<DetailsWordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsWordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsWordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
