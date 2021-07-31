import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-img-slide',
  templateUrl: './img-slide.component.html',
  styleUrls: ['./img-slide.component.scss']
})
export class ImgSlideComponent implements OnInit {
  @Input() src = '';
  constructor() { }

  ngOnInit(): void {
  }

}
