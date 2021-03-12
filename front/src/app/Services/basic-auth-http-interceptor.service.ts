import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class BasicAuthHttpInterceptorService implements HttpInterceptor {

  constructor() {
   }
  

  intercept(req: HttpRequest<any>, next: HttpHandler) {

    if (localStorage.getItem('email') && localStorage.getItem('token')) {
      const headerss = {
        'Content-type' : 'application/json',
        'Accept': 'application/json',
        'Authorization' : localStorage.getItem('token')
      }
      req = req.clone({
        setHeaders: headerss
      })
    }
    return next.handle(req);
  }
}
