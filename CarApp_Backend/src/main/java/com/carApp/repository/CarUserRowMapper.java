package com.carApp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.carApp.pojo.CarUser;

public class CarUserRowMapper implements RowMapper<CarUser> {

	@Override
	public CarUser mapRow(ResultSet rs, int arg1) throws SQLException {

		return new CarUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

	}

}
