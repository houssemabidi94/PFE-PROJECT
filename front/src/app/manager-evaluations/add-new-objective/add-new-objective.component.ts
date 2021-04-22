import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormArray } from '@angular/forms';
import { Objectif } from 'src/models/objectif';
import { User } from 'src/models/user';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { ObjectifService } from 'src/Services/objectif.service';

@Component({
  selector: 'app-add-new-objective',
  templateUrl: './add-new-objective.component.html',
  styleUrls: ['./add-new-objective.component.scss']
})
export class AddNewObjectiveComponent implements OnInit {

  public invoiceForm: FormGroup;

  newObjectif: Objectif = new Objectif();

  newObjectifList: Array<Objectif> = [];

  obj: Objectif = new Objectif();

  user : User;

  constructor(private _fb: FormBuilder,
  private readonly sharedServicesService : SharedServicesService,
private objectifService : ObjectifService) { }

  ngOnInit() {

    this.obj = new Objectif();
    this.newObjectifList.push(this.obj);
    
    this.sharedServicesService.getValue().subscribe(value=>{
      this.user = value;
    });
  }

  get formArr() {
    return this.invoiceForm.get('itemRows') as FormArray;
  }

  initItemRows() {
    this.obj = new Objectif();
			this.newObjectifList.push(this.obj);
  }

  addNewRow() {
    this.obj = new Objectif();
			this.newObjectifList.push(this.obj);
  }

  deleteRow(index: number) {
    this.formArr.removeAt(index);
  }

  onSubmit(){
    for (let i = 0; i < this.newObjectifList.length; i++) {
      
        this.objectifService.saveNewObjectif(this.newObjectifList[i], this.user.id).subscribe();
        console.log("saved");      
    }
  }
	addNew(objectif: Objectif) {
		this.newObjectif = objectif;
	}
}
