import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.scss']
})
export class ProductEditComponent implements OnInit {
  product: Product;
  message: string;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,
              private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params.id;
    // tslint:disable-next-line:radix
    this.product = this.productService.getProductById(parseInt(id));

    this.editForm = this.formBuilder.group({
      id: new FormControl(this.product.id),
      name: new FormControl(this.product.name),
      price: new FormControl(this.product.price),
      description: new FormControl(this.product.description)
    });
  }

  submit(editForm: FormGroup) {
    const product = editForm.value ;
    alert(product.id)
    this.productService.editProduct(product);
    this.message = 'Success full' ;
    this.backtolist();
  }


  backtolist() {
    this.router.navigateByUrl('product/list');
  }
}
