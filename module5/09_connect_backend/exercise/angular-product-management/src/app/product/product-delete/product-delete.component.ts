import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../service/category.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.scss']
})
export class ProductDeleteComponent implements OnInit {

  product: Product;
  productForm: FormGroup ;
  id: number;

  constructor(private productService: ProductService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });
  }

  ngOnInit(): void {
    // const id = this.activatedRoute.snapshot.params.id;
    // // tslint:disable-next-line:radix
    // this.product = this.productService.(parseInt(id));
  }

  // deleteProduct() {
  //   //   this.productService.deleteProduct(this.product.id);
  //   //   this.backToList();
  //   // }

  backToList() {
    this.router.navigateByUrl('product/list');
  }


  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.product = product;
      this.productForm = new FormGroup({
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description),
        category: new FormControl(product.category)
      });
    });
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.router.navigate(['/product/list']);
    }, e => {
      console.log(e);
    });
  }
}
