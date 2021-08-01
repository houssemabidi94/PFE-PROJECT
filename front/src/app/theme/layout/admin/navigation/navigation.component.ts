import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DattaConfig} from '../../../../app-config';
import { NavigationItem } from 'src/app/theme/layout/admin/navigation/navigation';
import { UserProfileService } from 'src/Services/user-profile.service';
import { User } from 'src/models/user';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {
  @Output() onNavCollapse = new EventEmitter();
  @Output() onNavCollapsedMob = new EventEmitter();
  public dattaConfig: any;
  public navCollapsed;
  public navCollapsedMob;
  public windowWidth: number;
  user : User;
  public navigation: any;
  
  constructor(private currentUser : UserProfileService,public nav: NavigationItem) {
    this.dattaConfig = DattaConfig.config;
    this.windowWidth = window.innerWidth;
    this.navCollapsed = (this.windowWidth >= 992) ? this.dattaConfig['collapse-menu'] : false;
    this.navCollapsedMob = false;
    this.navigation = this.nav.get();
  }

  ngOnInit() {
    this.getNavProfile();
  }
  getNavProfile(){
    this.currentUser.getUserProfile().subscribe(data =>{
      this.user = data;
      if(this.user.fonction.libelle == "manager" || this.user.fonction.libelle =="Manager" || this.user.fonction.libelle =="MANAGER"){
        this.navigation[1].hidden = false;
        this.navigation[0].hidden = true;
      }
      if(this.user.fonction.libelle == "collaborateur" || this.user.fonction.libelle =="Collaborateur" || this.user.fonction.libelle =="COLLABORATEUR"){
      this.navigation[0].hidden = false;
      this.navigation[1].hidden = true;
    }
    }
    );
  }
  navCollapse() {
    if (this.windowWidth >= 992) {
      this.navCollapsed = !this.navCollapsed;
      this.onNavCollapse.emit();
    }
  }

  navCollapseMob() {
    if (this.windowWidth < 992) {
      this.onNavCollapsedMob.emit();
    }
  }
}
