
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Entretien } from 'src/models/entretien';
import { User } from 'src/models/user';

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

  getEntretienByCollaborateur(collaborateur:User): Observable<any> {
    let uri = "findEntretienByCollaborateur/"+collaborateur.id;
    return this.http.get<any[]>(this.baseUrl+uri);
  }


  getEntretienList(): Observable<any> {
    let uri = "eips";
    return this.http.get<any[]>(this.baseUrl+uri);
  }
}
