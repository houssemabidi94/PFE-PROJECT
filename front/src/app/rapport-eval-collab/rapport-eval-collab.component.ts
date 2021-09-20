import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Objectif } from 'src/models/objectif';
import { User } from 'src/models/user';
import { ObjectifService } from 'src/Services/objectif.service';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { UserProfileService } from 'src/Services/user-profile.service';

@Component({
  selector: 'app-rapport-eval-collab',
  templateUrl: './rapport-eval-collab.component.html',
  styleUrls: ['./rapport-eval-collab.component.scss']
})
export class RapportEvalCollabComponent implements OnInit {


  objectif : Objectif;
  user : User;
    constructor(private objservice : ObjectifService,
      private route: ActivatedRoute,
      private router: Router,
      private userservice : UserProfileService,
      private sharedServicesService: SharedServicesService) { }
  
    ngOnInit(): void {
  
  
        this.route.params.subscribe(params => {
          
          this.objservice.getEvaluatedObjectifByCollab(params['id']).subscribe(data =>
            this.objectif = data);
          this.userservice.getUser(params['id']).subscribe(value =>
            this.user = value
         );
        });
        
    }
    onClick(){
      this.router.navigate(["/evaluation"]);
    }
  
  }
  