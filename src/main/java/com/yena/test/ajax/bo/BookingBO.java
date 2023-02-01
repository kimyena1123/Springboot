package com.yena.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.test.ajax.dao.BookingDAO;
import com.yena.test.ajax.model.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingDAO bookingDAO;
	
	//Read-select
	public List<Booking> readBooking() {
		List<Booking> bookingList = bookingDAO.readBooking();
		
		return bookingList;
	}
	
	//Create-insert
	public boolean createBooking(
			String name,String date,int day,
			int headcount, String phoneNumber) {
		
		int count = bookingDAO.createBooking(name, date, day, headcount, phoneNumber);
		
		//count가 1이면 insert 성공
		if(count == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	//delete
	public boolean deleteById(int id) {
		int count = bookingDAO.deleteById(id);
		
		//count가 1 이면 delete 성공
		if(count == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	//main창에서 예약 정보 조회
	public Booking checkByNameNumber(String name, String phoneNumber) {
		
		Booking booking = bookingDAO.checkByNameNumber(name, phoneNumber);
		return booking;
	}
	
	
	
	
	
	
	
	
	
	
}
