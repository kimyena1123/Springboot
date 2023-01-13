package com.yena.test.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.test.database.dao.StoreDAO;
import com.yena.test.database.model.Store;

@Service
public class StoreBO {
	
	@Autowired
	//필요한 객체를 변수형태로 만들어준다.
	private StoreDAO storeDAO;
	
	//store테이블의 데이터를 조회하고 리턴하는 메소드
	public List<Store> getStoreList() {
		//DAO가 list 형태 -> public List<Store> selectStoreList();

		//List 형태의 Store를 리턴한다.
		List<Store> storeList = storeDAO.selectStoreList();
	
		return storeList;
	}
}
