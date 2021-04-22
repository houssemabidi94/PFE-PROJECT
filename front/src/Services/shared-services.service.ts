import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/internal/Subject';
import { User } from 'src/models/user';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SharedServicesService {

private user = new Subject<User>();

  constructor() { }

  public getValue(): Observable<User> {

    return this.user;

  }
  public setValue(user: User): void {
    this.user.next(user);
  }
}
