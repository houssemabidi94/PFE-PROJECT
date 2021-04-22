import { Component, OnInit } from '@angular/core';
import { EntretienService } from 'src/Services/entretien.service';
import { Entretien } from 'src/models/entretien';
import { User } from 'src/models/user';
import { ListeEipsComponent } from 'src/app/liste-eips/liste-eips.component';

@Component({
  selector: 'app-user-evaluation-card',
  templateUrl: './user-evaluation-card.component.html',
  styleUrls: ['./user-evaluation-card.component.scss']
})
export class UserEvaluationCardComponent implements OnInit {
  entretien: Entretien;

  user : User ;
  constructor(private entretientService: EntretienService,
              private eip : ListeEipsComponent) { }

  ngOnInit() {
    this.eip.getCollaborateur(this.entretien);
  }


}
