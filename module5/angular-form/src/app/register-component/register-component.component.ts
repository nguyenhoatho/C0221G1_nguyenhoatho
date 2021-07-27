import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { comparePassword } from './gte.validator';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterFormComponent implements OnInit {
  title = 'Register Form' ;
  // @ts-ignore
  // @ts-ignore
  countryList = ['Viet Nam', 'Nuoc Ngoai'];
  contractForm: FormGroup;
  constructor() {

    this.contractForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      pw: new FormGroup({
        password: new FormControl('', [Validators.minLength(6)]),
        confirmpassword: new FormControl('', [Validators.minLength(6)])
      }, [comparePassword]),
      country : new FormControl('Viet Nam'),
      age: new FormControl('', [Validators.min(18)]),
      gender: new FormControl('' , [Validators.required]),
      phone: new FormControl('', [Validators.pattern(/^\+84\d{9,10}$/)]),
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.contractForm.value);
  }
}
