import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl:'./calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  public title = 'Calculator';
  public result: any;

  constructor() {
  }

  ngOnInit(): void {
  }

  // @ts-ignore
  public calculate(first:string, second:string, operator:string):number{
    let firstNumber:number = parseInt(first);
    let secondNumber:number = parseInt(second);
    switch (operator) {
      case '+':
        return this.result = firstNumber + secondNumber;
      case '-':
        return this.result = firstNumber - secondNumber;
      case '*':
        return this.result = firstNumber * secondNumber;
      case '/':
        return this.result = firstNumber / secondNumber;
    }
  }


}
