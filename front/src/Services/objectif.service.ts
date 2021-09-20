import { Objectif } from './../models/objectif';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { Entretien } from 'src/models/entretien';


@Injectable({
  providedIn: 'root'
})
export class ObjectifService {

  constructor(private http: HttpClient,
  ) {}

  baseUrl = "http://localhost:8081/";
 
  //getDataFromUrl
  getObjectifsList(): Observable<any> {
    let uri ="objectif"
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  saveObjectif(objectif:object): Observable<any> {
    let uri ="objectif"
    return  this.http.put<any[]>(this.baseUrl+uri,objectif);
  }

  getCollaborateurObjectifsForManager(id : number): Observable<any> {
    let uri="objectifsForManager/" + id;
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  evaluate(objectif:Objectif): Observable<any> {
    let uri="evaluateObjectif";
    return  this.http.put<any[]>(this.baseUrl+uri,objectif);
  }

  saveNewObjectif(objectif:Objectif,id:number): Observable<any> {
    let uri="newObjectif/"+id;
    return  this.http.put<any[]>(this.baseUrl+uri,objectif);
  }

  getEvaluatedObjectifByCollab(id : number) : Observable<any> {
    let uri="objectifevaluatedbycollab/" + id;
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  getEvaluatedObjectifByManager() : Observable<any> {
    let uri="objectifevaluatedbymanager/";
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  getNewObjectifs() : Observable<any> {
    let uri="newobjectifs";
    return this.http.get<any[]>(this.baseUrl+uri);
  }
  getCollaborateurNewObjectifsForManager(id : number): Observable<any> {
    let uri="newobjectifsForManager/" + id;
    return this.http.get<any[]>(this.baseUrl+uri);
  }
}
