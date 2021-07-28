import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryListComponent} from './dictionary/dictionary-list/dictionary-list.component';
import {DetailsWordComponent} from './dictionary/details-word/details-word.component';


const routes: Routes = [
  {
    path: 'dictionary',
    component: DictionaryListComponent
  },
  {
    path: 'dictionary/detail/:id',
    component: DetailsWordComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
