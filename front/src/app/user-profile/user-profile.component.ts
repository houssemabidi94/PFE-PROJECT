import { Component, OnInit } from '@angular/core';
import { User } from 'app/models/user';
import { ObjectifService } from 'app/Services/objectif.service';
import { UserProfileService } from 'app/Services/user-profile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user : User[];

  constructor(private userService: UserProfileService) { }

  ngOnInit() {
this.getUserProfile();
  }
getUserProfile(){
  this.userService.getUserProfile().subscribe(data =>
    this.user = data
  );
}
}
