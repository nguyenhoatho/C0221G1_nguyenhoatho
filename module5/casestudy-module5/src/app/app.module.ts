import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { ViewCustomerComponent } from './customer/view-customer/view-customer.component';
import { HomeComponent } from './home/home.component';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ListCustomerComponent,
    ViewCustomerComponent,
    HomeComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        NgxPaginationModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
