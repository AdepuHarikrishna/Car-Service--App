package com.carApp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.carApp.pojo.CarService;

public class CarServiceRowMapper implements RowMapper<CarService> {

	public CarService mapRow(ResultSet rs, int rowNum) throws SQLException {
		CarService cs = new CarService();
		cs.setCheckInId(rs.getInt(1));
		cs.setServiceId(rs.getInt(2));
		cs.setComplaints(rs.getString(3));
		cs.setAdditionalCheckUps(rs.getString(4).split(","));
		cs.setCheckInDate(rs.getString(5));
		cs.setBill(rs.getInt(6));
		cs.setCheckOutDate(rs.getString(7));
		
		return cs;
	}
	
	

}
