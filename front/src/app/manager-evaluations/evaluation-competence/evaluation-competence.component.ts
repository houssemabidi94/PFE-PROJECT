import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { Competence } from 'src/models/competence';
import { CompetenceService } from 'src/Services/competence.service';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { User } from 'src/models/user';
import { NiveauService } from 'src/Services/niveau.service';
import { Niveau } from 'src/models/niveau';
import { DescriptionService } from 'src/Services/description.service';
import { Description } from 'src/models/description';
import { Evaluation } from 'src/models/evaluation';


@Component({
  selector: 'app-evaluation-competence',
  templateUrl: './evaluation-competence.component.html',
  styleUrls: ['./evaluation-competence.component.scss']
})
export class EvaluationCompetenceComponent implements AfterViewInit {
  displayedColumns: string[] = ['position', 'designation', 'definition', 'outilsEvaluation','niveau'];
  dataSource: MatTableDataSource<Competence>;

  competences: Array<Competence>=[];

  desc : Array<Description> = [];

  idCompet : number;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  user: User ;
  success = false;
  

  ngOnInit(): void {
    this.sharedServicesService.getValue().subscribe(value=>{
      this.user = value;
    });
    
  }
  constructor(private readonly sharedServicesService: SharedServicesService,
    private competenceService: CompetenceService,
    private niveauxServ : NiveauService,
    private descrServ : DescriptionService
  ) {
    this.competenceService.getCompetenceList().subscribe(data =>{ this.competences = data;
      this.dataSource = new MatTableDataSource(this.competences);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
     });  
  }
  ngAfterViewInit() {
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  onSubmit() {                
    this.evaluate();
    this.sharedServicesService.setValue(this.user);
}
evaluate() {
    this.success = true;
}

getDescriptions(competence : Competence){
  this.descrServ.getDescriptionByCompetenceId(competence.id).subscribe(data=>{
    this.desc = data;
  })
}

}

