package com.yena.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.test.jsp.dao.SellerDAO;
import com.yena.test.jsp.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;

	//마지막 id만 보여준다.
	public Seller getSeller() {
		
		return sellerDAO.selectSeller();
	};
	
	//id를 파라미터로 받아 보여준다
	public Seller getSellerById(int id) {
		
		return sellerDAO.selectSellerById(id);
	}

	
	public int createSeller(
			String nickname
			,double temperature
			,String profileImgae) {
		
		return sellerDAO.insertSeller(nickname, temperature, profileImgae);
	};
}
