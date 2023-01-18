package com.yena.test.jsp.dao;

import org.springframework.stereotype.Repository;

import com.yena.test.jsp.model.Realtor;

@Repository
public interface RealtorDAO {

	public int insertRealtorByObject(Realtor realtor);
}
