import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';

import { ManagerEvaluationsRoutingModule } from './manager-evaluations-routing.module';
import { ManagerEvaluationsComponent } from './manager-evaluations.component';

import { SharedModule } from 'src/app/theme/shared/shared.module';
import { AddNewObjectiveComponent } from './add-new-objective/add-new-objective.component';
import { MaterialModule } from 'src/models/material/material.module';
import { STEPPER_GLOBAL_OPTIONS } from '@angular/cdk/stepper';
import { TeamEvaluateComponent } from 'src/app/manager-evaluations/team-evaluate/team-evaluate.component';
import { EvaluationCompetenceComponent } from './evaluation-competence/evaluation-competence.component';
import { EipEquipeComponent } from './eip-equipe/eip-equipe.component';
import { UserProfileCardComponent } from './user-profile-card/user-profile-card.component';
import { ProjetProfessionelComponent } from './projet-professionel/projet-professionel.component';
import { ClotureComponent } from './cloture/cloture.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FeedbackNewObjComponent } from './feedback-new-obj/feedback-new-obj.component';

@NgModule({
  declarations: [ManagerEvaluationsComponent, AddNewObjectiveComponent,TeamEvaluateComponent, EvaluationCompetenceComponent, EipEquipeComponent, UserProfileCardComponent, ProjetProfessionelComponent, ClotureComponent, FeedbackComponent, FeedbackNewObjComponent],
  imports: [
    CommonModule,
    ManagerEvaluationsRoutingModule,
    MaterialModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    SharedModule
  ],
  exports : [EipEquipeComponent,UserProfileCardComponent,FeedbackComponent]
})
export class ManagerEvaluationsModule { }
