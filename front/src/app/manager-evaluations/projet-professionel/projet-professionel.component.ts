import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormArray } from '@angular/forms';
import { Objectif } from 'src/models/objectif';
import { User } from 'src/models/user';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { ObjectifService } from 'src/Services/objectif.service';
import { Entretien } from 'src/models/entretien';
import { EntretienService } from 'src/Services/entretien.service';

@Component({
  selector: 'app-projet-professionel',
  templateUrl: './projet-professionel.component.html',
  styleUrls: ['./projet-professionel.component.scss']
})
export class ProjetProfessionelComponent implements OnInit {

  public invoiceForm: FormGroup;

  entr : Entretien = new Entretien();
  user : User;
  success = false;

  constructor(private _fb: FormBuilder,
  private readonly sharedServicesService : SharedServicesService,
private objectifService : ObjectifService,
private entService : EntretienService) { }

  ngOnInit() {

    this.sharedServicesService.getValue().subscribe(value=>{
      this.user = value;
      this.entService.getEntretienByCollaborateur(this.user.id).subscribe(data=>{
        this.entr = data;
      });
    });

  }
  onSubmit(){
this.entService.addNewProjet(this.entr,this.user.id).subscribe();
    this.success = true;
  }

}
