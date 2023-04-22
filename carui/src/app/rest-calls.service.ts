import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
import { Slot } from './slot';
import { CarService } from './car-service';



@Injectable({
  providedIn: 'root'
})
export class RestCallsService {

   constructor(private httpVar:HttpClient) { }

  getHeadersInfo():any{
    return {
	         headers: new HttpHeaders({
	         'Content-Type':  'application/json',
	         'Accept':'*/*' 
	       })
	    };
  }

  restUrl:string = "http://localhost:8081/";

  validateLogin(userObj:User):Observable<any>{
      var validateLoginRestApi = this.restUrl+"user/login";
      return this.httpVar.post(validateLoginRestApi, userObj, this.getHeadersInfo());
  }

  checkSlotApi(date:string):Observable<any>{
      var checkSlotRestApi = this.restUrl+"carApp/checkSlot";
      return this.httpVar.post(checkSlotRestApi, date, this.getHeadersInfo());
  }

  bookSlotApi(slot:Slot):Observable<any>{
     var bookSlotRestApi = this.restUrl+"carApp/bookSlot";
     return this.httpVar.post(bookSlotRestApi, slot, this.getHeadersInfo());
  }

  checkInCarApi(carService:CarService):Observable<any> {
     var checkInCarRestApi = this.restUrl+"carApp/checkIn";
     return this.httpVar.post(checkInCarRestApi, carService, this.getHeadersInfo());
  }

  displayDashBoardApi():Observable<any> {
      var displayDashBoardRestApi = this.restUrl+"carApp/dashboard";
      return this.httpVar.get(displayDashBoardRestApi);
  }

  generateBillApi(checkInId:number):Observable<any> {
     var generateBillUrl = this.restUrl + "bill/generate?checkInId="+checkInId;
     return this.httpVar.get(generateBillUrl);
  }

  payBillApi(checkInId:number):Observable<any> {
     var payBillUrl = this.restUrl + "bill/pay/"+checkInId;
     return this.httpVar.get(payBillUrl);
  }

}
