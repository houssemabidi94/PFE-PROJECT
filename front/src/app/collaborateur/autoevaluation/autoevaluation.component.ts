import { Component, OnInit } from '@angular/core';
import { Objectif } from 'app/models/objectif';
import { ObjectifService } from 'app/Services/objectif.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-autoevaluation',
  templateUrl: './autoevaluation.component.html',
  styleUrls: ['./autoevaluation.component.css']
})
export class AutoevaluationComponent implements OnInit {
  
  objectifs: Objectif[];
	tempList: Array<Objectif> = [];
	submitted = false;
  constructor(private objectifService: ObjectifService) { }

  ngOnInit(): void {
    this.getAllObjectifs();
  }
	getAllObjectifs() {
		this.objectifService.getObjectifsList().subscribe(data => 
			this.objectifs = data,
		);
  }
  autoEvaluate() {
		console.log("in auto evaluate method ");
		for (let i = 0; i < this.tempList.length; i++) {
			console.log("saving ...");
			this.objectifService.saveObjectif(this.tempList[i]).subscribe();
		}
  }
  onSubmit() {
		this.submitted = true;
  }
  change(objectif: Objectif) {
		let flag = false;
		if (this.tempList.length == 0) {
			this.tempList.push(objectif);
		}
		else {
			for (let i = 0; i < this.tempList.length; i++) {
				if (this.tempList[i] == objectif) {
					console.log("objectif found ! saving changes on a temp list  list ");
					flag = true;
					this.tempList[i].autoEvaluation = objectif.autoEvaluation;
					this.tempList[i].commentaire = objectif.commentaire;
				}
				if (flag == false) {
					console.log("objectif not found time to push a new objectif ");
					this.tempList.push(objectif);
				}
			}
		}
	}
}
