package com.carApp.pojo;

import java.sql.Date;

public class Slot {
	private int serviceId;
	private String serviceDate;
	private String status;
	private String vehicleNo;
	
	public Slot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Slot(int serviceId, String serviceDate, String status, String vehicleNo) {
		super();
		this.serviceId = serviceId;
		this.serviceDate = serviceDate;
		this.status = status;
		this.vehicleNo = vehicleNo;
	}

	@Override
	public String toString() {
		return "Slot [serviceId=" + serviceId + ", serviceDate=" + serviceDate + ", status=" + status
				+ ", vehicleNo=" + vehicleNo + "]";
	}

	
	
}


