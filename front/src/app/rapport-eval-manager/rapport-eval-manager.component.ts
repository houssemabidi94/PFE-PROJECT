import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Entretien } from 'src/models/entretien';
import { Objectif } from 'src/models/objectif';
import { User } from 'src/models/user';
import { EntretienService } from 'src/Services/entretien.service';
import { EvaluationService } from 'src/Services/evaluation.service';
import { ObjectifService } from 'src/Services/objectif.service';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { UserProfileService } from 'src/Services/user-profile.service';

@Component({
  selector: 'app-rapport-eval-manager',
  templateUrl: './rapport-eval-manager.component.html',
  styleUrls: ['./rapport-eval-manager.component.scss']
})
export class RapportEvalManagerComponent implements OnInit {

objectif : Objectif;
user : User;
newobjectifs : Objectif;
evalcomp : any[];
entretien : Entretien = new Entretien();
  constructor(private objservice : ObjectifService,
    private route: ActivatedRoute,
    private router: Router,
    private userservice : UserProfileService,
    private sharedServicesService: SharedServicesService,
    private evalService: EvaluationService,
    private entretienService : EntretienService) { }

  ngOnInit(): void {


      this.route.params.subscribe(params => {
        
        this.objservice.getEvaluatedObjectifByManager().subscribe(data =>
          this.objectif = data);
       
      });
      this.userservice.getManager().subscribe(values =>
        this.user = values)
        this.objservice.getNewObjectifs().subscribe(datta =>
          this.newobjectifs = datta);

      this.evalService.getCompEvaluated().subscribe(comp =>
        this.evalcomp = comp);

        this.entretienService.getUserEntretien().subscribe(entr =>
          this.entretien = entr)
  }
  onClick(){
  }

}
