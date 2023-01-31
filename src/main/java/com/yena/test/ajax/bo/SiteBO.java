package com.yena.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.test.ajax.dao.SiteDAO;
import com.yena.test.ajax.model.Site;

@Service
public class SiteBO {
	@Autowired
	private SiteDAO siteDAO;

	//Read - select
	public List<Site> ReadSite(){
		List<Site> siteList = siteDAO.ReadSite();
		
		return siteList;
	}
	
	//Create - insert
	public int CreateSite(String name, String url) {
		return siteDAO.CreateSite(name, url);
	}
	
	
	//url 중복 여부 확인
	public boolean checkUrl(String url) {
		int count = siteDAO.checkCountUrl(url);
		
		//count가 0이면 중복 없음
		if(count == 0) {
			return false; // 중복 아님
		}else {
			return true; // 중복임
		}
	}
	
	public int destroyById(int id) {
		return siteDAO.destoryById(id);
	}
}
