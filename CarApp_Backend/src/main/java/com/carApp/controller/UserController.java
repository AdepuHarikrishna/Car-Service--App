package com.carApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carApp.pojo.CarUser;
import com.carApp.pojo.ResponseEntity;
import com.carApp.service.ICarService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private ICarService service;

	public void setService(ICarService service) {
		this.service = service;
	}

//	 
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public   ResponseEntity registerCarUser(@RequestBody CarUser carUser) {
		System.out.println("input received is "+carUser);
		boolean result = service.registerCar(carUser);
		ResponseEntity resp = new ResponseEntity(200, result, "");
		return resp;
	}

//	 
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public   ResponseEntity logInCarUser(@RequestBody CarUser carUser) {
		System.out.println("input received is "+carUser);
		CarUser user = service.logInCarUser(carUser);
		ResponseEntity resp = new ResponseEntity(200, user, "");
		return resp;
	}
	
}
