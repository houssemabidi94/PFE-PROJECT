import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  constructor(private http: HttpClient) { }

  baseUrl = "http://localhost:8081/";

    //getDataFromUrl
    getUserProfile(): Observable<any> {
    let  uri = "profile";
      return this.http.get<any[]>(this.baseUrl+uri);
    }

    getUser(id : number) : Observable<any> {
let uri = "profile/"+id;
return this.http.get<any[]>(this.baseUrl+uri);
    }

    getManager() : Observable<any> {
      let uri = "getmanager";
      return this.http.get<any[]>(this.baseUrl+uri);
          }
}
