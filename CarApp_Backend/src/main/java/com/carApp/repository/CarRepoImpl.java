package com.carApp.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.carApp.pojo.CarService;
import com.carApp.pojo.CarUser;
import com.carApp.pojo.Dashboard;
import com.carApp.pojo.Slot;

@Repository
public class CarRepoImpl implements CarRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int registerUser(CarUser carUserObj) {
		String query = "insert into car_user(userName, password, gender, mobile, vehicleNo)"
				+ " values( ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(query, new Object[] { carUserObj.getUserName(), carUserObj.getPassword(),
				carUserObj.getGender(), carUserObj.getMobile(), carUserObj.getVehicleNo() });
		return result;
	}

	public int logInCarUser(CarUser carUserObj) {
		String query = "select count(*) from car_user where userName = ? and password = ?";
		int result = jdbcTemplate.queryForObject(query,
				new Object[] { carUserObj.getUserName(), carUserObj.getPassword() }, Integer.class);
		return result;
	}
	
	public CarUser getCarUser(String userName, String password) {
		 String query = "select * from car_user where userName = ?  and password = ?";
		 CarUser user = jdbcTemplate.queryForObject(query,  new Object[] {userName, password}, new CarUserRowMapper());
		 return user;
	}

	public int checkAvailability(Date inputDate) {
		java.sql.Date dateInSql = new java.sql.Date(inputDate.getTime());
		String query = "select count(*) from slot_info where serviceDate = ?";
		int result = jdbcTemplate.queryForObject(query, new Object[] { dateInSql }, Integer.class);
		return result;
	}

	public int bookASlot(Slot slot) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateInUtil = null;
		try {
			dateInUtil = sdf.parse(slot.getServiceDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
		java.sql.Date dateInSql = new java.sql.Date(dateInUtil.getTime());
		String query = "insert into slot_info(serviceDate, status, vehicleNo)" + " values( ?, ?, ?)";
		 jdbcTemplate.update(query, new Object[] { dateInSql, "booked", slot.getVehicleNo() });
		String slotIdQuery  = "select max(serviceId) from slot_info";
		int result = jdbcTemplate.queryForObject(slotIdQuery, Integer.class); 
		return result;
	}

	public List<Dashboard> displayDashboard() {
		String query = "select  srv.checkInId, sl.serviceDate, u.vehicleNo," + 
				" u.userName, u.mobile, sl.status,  srv.checkIn, srv.checkOut  from " + 
				" car_service srv join slot_info sl on srv.serviceId = sl.serviceId " + 
				"    join car_user u on sl.vehicleNo = u.vehicleNo";
		List<Dashboard> dashboards = jdbcTemplate.query(query, new DashBoardRowMapper() );
		return dashboards;
	}
	
	public CarService getServiceDetails(int checkInId) {
		String query = "select * from car_service where checkInId = ?";
		return jdbcTemplate.queryForObject(query,  new Object[] {checkInId}, new CarServiceRowMapper());	
	}

	

	@Override
	public int checkInCar(CarService carService) {
        StringBuffer additional = new StringBuffer();
        System.out.println("in repo "+carService.getAdditionalCheckUps().toString());
        Arrays.asList(carService.getAdditionalCheckUps()).stream().forEach(x -> additional.append(x+","));
		for(String s : carService.getAdditionalCheckUps()) {
			System.out.println(s);
		}
		String temp = additional.substring(0, additional.length()-1);
		String query = "insert into car_service(serviceId, complaints, additionalCheckUps, checkIn, checkout)" + 
				" values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {carService.getServiceId(), carService.getComplaints(), 
				temp, carService.getCheckInDate(), carService.getCheckOutDate()});
		String checkInIdQuery = "select max(checkInId) from car_service";
		Integer checkInId = jdbcTemplate.queryForObject(checkInIdQuery, Integer.class);
		return checkInId;
	}
	
	public int updateBillInService(int checkInId, int amount) {
		String query = "update car_service set bill = ? where checkInId = ?";
		int result =jdbcTemplate.update(query, new Object[] {amount, checkInId});
		return result;
	}
	
	public int updatePayBill(int checkInId) {
		String query = "update slot_info set status = 'CLOSED' where serviceId = (select serviceId from car_service where checkInId=?)";
		return jdbcTemplate.update(query, new Object[] {checkInId});
	}
	
}
