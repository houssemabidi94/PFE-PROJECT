import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from 'src/models/user';
import { SharedServicesService } from 'src/Services/shared-services.service';
import { ClotureService } from 'src/Services/cloture.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Objectif } from 'src/models/objectif';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ObjectifService } from 'src/Services/objectif.service';

@Component({
  selector: 'app-cloture',
  templateUrl: './cloture.component.html',
  styleUrls: ['./cloture.component.scss']
})
export class ClotureComponent implements OnInit {
  success = false;
  user : User;
  showRemarque = false;

  public invoiceForm: FormGroup;
  objectifList: Array<Objectif> = [];
  
  displayedColumns: string[] = ['position','designation'];
 dataSource : MatTableDataSource<Objectif>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private _fb: FormBuilder,
    private readonly sharedServicesService : SharedServicesService,
    private clotureService : ClotureService,
    private objectifService : ObjectifService
  ) { 
    this.sharedServicesService.getValue().subscribe(value=>{
      this.user = value;
    });

    this.objectifList =  this.sharedServicesService.getObj();
    
    this.dataSource = new MatTableDataSource(this.objectifList);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

  }

  ngOnInit(): void {
  }
  cloturer(){
this.showRemarque = true;
      }

      applyFilter(event: Event) {
        const filterValue = (event.target as HTMLInputElement).value;
        this.dataSource.filter = filterValue.trim().toLowerCase();
    
        if (this.dataSource.paginator) {
          this.dataSource.paginator.firstPage();
        }
      }
      onSubmit(){
        
        for (let i = 0; i < this.objectifList.length; i++) {

        this.objectifService.saveNewObjectif(this.objectifList[i], this.user.id).subscribe();
        }
    
    
  
      this.success = true;
      this.clotureService.cloturer(this.user.id).subscribe();
      }

}
