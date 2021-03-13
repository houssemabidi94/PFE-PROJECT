import { Objectif } from './../models/objectif';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'app/models/user';


@Injectable({
  providedIn: 'root'
})
export class ObjectifService {

  constructor(private http: HttpClient,
  ) {}

  baseUrl = "http://localhost:8081/objectif";
  temp =    "http://localhost:8081/autoEvaluateObjectif";
 
  //getDataFromUrl
  getObjectifsList(): Observable<any> {
    return this.http.get<any[]>(this.baseUrl);
  }

  saveObjectif(objectif:object): Observable<any> {
    return  this.http.put<any[]>(this.baseUrl,objectif);
  }
}
