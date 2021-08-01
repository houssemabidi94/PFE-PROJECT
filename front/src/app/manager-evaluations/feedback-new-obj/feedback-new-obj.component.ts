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
  objectifList: Array<Objectif>;
  constructor(
    private readonly sharedServicesService : SharedServicesService,
    private objectifService : ObjectifService

  ) {
    this.objectifService.getObjectifsList().subscribe(data =>
      this.objectifs = data
    );
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
  }
}
