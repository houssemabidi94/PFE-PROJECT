import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { SharedModule } from './theme/shared/shared.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './theme/layout/admin/admin.component';
import { NavigationComponent } from './theme/layout/admin/navigation/navigation.component';
import { NavLogoComponent } from './theme/layout/admin/navigation/nav-logo/nav-logo.component';
import { NavContentComponent } from './theme/layout/admin/navigation/nav-content/nav-content.component';
import {NavigationItem} from './theme/layout/admin/navigation/navigation';
import { NavGroupComponent } from './theme/layout/admin/navigation/nav-content/nav-group/nav-group.component';
import { NavCollapseComponent } from './theme/layout/admin/navigation/nav-content/nav-collapse/nav-collapse.component';
import { NavItemComponent } from './theme/layout/admin/navigation/nav-content/nav-item/nav-item.component';
import { NavBarComponent } from './theme/layout/admin/nav-bar/nav-bar.component';
import {NgbButtonsModule, NgbDropdownModule, NgbTabsetModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import { NavLeftComponent } from './theme/layout/admin/nav-bar/nav-left/nav-left.component';
import { NavSearchComponent } from './theme/layout/admin/nav-bar/nav-left/nav-search/nav-search.component';
import { NavRightComponent } from './theme/layout/admin/nav-bar/nav-right/nav-right.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthGuardService } from 'src/Services/authguard.service';
import { AuthenticationService } from 'src/Services/authentication.service';
import { BasicAuthHttpInterceptorService } from 'src/Services/basic-auth-http-interceptor.service';
import { AutoEvaluationComponent } from './auto-evaluation/auto-evaluation.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ManagerEvaluationsModule } from 'src/app/manager-evaluations/manager-evaluations.module';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { AuthLoginComponent } from './auth-login/auth-login.component';

import { MaterialModule } from 'src/models/material/material.module';
import { CollabEvaluationComponent } from './collab-evaluation/collab-evaluation.component';
import { EvaluationComponent } from 'src/app/manager-evaluations/evaluation/evaluation.component';
import { RapportEvalManagerComponent } from './rapport-eval-manager/rapport-eval-manager.component';
import { RapportEvalCollabComponent } from './rapport-eval-collab/rapport-eval-collab.component';

 
@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    NavigationComponent,
    NavLogoComponent,
    NavContentComponent,
    NavGroupComponent,
    NavCollapseComponent,
    NavItemComponent,
    NavBarComponent,
    NavLeftComponent,
    NavSearchComponent,
    NavRightComponent,
    AutoEvaluationComponent,
    UserProfileComponent,
    AuthLoginComponent,
    EvaluationComponent,
    CollabEvaluationComponent,
    RapportEvalManagerComponent,
    RapportEvalCollabComponent,
    
    
    ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    NgbDropdownModule,
    NgbTooltipModule,
    NgbButtonsModule,
    NgbTabsetModule,
    FormsModule,
    HttpClientModule,
    ManagerEvaluationsModule,
    MaterialModule
    
  ],
  providers: [ {
    provide: HTTP_INTERCEPTORS,
    useClass: BasicAuthHttpInterceptorService,
    multi: true
  },AuthGuardService,HttpClientModule,AuthenticationService,NavigationItem,SharedServicesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
