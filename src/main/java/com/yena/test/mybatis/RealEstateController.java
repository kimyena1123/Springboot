package com.yena.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yena.test.mybatis.bo.RealEstateBO;
import com.yena.test.mybatis.model.RealEstate;

@Controller
@RequestMapping("/mybatis/test01")
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	//id를 request 파라미터로 전달받고,
	//조회 결과를 json으로 response에 담는다.
	@ResponseBody
	@RequestMapping("/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		RealEstate realEstate = realEstateBO.getRealEstate(id);
		
		return realEstate;
	}
	
	//전달받은 월세보다 낮은 매물 리스트 json으로 response 담는다.
	@ResponseBody
	@RequestMapping("/2")
	public List<RealEstate> realEstateByRent(@RequestParam("rent") int rentPrice) { // 파리미터 이름, 변수 이름
		List<RealEstate> realEstateList = realEstateBO.getRealEstateListByRent(rentPrice);
		
		return realEstateList;
	}
	
	
	//넓이와 매매 가격을 전달받고, 이에 상응하는 리스트를 json으로 response에 담는다.
	@ResponseBody
	@RequestMapping("/3")
	public List<RealEstate> realEstateByAreaPrice(
			@RequestParam("area") int area 
			,@RequestParam("price") int price) {
		
		return realEstateBO.getRealEstateListByAreaPrice(area, price);
		 
	}
	
//##################INSERT##########################
	@ResponseBody
	@RequestMapping("/4")
	public String addRealEstate() {
		
		RealEstate addRealEstate = new RealEstate();
		
		addRealEstate.setRealtorId(3);
		addRealEstate.setAddress("푸르지용 303동 1104호");
		addRealEstate.setArea(89);
		addRealEstate.setType("매매");
		addRealEstate.setPrice(1000000);
		addRealEstate.setRentPrice(0);
		
		int count = realEstateBO.addRealEstateByObject(addRealEstate);
		
		return "Test01 insert 결과 >> " + count;
	}
	
	
	@ResponseBody
	@RequestMapping("/5")
	public String newRealEstate(@RequestParam("realtorId") int realtorId) {
		
		int count = realEstateBO.newRealEstate(realtorId,"썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
	
		return "field로 insert >> " + count;
	}
}
