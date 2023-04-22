import { Injectable } from '@angular/core';
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class DataCarrierService {

  constructor() { }

  loggedInUser:User = new User();

  setLoggedInUser(user:User){
      this.loggedInUser = user;
  }

  getLoggedInUser(){
    return this.loggedInUser;
  }

}
