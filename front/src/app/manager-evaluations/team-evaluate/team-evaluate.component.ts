import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from 'src/models/user';
import { Entretien } from 'src/models/entretien';
import { FormBuilder } from '@angular/forms';
import { EntretienService } from 'src/Services/entretien.service';
import { Objectif } from 'src/models/objectif';
import { ObjectifService } from 'src/Services/objectif.service';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-team-evaluate',
  templateUrl: './team-evaluate.component.html',
  styleUrls: ['./team-evaluate.component.scss']
})
export class TeamEvaluateComponent implements OnInit {

  user: User ;
  entretient: Entretien[] = [];
  collaborateur = false;
  objectifs: Objectif[] = [];
  objectifList: Array<Objectif> = [];
  success = false;
  evaluations = [
		{ "id": 1, "designation": "Performance a ameliore"},
		{ "id": 2, "designation": "Zone de conformite"},
		{ "id": 3, "designation": "Objectif dépassé"},
		{ "id": 4, "designation": "Performance exceptionnelle"}
	];
	displayedColumns: string[] = ['position', 'designation','autoEvaluation','evaluation','remarque'];
	dataSource: MatTableDataSource<Objectif>;
	
	@ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  

  constructor(private _formBuilder: FormBuilder,
    private es: EntretienService,
    private objectifService: ObjectifService,
    private readonly sharedServicesService: SharedServicesService
  ) { }

  ngOnInit() {
    this.sharedServicesService.getValue().subscribe(value=>{
      this.user = value;
      this.findCollabObjectif(this.user.id);
    });
    
  }

  findCollabObjectif(id) {
    this.objectifService.getCollaborateurObjectifsForManager(this.user.id).subscribe(data => {
      this.objectifs = data;
      this.dataSource = new MatTableDataSource(this.objectifs);
      this.dataSource.paginator = this.paginator;
			this.dataSource.sort = this.sort;
    });
  }

  change(objectif: Objectif) {
    let flag = false;
    if (this.objectifList.length == 0) {
      this.objectifList.push(objectif);
    }
    else {
      for (let i = 0; i < this.objectifList.length; i++) {
        if (this.objectifList[i] == objectif) {
          flag = true;
          this.objectifList[i].evaluation = objectif.evaluation;
          this.objectifList[i].remarque = objectif.remarque;
        }
        if (flag == false) {
          this.objectifList.push(objectif);
        }
      }
    }
  }

  onSubmit() {                
        this.evaluate();
  }
  evaluate() {
 
    if (this.objectifList.length != 0) {
      for (let i = 0; i < this.objectifList.length; i++) {
        this.objectifService.evaluate(this.objectifList[i]).subscribe();
      }
        this.success = true;
    }

  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
	}

}
