import { Component, OnInit } from '@angular/core';
import {IWord} from '../../model/iword';
import {DictionaryService} from '../../service/dictionary.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-details-word',
  templateUrl: './details-word.component.html',
  styleUrls: ['./details-word.component.scss']
})
export class DetailsWordComponent implements OnInit {
  detailsWord: IWord;
  constructor(private dictionaryService: DictionaryService,
              private activatedRoute: ActivatedRoute,
              private route: Router) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params.id;
    // tslint:disable-next-line:radix
    this.detailsWord = this.dictionaryService.getDetailsWord(parseInt(id));
  }
  backToList() {
    this.route.navigateByUrl('dictionary');
  }
}
