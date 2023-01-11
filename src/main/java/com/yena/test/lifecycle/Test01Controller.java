package com.yena.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test01Controller {

	@RequestMapping("/lifecycle/test01/1")
	public Map<String, Integer> mapResponse(){
		// key : 과목, value : 성적
		// 과목 : 성적
		Map<String, Integer> scoreMap = new HashMap<>();
		
		scoreMap.put("국어", 80);
		scoreMap.put("수학", 90);
		scoreMap.put("영어", 85);
		
		return scoreMap;
	}
}
