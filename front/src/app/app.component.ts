import {Component, OnInit} from '@angular/core';
import {NavigationEnd, Router} from '@angular/router';
import { User } from 'src/models/user';
import { NavigationItem } from 'src/app/theme/layout/admin/navigation/navigation';
import { UserProfileService } from 'src/Services/user-profile.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Sofrecom';

  constructor(private router: Router) {
    
   }

  ngOnInit() {
    this.router.events.subscribe((evt) => {
      if (!(evt instanceof NavigationEnd)) {
        return;
      }
      window.scrollTo(0, 0);
    });
  }

}
