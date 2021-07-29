import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [] ;
  message: string;
  // @ts-ignore
  category: Category[] = [] ;
  constructor(private productService: ProductService, private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.getAll();
    this.getCategory();
  }

  getAll() {
    this.productService.getAll().subscribe(products => {
      this.products = products;
      // console.log(products[0].category);
    });
  }
  getCategory() {
    this.categoryService.getAll().subscribe(category => {
      this.category = category ;
    });
  }
}
