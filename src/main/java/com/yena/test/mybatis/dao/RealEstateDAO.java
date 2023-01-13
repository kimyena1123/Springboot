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

}
