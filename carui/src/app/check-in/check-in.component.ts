import { Component, OnInit } from '@angular/core';
import { CarService } from '../car-service';
import { RestCallsService } from '../rest-calls.service';

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.css']
})
export class CheckInComponent implements OnInit {

  constructor(private restApiSrv:RestCallsService) { }

  ngOnInit(): void {
  }

  carServiceDetails:CarService = new CarService();
  isWheelAlignmentSelected:boolean = false;
  isGearCheckupSelected:boolean = false;
  isOilsCheckupSelected:boolean = false;

  additionalCheckUps:string[] = [];
  checkedInRespMsg : string = "";

  submitCheckIn() {
       this.additionalCheckUps = [];
       if(this.isWheelAlignmentSelected){
           this.additionalCheckUps.push("wheelALignment");
       }
       if(this.isGearCheckupSelected){
           this.additionalCheckUps.push("gearCheckUp");
       }
       if(this.isOilsCheckupSelected){
           this.additionalCheckUps.push("oilsCheckUp");
       }
       this.carServiceDetails.additionalCheckUps = this.additionalCheckUps;
      this.restApiSrv.checkInCarApi(this.carServiceDetails).subscribe(data=>{
           if(data.body){
 				this.checkedInRespMsg = "car checkedIn successfully with checkIn Id  : "+data.body;
 				this.carServiceDetails = new CarService();
           }else{
           		this.checkedInRespMsg = "car checkedIn Failure with msg "+data.errMsg;
           }
      })
  }

}
