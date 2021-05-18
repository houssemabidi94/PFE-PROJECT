import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EvaluationService {

  constructor(private http: HttpClient) { }

  baseUrl = "http://localhost:8081/";


  newEvaluation(idUser:number,idCompetence:number,idNiveau:number): Observable<any> {
    let uri="newEvaluation/"+idUser+"/"+idCompetence+"/"+idNiveau;
    return this.http.post<any[]>(this.baseUrl+uri,null);
  }
}
