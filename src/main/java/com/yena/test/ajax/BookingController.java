package com.yena.test.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yena.test.ajax.bo.BookingBO;
import com.yena.test.ajax.model.Booking;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;
	
	//main 창
	@GetMapping("/main")
	public String main() {
		return "/ajax/booking/main";
	}
	
	//input 창
	@GetMapping("/input")
	public String input() {
		return "/ajax/booking/input";
	}

	//Read-select
	@GetMapping("/list")
	public String readBooking(Model model) {
		List<Booking> bookingList = bookingBO.readBooking();
		
		model.addAttribute("bookingList", bookingList);
		return "/ajax/booking/list";
	}
	
	//Create-insert
	@ResponseBody
	@GetMapping("/create")
	public Map<String, Boolean> createBooking(
			@RequestParam("name") String name
			,@RequestParam("date") String date
			,@RequestParam("day") int day
			,@RequestParam("headcount") int headcount
			,@RequestParam("phoneNumber") String phoneNumber){
		
		Map<String, Boolean> result = new HashMap<>();
		
		//true라면 insert 성공
		//false라면 insert 실패
		if(bookingBO.createBooking(name, date, day, headcount, phoneNumber)) {
			result.put("result", true);
		}else {
			result.put("result", false);
		}
		
		return result;
	}
	
	//delete
	@ResponseBody
	@PostMapping("/deleteById")
	public Map<String, Boolean> deleteById(@RequestParam("id") int id){
		
		Map<String, Boolean> result = new HashMap<>();
		
		//true이면 delete 성공
		//false이면 delete 실패
		if(bookingBO.deleteById(id)) {
			result.put("delresult", true);
		}else {
			result.put("delresult", false);
		}
		
		return result;
	}
	

	//예약한 거 조회하기
	//사용자가 입력한 값을 보기(Select)
	//사용자가 입력한 정보-> 이름과 전화번호가 같으면 예약한 정보 alert 창 띄우기
	//다르면 조회 정보 결과 없음이라고 alert창 띄우기
	//테이블(DB)에 저장된 이름과 전화번호 값이 사용자가 입력한 값(input value)과 같은지 비교
	//select * from `booking` where name = #{name} AND phoneNumber = #{phoneNumber} LIMIT 1
	@ResponseBody
	@PostMapping("/reservatoinCheck")
	public List<Booking> checkByNameNumber(
			@RequestParam("name") String name
			,@RequestParam("phoneNumber") String phoneNumber
			,Model model){
		
		List<Booking> info = bookingBO.checkByNameNumber(name, phoneNumber);
		
		
		return info;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
