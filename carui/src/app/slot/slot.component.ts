import { Component, OnInit } from '@angular/core';
import { RestCallsService } from '../rest-calls.service';
import { Slot } from '../slot';
import { DataCarrierService } from '../data-carrier.service';
import { User } from '../user';

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit {

  constructor(private restApi:RestCallsService, private dataSrv:DataCarrierService) { }

  ngOnInit(): void {
     this.loggedInUser = this.dataSrv.getLoggedInUser();
     this.slot.vehicleNo = this.loggedInUser.vehicleNo;
  }
  loggedInUser:User = new User();
  checkSlotResp:string = "";
  bookSlotFlag:boolean = false;
  

  slot:Slot = new Slot();
  slotBookingResponseMsg:string = "";

  checkSlot(){
      this.restApi.checkSlotApi(this.slot.serviceDate).subscribe(data => {
            if(data.body){
               this.checkSlotResp = "Slot is available, you can book your slot quickly";
               this.bookSlotFlag = true;
            }else{
               this.checkSlotResp = "Sorry, Slots are not available on this day";
               this.bookSlotFlag = false;
            }
      });
  }

  bookSlot() {
      this.restApi.bookSlotApi(this.slot).subscribe(data => {
           if(data.body){
             this.slotBookingResponseMsg = "Slot booked for vehicle "+ this.slot.vehicleNo+" on date "+this.slot.serviceDate+" with service Id "+data.body;
           }else{
              this.slotBookingResponseMsg = "Slot booking failed";
           }

      })
  }

}
