import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { RestCallsService } from '../rest-calls.service';
import { Router }  from '@angular/router';
import { DataCarrierService } from '../data-carrier.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private srv:RestCallsService, private routerVar:Router, private dataSrv: DataCarrierService) { }

  ngOnInit(): void {
  }

  userObj:User = new User();

  loginErrMsg:string = "";

  validateLogin(){
       this.srv.validateLogin(this.userObj).subscribe(data => {
            var user = data.body;
            
            if(user == null){
              this.userObj = new User();
              this.loginErrMsg = "Invalid Credentials";
            }else{                          
              this.dataSrv.setLoggedInUser(data.body);
              this.routerVar.navigate(['/base']);
            }
      });
   }


}
