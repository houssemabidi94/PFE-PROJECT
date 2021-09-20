import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entretien } from 'src/models/entretien';

@Injectable({
  providedIn: 'root'
})
export class ClotureService {

  constructor(private http: HttpClient) {}

  baseUrl = "http://localhost:8081/";

  cloturer(ent : Entretien,userId : number){
    let uri="cloturer/"+userId;
      return  this.http.put<any[]>(this.baseUrl+uri,ent);
  }
}
