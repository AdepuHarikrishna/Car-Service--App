import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from "@angular/router";

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { BaseComponent } from './base/base.component';
import { RestCallsService } from './rest-calls.service';
import { SlotComponent } from './slot/slot.component';
import { CheckInComponent } from './check-in/check-in.component';
import { DashboardCompComponent } from './dashboard-comp/dashboard-comp.component';
import { BillComponent } from './bill/bill.component';
import { DataCarrierService } from './data-carrier.service';

const routes: Routes = [
   
   {
       path:'', pathMatch: 'full', redirectTo: 'login'
   },
   {
       path:'*', pathMatch: 'full', redirectTo: 'login'
   },
   {
       path:'login', component: LoginComponent
   },
   {
       path:'base', 
       component:BaseComponent,
       children: [        
        { path: 'home', component: HomeComponent },
        { path: 'bookslot', component: SlotComponent},
        { path: 'checkIn', component: CheckInComponent},
        { path: 'dashboard', component: DashboardCompComponent},
        { path: 'bill', component: BillComponent}

    ]
   },
   { path: 'logout', component: LoginComponent}

];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    BaseComponent,
    SlotComponent,
    CheckInComponent,
    DashboardCompComponent,
    BillComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, RouterModule.forRoot(routes)
  ],
  providers: [RestCallsService, DataCarrierService],
  bootstrap: [AppComponent]
})
export class AppModule { }
