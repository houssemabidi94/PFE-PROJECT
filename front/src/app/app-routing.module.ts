import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './theme/layout/admin/admin.component';
import { AuthGuardService } from 'src/Services/authguard.service';
import { AutoEvaluationComponent } from 'src/app/auto-evaluation/auto-evaluation.component';
import { UserProfileComponent } from 'src/app/user-profile/user-profile.component';
import { ManagerEvaluationsComponent } from 'src/app/manager-evaluations/manager-evaluations.component';
import { AuthLoginComponent } from 'src/app/auth-login/auth-login.component';

import { CollabEvaluationComponent } from 'src/app/collab-evaluation/collab-evaluation.component';
import { EvaluationComponent } from 'src/app/manager-evaluations/evaluation/evaluation.component';
import { EvaluationCompetenceComponent } from 'src/app/manager-evaluations/evaluation-competence/evaluation-competence.component';
import { FeedbackNewObjComponent } from 'src/app/manager-evaluations/feedback-new-obj/feedback-new-obj.component';
import { RapportEvalManagerComponent } from './rapport-eval-manager/rapport-eval-manager.component';
import { RapportEvalCollabComponent } from './rapport-eval-collab/rapport-eval-collab.component';




const routes: Routes = [
  {
    path: '',
    canActivate:[AuthGuardService],
    component: AdminComponent,
    children: [
      {
        path : 'auto-evaluation',
        component : CollabEvaluationComponent
      },
      {
        path : 'profile',
        component : UserProfileComponent,
      },
      {
        path : 'eips',
        component : ManagerEvaluationsComponent
      },
      {
        path : 'evaluation',
        component : EvaluationComponent
      },
      {
        path : 'competence',
        component : EvaluationCompetenceComponent
      },
      {
        path : 'feedback',
        component : FeedbackNewObjComponent
      },
      {
        path : 'rapport-collab/:id',
        component : RapportEvalCollabComponent
      },
      {
        path : 'rapport-manager',
        component : RapportEvalManagerComponent
      }
    ]
  },
  {
    path: 'login',
    component: AuthLoginComponent
  },
  {
    path : '**',
    redirectTo: 'login',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
