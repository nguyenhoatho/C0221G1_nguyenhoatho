import { Injectable } from '@angular/core';
import {IWord} from '../model/iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  list: IWord[] = [
    {id: 1, word: 'Hello', means: 'Xin Chào'},
    {id: 2, word: 'Bye Bye', means: 'Tạm Biệt'},
    {id: 3, word: 'Blue', means: 'Xanh Dương'},
    {id: 4, word: 'Sky', means: 'Bầu Trời'},
    {id: 5, word: 'Cat', means: 'Mèo'},
    ];
  constructor() { }
  getDetailsWord(id: number) {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.list.length; i++) {
      if (this.list[i].id === id) {
        return this.list[i];
      }
    }
    return null;
  }
}
