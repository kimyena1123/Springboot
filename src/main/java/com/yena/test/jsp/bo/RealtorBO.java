package com.yena.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.test.jsp.dao.RealtorDAO;
import com.yena.test.jsp.model.Realtor;

@Service
public class RealtorBO {
	
	@Autowired
	private RealtorDAO realtorDAO;

	public int addRealtorByObject(Realtor realtor) {
		return realtorDAO.insertRealtorByObject(realtor);
	}
}
