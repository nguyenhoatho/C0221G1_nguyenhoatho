import { Component, OnInit } from '@angular/core';
import {Pet} from './Pet';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})

// @ts-ignore
export class PetComponent implements OnInit , Pet {
  pet: Pet = {
    name: 'puppie',
    image: 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg'
  };

  constructor() { }

  ngOnInit(): void {
  }

}
