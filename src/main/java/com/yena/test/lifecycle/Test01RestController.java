package com.yena.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yena.test.lifecycle.model.Introduce;

@RestController
@RequestMapping("/lifecycle/test01")
public class Test01RestController {

	@RequestMapping("/1")
	public Map<String, Integer> mapResponse(){
		// key : 과목, value : 성적
		// 과목 : 성적
		Map<String, Integer> scoreMap = new HashMap<>();
		
		scoreMap.put("국어", 80);
		scoreMap.put("수학", 90);
		scoreMap.put("영어", 85);
		
		return scoreMap;
	}
	
	@RequestMapping("/2")
	public List<Map<String, Object>> listMapResponse(){
		
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("rate", 15);
		map1.put("director", "봉준호");
		map1.put("time", 131);
		map1.put("title", "기생충");
		listMap.add(map1);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("rate", 0);
		map2.put("director", "로베르토 베니니");
		map2.put("time", 116);
		map2.put("title", "인생은 아름다워");
		listMap.add(map2);
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("rate", 12);
		map3.put("director", "크리스토퍼 놀란");
		map3.put("time", 147);
		map3.put("title", "인셉션");
		listMap.add(map3);
		
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("rate", 19);
		map4.put("director", "윤종빈");
		map4.put("time", 133);
		map4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		listMap.add(map4);
		
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("rate", 15);
		map5.put("director", "프란시스 로렌스");
		map5.put("time", 137);
		map5.put("title", "헝거게임");
		listMap.add(map5);
		
		return listMap;
	}
	
	//@RequestMapping("/3")
	//list, class를 설계해서 json 출력하는 메소드.
}
