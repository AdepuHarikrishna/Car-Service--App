export class User {

	 userId:number;
	 userName:string;
	 password:string;
	 gender:string;
	 mobile:string;
	 vehicleNo:string;
	
    constructor(userId:number=0, userName:string="", password:string="", 
    gender:string="", mobile:string="", vehicleNo:string=""){
          this.userId = userId;
          this.userName = userName;
          this.password = password;
          this.gender = gender;
          this.mobile = mobile;
          this.vehicleNo = vehicleNo;
    }


}
