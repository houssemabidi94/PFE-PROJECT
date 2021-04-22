import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/Services/authentication.service';
import { User } from 'src/models/user';

@Component({
  selector: 'app-auth-signin',
  templateUrl: './auth-signin.component.html',
  styleUrls: ['./auth-signin.component.scss']
})
export class AuthSigninComponent implements OnInit {

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
