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
import { EvaluationPK } from 'src/models/evaluationPK';
import { EvaluationService } from 'src/Services/evaluation.service';


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

  idCompet : Array<any>;

  tempList: Array<Evaluation> = [];

  userEval : Array<Evaluation> = [];


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
    private descrServ : DescriptionService,
    private evalcomp : EvaluationService
  ) {

    this.competenceService.getCompetenceList().subscribe(data =>{ this.competences = data;
   /*   for (let i = 0 ; i<this.competences.length;i++){
           this.evalcomp.getUserEval(this.user.id,this.competences[i].id).subscribe(data =>{ this.userEval = data;
            console.log(this.userEval[i].evaluationPK.idNiveau);
      });
        }*/
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
}
evaluate() {
    this.success = true;

    for (let i = 0; i < this.tempList.length; i++) {
      this.evalcomp.newEvaluation(this.tempList[i].evaluationPK.idUser,
        this.tempList[i].evaluationPK.idCompetence,
        this.tempList[i].evaluationPK.idNiveau).subscribe();
    }
}

getDescriptions(competence : Competence){
  this.descrServ.getDescriptionByCompetenceId(competence.id).subscribe(data=>{
    this.desc = data;
  })
}

saveCompetenceEvaluations(competence: Competence , idNiveau : number) {
  //console.log("Competence ID:", competence.id,"userId",this.user.id,"niveauID",idNiveau);

  let flag = false;

let evaluation : Evaluation = new Evaluation();
let evaluationPk : EvaluationPK = new EvaluationPK();

evaluation.evaluationPK = evaluationPk;

evaluation.evaluationPK.idUser = this.user.id;
evaluation.evaluationPK.idNiveau = idNiveau;
evaluation.evaluationPK.idCompetence = competence.id;


if (this.tempList.length == 0) {
  console.log(" empty list  ! saving changes ");
  this.tempList.push(evaluation);
  console.log(evaluation);
}
else {
  for (let i = 0; i < this.tempList.length; i++) {
    if (this.tempList[i].evaluationPK.idCompetence == evaluation.evaluationPK.idCompetence &&
      this.tempList[i].evaluationPK.idUser == evaluation.evaluationPK.idUser  ) {
      console.log("competence found ! saving new level");
      flag = true
      console.log("updatig Level ...");
      this.tempList[i].evaluationPK.idNiveau=idNiveau;
      console.log("saved");
      console.log(evaluation);
      break;
    }
  }
    if (flag == false) {
      console.log("description not found time to push a new description");
      this.tempList.push(evaluation);
      console.log(evaluation);
    }

}

}
getNiveaux(competence : Competence){

}
}


