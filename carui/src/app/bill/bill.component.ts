import { Component, OnInit } from '@angular/core';
import { RestCallsService } from '../rest-calls.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

  constructor(private srv : RestCallsService) { }

  ngOnInit(): void {
  }

  checkInId:number = 0;
  billAmount : number = 0;
  generateRespMsg : string = "";
  payBillRespMsg : string = "";

  generateBill() {
     this.srv.generateBillApi(this.checkInId).subscribe(data => {
     		if(data.body){
     			this.billAmount = data.body;
     			this.generateRespMsg = "Bill generated for checkin Id : "+this.checkInId+" is -- "+this.billAmount;
     		}else{
     			this.generateRespMsg = "generate bill failed for checkInId "+this.checkInId;
     		}
     })
  }

  payBill() {
      this.srv.payBillApi(this.checkInId).subscribe(data => {
          if(data.body){
              this.payBillRespMsg = "Bill Payed for checkInId "+this.checkInId+" and your service request is closed";
          }
      })
  }

}
