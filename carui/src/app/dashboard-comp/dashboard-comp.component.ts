import { Component, OnInit } from '@angular/core';
import { Dashboard } from '../dashboard';
import { RestCallsService } from '../rest-calls.service';

@Component({
  selector: 'app-dashboard-comp',
  templateUrl: './dashboard-comp.component.html',
  styleUrls: ['./dashboard-comp.component.css']
})
export class DashboardCompComponent implements OnInit {

  constructor(private restCalls:RestCallsService) { }

  ngOnInit(): void {
   this.restCalls.displayDashBoardApi().subscribe(data => {
      this.dashBoardData = data.body;
  })

  }

  dashBoardData:Dashboard[] = [];

 
}
