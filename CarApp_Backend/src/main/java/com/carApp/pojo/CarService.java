package com.carApp.pojo;

import java.util.Arrays;

public class CarService {
	private int checkInId;
	private int serviceId;
	private String complaints;
	private String[] additionalCheckUps;
	private String checkInDate;
	private int bill;
	private String checkOutDate;
	
	public CarService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCheckInId() {
		return checkInId;
	}

	public void setCheckInId(int checkInId) {
		this.checkInId = checkInId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public String[] getAdditionalCheckUps() {
		return additionalCheckUps;
	}

	public void setAdditionalCheckUps(String[] additionalCheckUps) {
		this.additionalCheckUps = additionalCheckUps;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public CarService(int checkInId, int serviceId, String complaints, String[] additionalCheckUps, String checkInDate,
			int bill, String checkOutDate) {
		super();
		this.checkInId = checkInId;
		this.serviceId = serviceId;
		this.complaints = complaints;
		this.additionalCheckUps = additionalCheckUps;
		this.checkInDate = checkInDate;
		this.bill = bill;
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "CarService [checkInId=" + checkInId + ", serviceId=" + serviceId + ", complaints=" + complaints
				+ ", additionalCheckUps=" + additionalCheckUps + ", checkInDate=" + checkInDate + ", bill=" + bill
				+ ", checkOutDate=" + checkOutDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(additionalCheckUps);
		result = prime * result + bill;
		result = prime * result + ((checkInDate == null) ? 0 : checkInDate.hashCode());
		result = prime * result + checkInId;
		result = prime * result + ((checkOutDate == null) ? 0 : checkOutDate.hashCode());
		result = prime * result + ((complaints == null) ? 0 : complaints.hashCode());
		result = prime * result + serviceId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarService other = (CarService) obj;
		if (!Arrays.equals(additionalCheckUps, other.additionalCheckUps))
			return false;
		if (bill != other.bill)
			return false;
		if (checkInDate == null) {
			if (other.checkInDate != null)
				return false;
		} else if (!checkInDate.equals(other.checkInDate))
			return false;
		if (checkInId != other.checkInId)
			return false;
		if (checkOutDate == null) {
			if (other.checkOutDate != null)
				return false;
		} else if (!checkOutDate.equals(other.checkOutDate))
			return false;
		if (complaints == null) {
			if (other.complaints != null)
				return false;
		} else if (!complaints.equals(other.complaints))
			return false;
		if (serviceId != other.serviceId)
			return false;
		return true;
	}
	
	
	
}
