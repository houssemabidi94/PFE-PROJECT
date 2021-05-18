import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/Services/authentication.service';

@Component({
  selector: 'app-auth-login',
  templateUrl: './auth-login.component.html',
  styleUrls: ['./auth-login.component.scss']
})
export class AuthLoginComponent implements OnInit {

  user = new User;
  invalidLogin =false;

  constructor(public router : Router , private loginservice: AuthenticationService) { }

  ngOnInit() {
    if (this.loginservice.isUserLoggedIn) {
      this.router.navigate(['/home']);
   }
  } 


verify(){
  (this.loginservice.authenticate(this.user.email, this.user.password).subscribe(
    data => {
      this.router.navigate(['']);
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
}
