export class CarService {

    checkInId:number;
	serviceId:number;
	complaints:string;
	additionalCheckUps:string[];
	checkInDate:string;
	bill:number;
	checkOutDate:string;

	constructor(checkInId:number = 0, serviceId:number=0, complaints:string="", additionalCheckUps:string[] = [], checkInDate:string = "", bill:number=0, checkOutDate:string = ""){
	    this.checkInId = checkInId;
	    this.serviceId = serviceId;
	    this.complaints = complaints;
	    this.additionalCheckUps = additionalCheckUps;
	    this.checkInDate = checkInDate;
	    this.bill = bill;
	    this.checkOutDate = checkOutDate;
	}

}
