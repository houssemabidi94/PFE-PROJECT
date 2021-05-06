import { Component, OnInit } from '@angular/core';
import { Objectif } from 'src/models/objectif';
import { ObjectifService } from 'src/Services/objectif.service';

@Component({
  selector: 'app-collab-evaluation',
  templateUrl: './collab-evaluation.component.html',
  styleUrls: ['./collab-evaluation.component.scss']
})
export class CollabEvaluationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
}