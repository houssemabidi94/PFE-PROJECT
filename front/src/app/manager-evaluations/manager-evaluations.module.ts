import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';

import { ManagerEvaluationsRoutingModule } from './manager-evaluations-routing.module';
import { ManagerEvaluationsComponent } from './manager-evaluations.component';
import { TeamEvaluateComponent } from './team-evaluate/team-evaluate.component';
import { MaterialModule } from 'src/app/material/material.module';
import { SharedModule } from 'src/app/theme/shared/shared.module';
import { AddNewObjectiveComponent } from './add-new-objective/add-new-objective.component';
@NgModule({
  declarations: [ManagerEvaluationsComponent, TeamEvaluateComponent, AddNewObjectiveComponent],
  imports: [
    CommonModule,
    ManagerEvaluationsRoutingModule,
    MaterialModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    SharedModule
  ]
})
export class ManagerEvaluationsModule { }
