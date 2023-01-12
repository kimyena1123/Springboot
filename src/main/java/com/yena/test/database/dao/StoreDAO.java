package com.yena.test.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yena.test.database.model.Store;

//데이터베이스 조회
@Repository
public interface StoreDAO {

	//store 테이블 전체 조회
	// => mappers.store.xml
	//실행할 쿼리를 xml을 통해서 한다.
	//selectStoreList 했을 때 실행될 쿼리 -> xml
	public List<Store> selectStoreList();
}
