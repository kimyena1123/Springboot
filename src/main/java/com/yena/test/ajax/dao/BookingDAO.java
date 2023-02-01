package com.yena.test.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.test.ajax.model.Booking;

@Repository
public interface BookingDAO {

	//Read-select
	public List<Booking> readBooking();
	
	//Create-insert
	public int createBooking(
			@Param("name") String name
			,@Param("date") String date
			,@Param("day") int day
			,@Param("headcount") int headcount
			,@Param("phoneNumber") String phoneNumber);
	
	//delete
	public int deleteById(@Param("id") int id);
	
	//main창에서 예약정보 조회
	public List<Booking> checkByNameNumber(
			@Param("name") String name
			,@Param("phoneNumber") String phoneNumber);
	
}