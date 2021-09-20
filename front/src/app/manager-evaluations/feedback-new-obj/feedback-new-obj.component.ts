import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { Objectif } from 'src/models/objectif';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { ObjectifService } from 'src/Services/objectif.service';

@Component({
  selector: 'app-feedback-new-obj',
  templateUrl: './feedback-new-obj.component.html',
  styleUrls: ['./feedback-new-obj.component.scss']
})
export class FeedbackNewObjComponent implements OnInit {
  success = false;
  user : User;
	objectifs: Array<Objectif> = [];
  objectifList: Array<Objectif> = [];
  constructor(
    private readonly sharedServicesService : SharedServicesService,
    private objectifService : ObjectifService

  ) {
      this.sharedServicesService.getValue().subscribe(value=>{
        this.user = value;
        console.log(this.user);
        this.objectifService.getCollaborateurNewObjectifsForManager(this.user.id).subscribe(objs =>{
          this.objectifList = objs;
          console.log(this.objectifList)
          console.log(this.user)
        });
      });
  

      

   }

  ngOnInit(): void {
  }
  onSubmit(){
    for (let i = 0; i < this.objectifList.length; i++) {
    this.objectifService.saveNewObjectif(this.objectifList[i], this.user.id).subscribe();
  }

  this.success = true;
  }
}
