import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoadCssService {

  constructor() { }

  loadCss(src) {
    const css = document.createElement('link');
    css.rel = 'stylesheet';
    document.getElementsByTagName('head')[0].appendChild(css);
    css.href = src;
  }

  loadScript(src) {
    const script = document.createElement('script');
    script.type = 'text/javascript';
    document.getElementsByTagName('body')[0].appendChild(script);
    script.src = src;
  }
}
