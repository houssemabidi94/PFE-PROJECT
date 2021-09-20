import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from 'src/models/user';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { ClotureService } from 'src/Services/cloture.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Objectif } from 'src/models/objectif';
import { ObjectifService } from 'src/Services/objectif.service';
import { Entretien } from 'src/models/entretien';
import { MailService } from 'src/Services/mail.service';

@Component({
  selector: 'app-cloture',
  templateUrl: './cloture.component.html',
  styleUrls: ['./cloture.component.scss']
})
export class ClotureComponent implements OnInit {
  success = false;
  user : User;
  entr : Entretien = new Entretien();

  public invoiceForm: FormGroup;
  objectifList: Array<Objectif> = [];
  
  constructor(private _fb: FormBuilder,
    private readonly sharedServicesService : SharedServicesService,
    private clotureService : ClotureService,
    private mail : MailService,
    private router: Router
  ) { 
    this.sharedServicesService.getValue().subscribe(value=>{
      this.user = value;
    });
  }

  ngOnInit(): void {
  }

      onSubmit(){
        
        this.clotureService.cloturer(this.entr,this.user.id).subscribe();
        this.mail.sentMailToCollab(this.user.id).subscribe();
        this.router.navigate(["/evaluation"]);
      }
}
