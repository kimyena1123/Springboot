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
	
}
