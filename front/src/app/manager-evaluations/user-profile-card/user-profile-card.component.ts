import { Component, OnInit } from '@angular/core';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { User } from 'src/models/user';

@Component({
  selector: 'app-user-profile-card',
  templateUrl: './user-profile-card.component.html',
  styleUrls: ['./user-profile-card.component.scss']
})
export class UserProfileCardComponent implements OnInit {
  user: User ;
  
  constructor(private readonly sharedServicesService: SharedServicesService) { }

  ngOnInit(): void {
    this.sharedServicesService.getValue().subscribe(value=>{
      this.user = value;
    });
  }

}
