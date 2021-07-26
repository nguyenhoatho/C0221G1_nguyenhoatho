import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerComponent} from './customer/customer.component';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {ViewCustomerComponent} from './customer/view-customer/view-customer.component';
import {HomeComponent} from './home/home.component';


const routes: Routes = [
  {path : '' , component : HomeComponent},
  {path : '' , redirectTo : '/customer' , pathMatch : 'full'},
  {path : 'customer' , component : ListCustomerComponent },
  {path : 'view' , component : ViewCustomerComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
