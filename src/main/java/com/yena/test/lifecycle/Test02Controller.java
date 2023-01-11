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
public class Test02Controller {

	@RequestMapping("/lifecycle/test02/1")
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
	
	@RequestMapping("/lifecycle/test02/2")
	public List<Introduce> listClass(){
		
		List<Introduce> list = new ArrayList<>();
		
		Introduce info = new Introduce();
		info.setTitle("안녕하세요. 가입인사드립니다.");
		info.setUser("halgulu");
		info.setContent("안녕하세요. 가입했어요. 앞으로 잘부탁드립니다. 열심히 하겠습니다.");
		list.add(info);
		
		info = new Introduce();
		info.setTitle("헐 대박");
		info.setUser("bada");
		info.setContent("오늘 목요일이었어. 금요일인줄");
		list.add(info);
		
		info = new Introduce();
		info.setTitle("오늘 데이트 한 이야기 들려드릴게요");
		info.setUser("dulumary");
		info.setContent("....");
		list.add(info);
		
		return list;
	}
	
	@RequestMapping("/lifecycle/test02/3")
	public ResponseEntity<Introduce> entityResponse(){
		Introduce data = new Introduce();
		
		data.setTitle("안녕하세요. 가입인사드립니다.");
		data.setUser("halgulu");
		data.setContent("안녕하세요. 가입했어요. 앞으로 잘부탁드립니다. 열심히 하겠습니다.");
	
		ResponseEntity<Introduce> entity = new ResponseEntity(data, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
}
