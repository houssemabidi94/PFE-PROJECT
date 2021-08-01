import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { Entretien } from 'src/models/entretien';
import { FormBuilder } from '@angular/forms';
import { EntretienService } from 'src/Services/entretien.service';
import { Objectif } from 'src/models/objectif';
import { ObjectifService } from 'src/Services/objectif.service';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.scss']
})
export class EvaluationComponent implements OnInit {
  show1 = true;
  show2 = false;
  show3 = false;
  ngOnInit(): void {

  }

  showEquipeEval(){
    this.show1 = true;
    this.show2 = false;
    this.show3 = false;
      }
      showManagerEval(){
        this.show2 = true;
        this.show1 = false;
        this.show3 = false;
      }
      showFeedback(){
        this.show3 = true;
        this.show1 = false;
        this.show2 = false;
      }
}
