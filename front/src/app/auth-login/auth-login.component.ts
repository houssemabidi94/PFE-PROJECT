import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/Services/authentication.service';
import { UserProfileService } from 'src/Services/user-profile.service';

@Component({
  selector: 'app-auth-login',
  templateUrl: './auth-login.component.html',
  styleUrls: ['./auth-login.component.scss']
})
export class AuthLoginComponent implements OnInit {

  user = new User;
  userInfo : User;
  invalidLogin =false;

  constructor(public router : Router , private loginservice: AuthenticationService,
    private userService: UserProfileService) { }

  ngOnInit() {
    if (this.loginservice.isUserLoggedIn) {
      this.getUserProfile();
   }
  } 


verify(){
  (this.loginservice.authenticate(this.user.email, this.user.password).subscribe(
    data => { 
    this.getUserProfile();
      this.invalidLogin = false;
    },
    error => {
      this.invalidLogin = true;

    }
  )
  );
}
onSubmit(invalid) {
  if(!invalid)
    this.verify();
    
}
getUserProfile(){
  this.userService.getUserProfile().subscribe(data =>{
    this.userInfo = data;
    if(this.userInfo.fonction.libelle == "manager" || this.userInfo.fonction.libelle =="Manager" || this.userInfo.fonction.libelle =="MANAGER")
  this.router.navigate(['/evaluation']);
  else if (this.userInfo.fonction.libelle == "collaborateur" || this.userInfo.fonction.libelle =="Collaborateur" || this.userInfo.fonction.libelle =="COLLABORATEUR")
  this.router.navigate(['/auto-evaluation']);

}
  );
}
}
