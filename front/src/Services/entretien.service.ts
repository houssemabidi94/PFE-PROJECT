
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Entretien } from 'src/models/entretien';
import { User } from 'src/models/user';
import { NullTemplateVisitor } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class EntretienService {

  baseUrl = "http://localhost:8081/";

  constructor(private http: HttpClient) { }



  getCollaborateurByEntretien(entretien:Entretien): Observable<any> {
    let uri = "findCollaborateurByEntretien/"+entretien.id;
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  getEntretienByCollaborateur(id : number): Observable<any> {
    let uri = "findEntretienByCollaborateur/"+id;
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  getEntretienByCollaborateurAndCompagne(id : number): Observable<any> {
    let uri = "findEntretienByCollaborateurAndCompagne/"+id;
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  getEntretienList(): Observable<any> {
    let uri = "eips";
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  addNewProjet(ent : Entretien,idUser : number): Observable<any> {
    let uri="addNewProjet/"+idUser;
    return  this.http.put<any[]>(this.baseUrl+uri,ent);
  }
  getUserEntretien() : Observable<any> {
    let uri = "entretien";
    return this.http.get<any[]>(this.baseUrl+uri);
  }
}
