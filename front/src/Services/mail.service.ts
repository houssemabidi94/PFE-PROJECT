import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MailService {
  
  baseUrl = "http://localhost:8081/";

  constructor(private http: HttpClient) { }

  sentMailToManager(): Observable<any>{
    let uri = "mailtomanager";
    return this.http.get<any[]>(this.baseUrl+uri);
  }
  sentMailToCollab(userId : number): Observable<any>{
    let uri = "mailtocollab/"+userId;
    return this.http.get<any[]>(this.baseUrl+uri);
  }

}
