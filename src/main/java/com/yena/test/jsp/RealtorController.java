package com.yena.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yena.test.jsp.bo.RealtorBO;
import com.yena.test.jsp.model.Realtor;

@RequestMapping("/jsp/realtor")
@Controller
public class RealtorController {
	
	@Autowired
	private RealtorBO realtorBO;

	@GetMapping("/add")
	public String addRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade
			, Model model) {
		
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		realtorBO.addRealtorByObject(realtor);
		
		model.addAttribute("realtor", realtor);
		
		return "jsp/realtor";
		
	}
	
	//입력화면
	@GetMapping("/input")
	public String realtorInput() {
		return "jsp/realtorInput";
	}
}
