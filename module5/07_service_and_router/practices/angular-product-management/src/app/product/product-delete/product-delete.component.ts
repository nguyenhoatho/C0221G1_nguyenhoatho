import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.scss']
})
export class ProductDeleteComponent implements OnInit {

  product: Product;

  constructor(
    private productService: ProductService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params.id;
    // tslint:disable-next-line:radix
    this.product = this.productService.getProductById(parseInt(id));
  }

  deleteProduct() {
    this.productService.deleteProduct(this.product.id);
    this.backToList();
  }

  backToList() {
    this.router.navigateByUrl('product/list');
  }

}
