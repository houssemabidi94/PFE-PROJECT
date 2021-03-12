import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

export class User{
  constructor(
    public status:string,
     ) {}
  
}

export class JwtResponse{
  constructor(
    public jwttoken:string,
     ) {}
  
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private httpClient:HttpClient
  ) { 
     }

     authenticate(email, password) {
      return this.httpClient.post<any>('http://localhost:8081/login',{email,password}).pipe(
       map(
         userData => {
          localStorage.setItem('email',email);
          let tokenStr= 'Bearer '+userData.token;
          localStorage.setItem('token', tokenStr);
          return userData;
         }
       )
  
      );
    }
  

  isUserLoggedIn() {
    let user = localStorage.getItem('email')
    //console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    localStorage.removeItem('email')
    localStorage.removeItem('token')
  }
}