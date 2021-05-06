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
  submitted = false;
  clicked = false;

  constructor(public router : Router , private loginservice: AuthenticationService) { }

  ngOnInit() {

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
  this.clicked=true;
  if(!invalid)
    this.verify();
  else{
    this.submitted = false;
  }
    
}
}
