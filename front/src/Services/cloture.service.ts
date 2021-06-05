import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClotureService {

  constructor(private http: HttpClient) {}

  baseUrl = "http://localhost:8081/";

  cloturer(userId : number){
    let uri="cloturer/"+userId;
    return  this.http.post<any[]>(this.baseUrl+uri,null);
  }
}
