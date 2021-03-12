import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; 
import {AuthenticationService } from '../Services/authentication.service';
import { User } from '../models/user';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

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
      console.log(data);
      this.router.navigate(['']);
      this.invalidLogin = false;
    },
    error => {
      console.log(error);
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