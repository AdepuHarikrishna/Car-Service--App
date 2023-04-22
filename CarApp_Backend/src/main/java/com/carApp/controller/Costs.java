package com.carApp.controller;

public enum Costs {
	
	serviceCharge(1000), wheelALignment(200), gearCheckUp(100), oilsCheckUp(200);

	private int amount;

	Costs(int amount) {
		this.setAmount(amount);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
