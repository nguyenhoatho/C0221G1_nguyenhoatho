import { Component, OnInit } from '@angular/core';
import {LoadCssService} from '../bootstrap/load-css.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor(private template: LoadCssService) {
    template.loadCss('https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css');
  }

  ngOnInit(): void {
  }

}
