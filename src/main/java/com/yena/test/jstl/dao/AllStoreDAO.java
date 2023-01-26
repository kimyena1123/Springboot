package com.yena.test.jstl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.test.jstl.model.AllStore;
import com.yena.test.jstl.model.NewReview;

@Repository
public interface AllStoreDAO {

	//READ (select) - store 테이블 조회
	public List<AllStore> ReadStore();
	
	//READ (select) - new_review 테이블 조회
	public List<NewReview> ReadReview(@Param("storeId") int storeId);
}
