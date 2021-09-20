import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Objectif } from 'src/models/objectif';
import { ObjectifService } from 'src/Services/objectif.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { FormGroup, FormControl } from '@angular/forms';
import { MailService } from 'src/Services/mail.service';

@Component({
	selector: 'app-auto-evaluation',
	templateUrl: './auto-evaluation.component.html',
	styleUrls: ['./auto-evaluation.component.scss']
})
export class AutoEvaluationComponent implements AfterViewInit {

	objectifs: Array<Objectif> = [];
	tempList: Array<Objectif> = [];
	submitted = false;
	err = false;
	evaluations = [
		{ "id": 1, "designation": "Performance a ameliore" },
		{ "id": 2, "designation": "Zone de conformite" },
		{ "id": 3, "designation": "Objectif dépassé" },
		{ "id": 4, "designation": "Performance exceptionnelle" }
	];
	//Mat table
	displayedColumns: string[] = ['position', 'designation', 'autoEvaluation', 'commentaire'];
	dataSource: MatTableDataSource<Objectif>;


	@ViewChild(MatPaginator) paginator: MatPaginator;
	@ViewChild(MatSort) sort: MatSort;

	constructor(private objectifService: ObjectifService,
				private mailservice: MailService) {

		this.getAllObjectifs();
	}
	ngAfterViewInit() {

	}
	getAllObjectifs() {

		this.objectifService.getObjectifsList().subscribe(data => {
			this.objectifs = data,
				this.dataSource = new MatTableDataSource(this.objectifs);
			this.dataSource.paginator = this.paginator;
			this.dataSource.sort = this.sort;
		});
	}
	autoEvaluate() {

		for (let i = 0; i < this.tempList.length; i++) {
			this.objectifService.saveObjectif(this.tempList[i]).subscribe();
		}
		this.submitted = true;
		this.mailservice.sentMailToManager().subscribe();
	}

	change(objectif: Objectif) {
		let flag = false;
		if (this.tempList.length == 0) {
			this.tempList.push(objectif);
		}
		else {
			for (let i = 0; i < this.tempList.length; i++) {
				if (this.tempList[i] == objectif) {
					flag = true;
					this.tempList[i].autoEvaluation = objectif.autoEvaluation;
					this.tempList[i].commentaire = objectif.commentaire;
				}
				if (flag == false) {
					this.tempList.push(objectif);
				}
			}
		}
	}
	applyFilter(event: Event) {
		const filterValue = (event.target as HTMLInputElement).value;
		this.dataSource.filter = filterValue.trim().toLowerCase();

		if (this.dataSource.paginator) {
			this.dataSource.paginator.firstPage();
		}
	}


	form = new FormGroup({
		supName: new FormControl()
	});




}
