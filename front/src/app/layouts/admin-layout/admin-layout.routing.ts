import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { NotfoundComponent } from 'app/notfound/notfound.component';
import { AutoevaluationComponent } from 'app/collaborateur/autoevaluation/autoevaluation.component';

export const AdminLayoutRoutes: Routes = [

    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent },
    { path: 'evaluation',     component: AutoevaluationComponent },
    { path: '**',             component:NotfoundComponent},

];
