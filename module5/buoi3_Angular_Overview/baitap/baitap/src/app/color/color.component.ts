import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  public title: 'Color Picker';
  public colorCode = '#387c73';
  public fontSize = 10;
  constructor() { }

  ngOnInit(): void {
  }
  // @ts-ignore
  public getColor(red: string, green: string, blue: string): string {
    // tslint:disable-next-line:radix
    const redNumber: number = parseInt(red);
    // tslint:disable-next-line:radix
    const greenNumber: number = parseInt(green);
    // tslint:disable-next-line:radix
    const blueNumber: number = parseInt(blue);

    let redStr: string = redNumber.toString(16);
    let greenStr: string = greenNumber.toString(16);
    let blueStr: string = blueNumber.toString(16);

    if (redNumber < 16) {   redStr = '0' + redStr; }
    if (greenNumber < 16) { greenStr = '0' + greenStr; }
    if (blueNumber < 16) {  blueStr = '0' + blueStr; }

    this.colorCode = '#' + redStr + greenStr + blueStr;
  }

  changeFont(value: any) {
    this.fontSize = value;
  }
}
