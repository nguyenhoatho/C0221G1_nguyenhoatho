import { Component, OnInit } from '@angular/core';
import {LoadCssService} from '../../bootstrap/load-css.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  constructor(private template: LoadCssService) {
    template.loadCss('https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css');
  }

  ngOnInit(): void {
  }

}
