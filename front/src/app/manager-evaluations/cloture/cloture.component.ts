import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from 'src/models/user';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { ClotureService } from 'src/Services/cloture.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Objectif } from 'src/models/objectif';
import { ObjectifService } from 'src/Services/objectif.service';

@Component({
  selector: 'app-cloture',
  templateUrl: './cloture.component.html',
  styleUrls: ['./cloture.component.scss']
})
export class ClotureComponent implements OnInit {
  success = false;
  user : User;

  public invoiceForm: FormGroup;
  objectifList: Array<Objectif> = [];
  
  constructor(private _fb: FormBuilder,
    private readonly sharedServicesService : SharedServicesService,
    private clotureService : ClotureService,
    private objectifService : ObjectifService,
    private router: Router
  ) { 
    this.sharedServicesService.getValue().subscribe(value=>{
      this.user = value;
    });
    this.objectifList =  this.sharedServicesService.getObj();
  }

  ngOnInit(): void {
  }

      onSubmit(){        
        for (let i = 0; i < this.objectifList.length; i++) {
        this.objectifService.saveNewObjectif(this.objectifList[i], this.user.id).subscribe();
        }
      this.success = true;
      this.clotureService.cloturer(this.user.id).subscribe();
      this.router.navigate(["/evaluation"]);
      }
}
