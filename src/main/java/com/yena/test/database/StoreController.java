package com.yena.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yena.test.database.bo.StoreBO;
import com.yena.test.database.model.Store;

//request를 전달받아서 처리하고
//response를 정돈해주는 역할
@Controller
public class StoreController {
	
	@Autowired
	private StoreBO storeBO;

	@ResponseBody
	@RequestMapping("/database/test01")
	public List<Store> storeResponse() {
		
		List<Store> storeList = storeBO.getStoreList();
		
		return storeList;
	}
}
