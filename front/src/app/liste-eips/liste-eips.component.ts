import { Component, OnInit, VERSION } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EntretienService } from 'src/Services/entretien.service';
import { Entretien } from 'src/models/entretien';
import { User } from 'src/Services/authentication.service';

@Component({
  selector: 'app-liste-eips',
  templateUrl: './liste-eips.component.html',
  styleUrls: ['./liste-eips.component.scss']
})
export class ListeEipsComponent implements OnInit {
  
  user : User;
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup
  entretient : Entretien [];
  collaborateur = false;

  constructor(private _formBuilder: FormBuilder,
              private es : EntretienService,

            ) {}

  ngOnInit() {
    this.getListEips();
  }

  getListEips(){
this.es.getEntretienList().subscribe(data =>
  this.entretient = data
)
  }

  getCollaborateur(entretien) {
    this.es.getCollaborateurByEntretien(entretien).subscribe(data => {
      this.user = data
	});
}
}
