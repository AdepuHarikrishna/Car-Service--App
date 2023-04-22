package com.carApp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carApp.pojo.CarService;
import com.carApp.pojo.CarUser;
import com.carApp.pojo.Dashboard;
import com.carApp.pojo.ResponseEntity;
import com.carApp.pojo.Slot;
import com.carApp.service.ICarService;

@RestController
@RequestMapping(value = "/carApp")
public class CarController {

	@Autowired
	private ICarService service;

	public void setService(ICarService service) {
		this.service = service;
	}

	// 
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/checkSlot", method = RequestMethod.POST)
	public   ResponseEntity checkAvailibility(@RequestBody String date) throws ParseException {
		System.out.println("date received is " + date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateInUtil = sdf.parse(date);
		boolean result = service.checkAvailability(dateInUtil);
		ResponseEntity resp = new ResponseEntity(200, result, "");
		return resp;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/bookSlot", method = RequestMethod.POST)
	public   ResponseEntity bookASlot(@RequestBody Slot slot) throws ParseException {

		System.out.println("book slot rest api - "+slot);
		int result = service.bookASlot(slot);
		ResponseEntity resp = new ResponseEntity(200, result, "");
		return resp;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/checkIn", method=RequestMethod.POST)
	public ResponseEntity checkInCar(@RequestBody CarService carService) {
		System.out.println("checkin car web service called with input "+carService);
		int checkInId = service.checkInCar(carService);
		return new ResponseEntity(200, checkInId, "");
	}

	@CrossOrigin(origins = "http://localhost:4200") 
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public   ResponseEntity displayDashboard() {
		List<Dashboard> dashboards = service.displayDashboard();
		ResponseEntity resp = new ResponseEntity(200, dashboards, "");
		return resp;
	}

	 


}
