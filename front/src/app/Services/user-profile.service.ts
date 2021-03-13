import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  constructor(private http: HttpClient) { }

  baseUrl = "http://localhost:8081/profile";

    //getDataFromUrl
    getUserProfile(): Observable<any> {
      return this.http.get<any[]>(this.baseUrl);
    }
}
