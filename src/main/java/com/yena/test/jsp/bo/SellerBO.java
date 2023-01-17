package com.yena.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.test.jsp.dao.SellerDAO;
import com.yena.test.jsp.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;

	public Seller getSeller() {
		
		return sellerDAO.selectSeller();
	};
	
	public int createSeller(
			String nickname
			,double temperature
			,String profileImgae) {
		
		return sellerDAO.insertSeller(nickname, temperature, profileImgae);
	};
}
