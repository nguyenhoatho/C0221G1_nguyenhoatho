import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  URL_PRD = 'http://localhost:3000';
  constructor(private http: HttpClient) { }
  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.URL_PRD + '/product');
  }
  saveProduct(product): Observable<Product> {
    return this.http.post<Product>(this.URL_PRD + '/product' , product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.URL_PRD}/product/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.URL_PRD}/product/${id}`, product);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(`${this.URL_PRD}/product/${id}`);
  }
}
