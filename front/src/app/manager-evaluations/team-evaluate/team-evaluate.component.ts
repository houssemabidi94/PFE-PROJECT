import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { Entretien } from 'src/models/entretien';
import { FormBuilder } from '@angular/forms';
import { EntretienService } from 'src/Services/entretien.service';
import { Objectif } from 'src/models/objectif';
import { ObjectifService } from 'src/Services/objectif.service';
import { SharedServicesService } from 'src/Services/shared-services.service';

@Component({
  selector: 'app-team-evaluate',
  templateUrl: './team-evaluate.component.html',
  styleUrls: ['./team-evaluate.component.scss']
})
export class TeamEvaluateComponent implements OnInit {

  user: User;
  entretient: Entretien[] = [];
  collaborateur = false;
  objectifs: Objectif[] = [];
  objectifList: Array<Objectif> = [];
  success = false;

  constructor(private _formBuilder: FormBuilder,
    private es: EntretienService,
    private objectifService: ObjectifService,
    private readonly sharedServicesService: SharedServicesService
  ) { }

  ngOnInit() {
    this.getListEips();
  }

  getListEips() {
    this.es.getEntretienList().subscribe(data =>
      this.entretient = data
    )
  }
  findCollabObjectif(id) {
    this.objectifService.getCollaborateurObjectifsForManager(id).subscribe(data => {
      this.objectifs = data
    });
  }
  getCollaborateur(entretien) {
    this.es.getCollaborateurByEntretien(entretien).subscribe(data => {
      this.user = data,
        this.findCollabObjectif(this.user.id)
    });   
  }

  change(objectif: Objectif) {
    let flag = false;
    if (this.objectifList.length == 0) {
      this.objectifList.push(objectif);
    }
    else {
      for (let i = 0; i < this.objectifList.length; i++) {
        if (this.objectifList[i] == objectif) {
          flag = true;
          this.objectifList[i].evaluation = objectif.autoEvaluation;
          this.objectifList[i].commentaire = objectif.commentaire;
        }
        if (flag == false) {
          this.objectifList.push(objectif);
        }
      }
    }
  }

  onSubmit() {                
        this.success = false;
        this.evaluate();
        this.sharedServicesService.setValue(this.user);
  }
  evaluate() {
 
    if (this.objectifList.length != 0) {
      for (let i = 0; i < this.objectifList.length; i++) {
        this.objectifService.evaluate(this.objectifList[i]).subscribe();
      }
        this.success = true;
    }

  }


}
