import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/internal/Subject';
import { User } from 'src/models/user';
import { Observable } from 'rxjs';
import { Objectif } from 'src/models/objectif';


@Injectable({
  providedIn: 'root'
})
export class SharedServicesService {

private user = new Subject<User>();

private newObj : Array<Objectif> = [];

  constructor() { }

  public getValue(): Observable<User> {

    return this.user;

  }
  public setValue(user: User): void {
    this.user.next(user);
  }

  public getObj(): Array<Objectif> {

    return this.newObj;

  }
  public setObj(obj: any): Array<Objectif> {
     this.newObj.push(obj);
     return this.newObj;
  }
}
