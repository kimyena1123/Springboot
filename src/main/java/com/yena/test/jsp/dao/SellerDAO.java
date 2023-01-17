package com.yena.test.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.test.jsp.model.Seller;

@Repository
public interface SellerDAO {

	public Seller selectLastSeller(); // 한 행만.
	public Seller selectSellerById(@Param("id") int id);
	
	public int insertSeller(
			@Param("nickname") String nickname
			,@Param("temperature") double temperature
			, @Param("profileImgae") String profileImgae);
}
