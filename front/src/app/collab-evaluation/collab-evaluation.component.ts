import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/models/user';

@Component({
  selector: 'app-collab-evaluation',
  templateUrl: './collab-evaluation.component.html',
  styleUrls: ['./collab-evaluation.component.scss']
})
export class CollabEvaluationComponent implements OnInit {

userInfo = new User;

  constructor(
 private router : Router) { }

  ngOnInit(): void {
  }

 
}