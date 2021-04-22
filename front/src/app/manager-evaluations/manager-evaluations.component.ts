import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Objectif } from 'src/models/objectif';
import { ObjectifService } from 'src/Services/objectif.service';

@Component({
  selector: 'app-manager-evaluations',
  templateUrl: './manager-evaluations.component.html',
  styleUrls: ['./manager-evaluations.component.scss']
})
export class ManagerEvaluationsComponent implements OnInit {

  isLinear = false;
  objectifList: Array<Objectif> = [];
  constructor( private objectifService: ObjectifService ) { 
    
  }

  ngOnInit(): void {
  }

onSubmit(){
  this.evaluate();
}
evaluate(){
  if (this.objectifList.length != 0) {
    for (let i = 0; i < this.objectifList.length; i++) {
      console.log("saving object ...");
      this.objectifService.evaluate(this.objectifList[i]).subscribe();
      console.log(this.objectifList[i]);
      console.log("saved");
    }
  }
}
}
