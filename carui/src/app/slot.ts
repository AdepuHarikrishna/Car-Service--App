export class Slot {

	serviceId:number;
	serviceDate:string;
	status:string;
	vehicleNo:string;

	constructor(serviceId:number = 0, serviceDate:string = "", status:string = "", vehicleNo:string = "") {
	    this.serviceId = serviceId;
	    this.serviceDate = serviceDate;
	    this.status = status;
	    this.vehicleNo = vehicleNo;
	}

}
