package com.carApp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.carApp.pojo.Slot;

public class SlotRowMapper implements RowMapper<Slot> {

	public Slot mapRow(ResultSet rs, int rowNum) throws SQLException {

		Slot slotObj = new Slot();
		slotObj.setServiceId(rs.getInt(1));
		slotObj.setServiceDate(rs.getDate(2).toString());
		slotObj.setStatus(rs.getString(3));
		slotObj.setVehicleNo(rs.getString(4));
		
		return slotObj;
	}

}
