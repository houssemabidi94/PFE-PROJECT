import { Component, OnInit, ViewChild } from '@angular/core';
import { Objectif } from 'src/models/objectif';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { ObjectifService } from 'src/Services/objectif.service';
import { Router } from '@angular/router';
import { EntretienService } from 'src/Services/entretien.service';
import { FormBuilder } from '@angular/forms';
import { Entretien } from 'src/models/entretien';
import { User } from 'src/models/user';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {

  user: User;
  entretient: Entretien[] = [];
  collaborateur = false;
	//Mat table
	displayedColumns: string[] = ['position', 'Collaborateur'];
	dataSource: MatTableDataSource<Entretien>;
	
	@ViewChild(MatPaginator) paginator: MatPaginator;
	@ViewChild(MatSort) sort: MatSort;

  constructor(private _formBuilder: FormBuilder,
    private es: EntretienService,
    private router: Router,
    private readonly sharedServicesService: SharedServicesService
  ) { }

  ngOnInit() {
    this.getListEips();
  }

  getListEips() {
    this.es.getEntretienList().subscribe(data =>{
      this.entretient = data,
      this.dataSource = new MatTableDataSource(this.entretient);
      this.dataSource.paginator = this.paginator;
			this.dataSource.sort = this.sort;
    }
    )
  }

  getCollaborateur(entretien) {
    this.es.getCollaborateurByEntretien(entretien).subscribe(data => {
      this.user = data,
        this.sharedServicesService.setValue(this.user);
    }); 
    
    this.router.navigate(["/feedback"]);  
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
	}


}
