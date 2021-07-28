import { Component, OnInit } from '@angular/core';
import {LoadCssService} from '../../bootstrap/load-css.service';
import {CustomerServiceService} from '../../service/customer-service.service';
import {Customer} from '../../model/Customer';
import { NgxPaginationModule } from 'ngx-pagination';
@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customer: Customer[];
  data: Array<any>;
  totalRecord: number;
  page = 1;
  constructor(private template: LoadCssService ,  private customerService: CustomerServiceService) {
    template.loadCss('https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css');
    this.data = new Array<any>();
  }

  ngOnInit(): void {
    this.customer = this.customerService.onGet();
  }
}
