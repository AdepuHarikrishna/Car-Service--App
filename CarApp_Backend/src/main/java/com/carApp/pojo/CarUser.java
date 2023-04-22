package com.carApp.pojo;

public class CarUser {
	
	private int userId;
	private String userName;
	private String password;
	private String gender;
	private String mobile;
	private String vehicleNo;
	
	public CarUser() {
		super();
	}

	public CarUser(int userId, String userName, String password, String gender, String mobile, String vehicleNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.mobile = mobile;
		this.vehicleNo = vehicleNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	@Override
	public String toString() {
		return "CarUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", gender=" + gender
				+ ", mobile=" + mobile + ", vehicleNo=" + vehicleNo + "]";
	}
	
	
	

	
}
