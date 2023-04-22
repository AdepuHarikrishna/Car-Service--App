package com.carApp.repository;

import java.util.Date;
import java.util.List;

import com.carApp.pojo.CarService;
import com.carApp.pojo.CarUser;
import com.carApp.pojo.Dashboard;
import com.carApp.pojo.Slot;

public interface CarRepo {
	
	int registerUser(CarUser carUserObj);
	
	int logInCarUser(CarUser carUserObj);
	
	CarUser getCarUser(String userName, String password);
	
	int checkAvailability(Date inputDate);
	
	int bookASlot(Slot slot);
	
	int checkInCar(CarService carService);
	
	List<Dashboard> displayDashboard();
	
	CarService getServiceDetails(int checkInId);
	
	int updateBillInService(int checkInId, int amount);
	
	int updatePayBill(int checkInId);


}
