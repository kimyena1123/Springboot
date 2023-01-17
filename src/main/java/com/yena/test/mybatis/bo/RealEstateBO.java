package com.yena.test.mybatis.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.test.mybatis.dao.RealEstateDAO;
import com.yena.test.mybatis.model.RealEstate;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateDAO realEstateDAO;

	//전달받은 id 데이터 조회 리턴
	public RealEstate getRealEstate(int id) {
		//DAO 안에 있는 메소드 호출.
		RealEstate realEstate = realEstateDAO.selectRealEstate(id);
		
		return realEstate;
	}
	
	
	//전달받은 월세보다 낮은 매물 리스트 리턴
	public List<RealEstate> getRealEstateListByRent(int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateDAO.selectRealEstateListByRent(rentPrice);
		
		return realEstateList;
	}
	
	
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price){
		
		return realEstateDAO.selectRealEstateListByAreaPrice(area, price);
	}
	
	//####################INSERT##############################
	public int addRealEstateByObject(RealEstate realEstate) {
		
		return realEstateDAO.insertRealEstateByObject(realEstate);
	}
	
	//매개변수: 다 전달받아야 함
	public int newRealEstate(int realtorId, String address, int area, String type, int price, int rentPrice) {
		
		return realEstateDAO.insertRealEstate(realtorId, address, area, type, price, rentPrice);
	}
	
	//####################UPDATE##################
	//변경할 대상 id, 변강할 type, 변경할 price
	public int updateRealEstate(int id, String type, int price) {
		
		return realEstateDAO.updateRealEstate(id, type, price);
	}
	
	//##################DELETE#######################
	
	//몇 행이 삭제되었는지 return해주기에 return 타입이 int
	public int destroyRealEstate(int id) {
		return realEstateDAO.destroyRealEstate(id);
	}
	
	
	
	
	
	
	
	
	
}
