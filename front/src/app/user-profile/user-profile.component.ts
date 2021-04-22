import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { UserProfileService } from 'src/Services/user-profile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  user : User;

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
