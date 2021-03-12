import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';


import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';

import { AppComponent } from './app.component';

import { DashboardComponent } from './dashboard/dashboard.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { TableListComponent } from './table-list/table-list.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { AuthComponent } from './auth/auth.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { BrowserModule } from '@angular/platform-browser';
import { ObjectifService } from 'app/Services/objectif.service';
import { AuthGuardService } from 'app/Services/authguard.service';
import { AuthenticationService } from 'app/Services/authentication.service';
import { BasicAuthHttpInterceptorService } from 'app/Services/basic-auth-http-interceptor.service';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ComponentsModule,
    RouterModule,
    AppRoutingModule,
    BrowserModule
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    AuthComponent,
    NotfoundComponent,

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BasicAuthHttpInterceptorService,
      multi: true
    },AuthGuardService,HttpClientModule,AuthenticationService,ObjectifService],
  bootstrap: [AppComponent]
})
export class AppModule { }
