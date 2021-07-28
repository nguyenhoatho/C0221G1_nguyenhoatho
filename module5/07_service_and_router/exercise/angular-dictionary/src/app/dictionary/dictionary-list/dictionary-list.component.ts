import { Component, OnInit } from '@angular/core';
import {IWord} from '../../model/iword';
import {DictionaryService} from '../../service/dictionary.service';

@Component({
  selector: 'app-dictionary-list',
  templateUrl: './dictionary-list.component.html',
  styleUrls: ['./dictionary-list.component.scss']
})
export class DictionaryListComponent implements OnInit {
  listword: IWord[] = [];
  constructor(private dictionaryService: DictionaryService ) { }

  ngOnInit(): void {
    this.listword = this.dictionaryService.list;
  }

}
