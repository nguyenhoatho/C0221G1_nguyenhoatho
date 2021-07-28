import { Injectable } from '@angular/core';
import {Customer} from '../model/Customer';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private baseUrl = 'http://localhost:8080/';
  customer: Customer[] = [
    {id: 1, customerName: 'nguyen hoa tho', customerBirthday: '1999-03-14' , customerGender : '0' , customerAddress: 'quang nam' ,
    customerEmail: 'nguyenhoatho.qn@gmail.com' , customerIdCard: '12456028' , customerPhone: '0966097148'},
    {id: 2, customerName: 'nguyen hoa thinh', customerBirthday: '1999-03-14' , customerGender : '0' , customerAddress: 'quang nam' ,
      customerEmail: 'nguyenhoatho.qn@gmail.com' , customerIdCard: '12456028' , customerPhone: '0966097148'},
    {id: 3, customerName: 'nguye van b', customerBirthday: '1999-03-14' , customerGender : '0' , customerAddress: 'quang nam' ,
      customerEmail: 'nguyenhoatho.qn@gmail.com' , customerIdCard: '12456028' , customerPhone: '0966097148'},
    {id: 4, customerName: 'nguyen thanh long c', customerBirthday: '1999-03-14' , customerGender : '0' , customerAddress: 'quang nam' ,
      customerEmail: 'nguyenhoatho.qn@gmail.com' , customerIdCard: '12456028' , customerPhone: '0966097148'},
    {id: 5, customerName: 'nguyen hoa van a', customerBirthday: '1999-03-14' , customerGender : '0' , customerAddress: 'quang nam' ,
      customerEmail: 'nguyenhoatho.qn@gmail.com' , customerIdCard: '12456028' , customerPhone: '0966097148'},
    {id: 6, customerName: 'nguyen van ti', customerBirthday: '1999-03-14' , customerGender : '0' , customerAddress: 'quang nam' ,
      customerEmail: 'nguyenhoatho.qn@gmail.com' , customerIdCard: '12456028' , customerPhone: '0966097148'},
    {id: 7, customerName: 'nguyen dinh long', customerBirthday: '1999-03-14' , customerGender : '0' , customerAddress: 'quang nam' ,
      customerEmail: 'nguyenhoatho.qn@gmail.com' , customerIdCard: '12456028' , customerPhone: '0966097148'},
    {id: 8, customerName: 'nguyen van c', customerBirthday: '1999-03-14' , customerGender : '0' , customerAddress: 'quang nam' ,
      customerEmail: 'nguyenhoatho.qn@gmail.com' , customerIdCard: '12456028' , customerPhone: '0966097148'}
  ];

  // tslint:disable-next-line:variable-name
  constructor(private _http: HttpClient) {}
  getPage(page: number) {
    return this._http.get(this.baseUrl);
  }
  onGet()  {
    return this.customer;
  }
}
