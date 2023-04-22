package com.carApp.service;

import java.util.Date;
import java.util.List;

import com.carApp.pojo.CarService;
import com.carApp.pojo.CarUser;
import com.carApp.pojo.Dashboard;
import com.carApp.pojo.Slot;

public interface ICarService {

	boolean registerCar(CarUser user);
	
	CarUser logInCarUser(CarUser carUser);
	
	boolean checkAvailability(Date inputDate);
	
	int bookASlot(Slot slot);
	
	int checkInCar(CarService carService);
	
	List<Dashboard> displayDashboard();
	
	int generateBill(int checkInId);
	
	String updatePayBill(int checkInId);

}
