package com.carApp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carApp.controller.Costs;
import com.carApp.pojo.CarService;
import com.carApp.pojo.CarUser;
import com.carApp.pojo.Dashboard;
import com.carApp.pojo.Slot;
import com.carApp.repository.CarRepo;

@Service
public class CarServiceImpl implements ICarService {
	
	@Autowired
	private CarRepo carRepo;
	public void setCarRepo(CarRepo carRepo) {
		this.carRepo = carRepo;
	}	

	public boolean registerCar(CarUser user) {
		
		int result = carRepo.registerUser(user);
		if(result != 0) {
			return true;
		}else {
			return false;
		}
	}

	public CarUser logInCarUser(CarUser carUser) {
		int result = carRepo.logInCarUser(carUser);
		if (result != 0) {
			return carRepo.getCarUser(carUser.getUserName(),  carUser.getPassword());
		} else {
			return null;
		}
	}
	
	public boolean checkAvailability(Date inputDate) {
		int count = carRepo.checkAvailability(inputDate);
		if (count >= 5) {
			return false;
		} else {
			return true;
		}
	}	

	
	public int bookASlot(Slot slot) {
		
		int result = carRepo.bookASlot(slot);
		return result;
	}

	public List<Dashboard> displayDashboard() {
		return carRepo.displayDashboard();
	}
	
	public int generateBill(int checkInId) {
		
		CarService cs = carRepo.getServiceDetails(checkInId);
		int serviceBill = Costs.serviceCharge.getAmount();
		for(String s : cs.getAdditionalCheckUps()) {
			switch(s) {
				case "wheelALignment" : 
					serviceBill = serviceBill + Costs.wheelALignment.getAmount();
					break;
				case "gearCheckUp" :
					serviceBill = serviceBill + Costs.gearCheckUp.getAmount();
					break;
				case "oilsCheckUp" :
					serviceBill = serviceBill + Costs.oilsCheckUp.getAmount();
					break;
			}
		}
		carRepo.updateBillInService(checkInId, serviceBill);
		return serviceBill;
	}
	
	@Override
	public int checkInCar(CarService carService) {

		int result = carRepo.checkInCar(carService);
		
		return result;
	}
	
	public String updatePayBill(int checkInId) {
		int result = carRepo.updatePayBill(checkInId);
		return (result != 0) ? "success" : "failure";
	}
	
	
}
	
