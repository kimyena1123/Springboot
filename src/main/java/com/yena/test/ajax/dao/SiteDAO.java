package com.yena.test.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.test.ajax.model.Site;

@Repository
public interface SiteDAO {

	//Read - select
	public List<Site> ReadSite();
	
	//Create - insert
	public int CreateSite(@Param("name") String name
						, @Param("url") String url);

	
	//url 중복 여부 검사
	public int checkCountUrl(@Param("url") String url);

	//사용자가 원하는 id의 내용 삭제
	public int destoryById(@Param("id") int id);
}
