package com.carApp.service;

public enum BillInfo {
	
	SERVICE_CHARGE(100),
	ENGINEOIL_CHANGE(150),
	WHEEL_ALIGNMENT(200),
	WATER_WASH(100);
	
	int amount;
	
	BillInfo(int amount){
		this.amount = amount;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name();
	}

}
