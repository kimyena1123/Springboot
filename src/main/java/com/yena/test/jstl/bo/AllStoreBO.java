package com.yena.test.jstl.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.test.jstl.dao.AllStoreDAO;
import com.yena.test.jstl.model.AllStore;
import com.yena.test.jstl.model.NewReview;

@Service
public class AllStoreBO {
	@Autowired
	private AllStoreDAO storeDAO;

	//READ (select) - store 테이블 조회
	public List<AllStore> ReadStore(){
		List<AllStore> storeList = storeDAO.ReadStore();
		
		return storeList;
	}
	
	//READ (select) - new_review 테이블 조회
	public List<NewReview> ReadReview(int storeId){
		List<NewReview> reviewList = storeDAO.ReadReview(storeId);
		
		return reviewList;
	}
}
