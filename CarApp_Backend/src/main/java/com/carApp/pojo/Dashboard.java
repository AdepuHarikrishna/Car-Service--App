package com.carApp.pojo;

import java.sql.Date;

public class Dashboard {

	private int checkInId;
	private Date serviceDate;
	private String vehicleNumber;
	private String userName;
	private String mobile;
	private String status;
	private String checkIn;
	private String checkOut;

	public Dashboard() {
		super();
	}

	public Dashboard(int checkInId, Date serviceDate, String vehicleNumber, String userName, String mobile,
			String status, String checkIn, String checkOut) {
		super();
		this.checkInId = checkInId;
		this.serviceDate = serviceDate;
		this.vehicleNumber = vehicleNumber;
		this.userName = userName;
		this.mobile = mobile;
		this.status = status;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getCheckInId() {
		return checkInId;
	}

	public void setCheckInId(int checkInId) {
		this.checkInId = checkInId;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Dashboard [checkInId=" + checkInId + ", serviceDate=" + serviceDate + ", vehicleNumber=" + vehicleNumber
				+ ", userName=" + userName + ", mobile=" + mobile + ", status=" + status + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + "]";
	}

}
