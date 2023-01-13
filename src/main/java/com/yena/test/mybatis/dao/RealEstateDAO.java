package com.yena.test.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.test.mybatis.model.RealEstate;

@Repository
public interface RealEstateDAO {

	//조회하는 결과가 "한 행"이다.
	//한 행의 정보를 저장하기 위해서 => class => model/RealEstate
	public RealEstate selectRealEstate(@Param("id") int id);
	
	//public RealEstate selectRentPrice(@Param("rent") int rent);
	public List<RealEstate> selectRealEstateListByRent(@Param("rentPrice") int rentPrice);

	public List<RealEstate> selectRealEstateListByAreaPrice(
			@Param("area") int area, 
			@Param("price") int price);
	
	//#################INSERT########################
	public int insertRealEstateByObject(RealEstate realEstate);

	public int insertRealEstate(
			@Param("realtorId") int realtorId
			,@Param("address") String address
			,@Param("area") int area
			,@Param("type") String type
			,@Param("price") int price
			,@Param("rentPrice") int rentPrice);
	
}
