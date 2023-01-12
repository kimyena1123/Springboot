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
public class Test02Controller_T {

	@RequestMapping("/lifecycle/test02_T/1")
	public List<Map<String, Object>> listMapResponse() {
		
		List<Map<String, Object>> movieList = new ArrayList<>();
	
		Map<String, Object> movie = new HashMap<>();
		movie.put("title", "기생충");
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("rate", 15);
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 0);
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("title", "인생은 아름다워");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 12);
		movie.put("director", "크리스토퍼 놀란");
		movie.put("time", 147);
		movie.put("title", "인셉션");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 19);
		movie.put("director", "윤종빈");
		movie.put("time", 133);
		movie.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("director", "프란시스 로렌스");
		movie.put("time", 137);
		movie.put("title", "헝거게임");
		movieList.add(movie);
		
		return movieList;
	}
	
	@RequestMapping("/lifecycle/test02_T/2")
	public List<Introduce> listClassResponse(){
		
		List<Introduce> list = new ArrayList<>();
		
		Introduce post = new Introduce();
		post.setTitle("안녕하세요. 가입인사드립니다.");
		post.setUser("halgulu");
		post.setContent("안녕하세요. 가입했어요. 앞으로 잘부탁드립니다. 열심히 하겠습니다.");
		list.add(post);
		
		post = new Introduce();
		post.setTitle("헐 대박");
		post.setUser("bada");
		post.setContent("오늘 목요일이었어. 금요일인줄");
		list.add(post);
		
		post = new Introduce();
		post.setTitle("오늘 데이트 한 이야기 들려드릴게요");
		post.setUser("dulumary");
		post.setContent("....");
		list.add(post);
		
		return list;
	}
	
	@RequestMapping("/lifecycle/test02_T/3")
	public ResponseEntity<Introduce> entityReponse(){
		Introduce data = new Introduce();
		
		data.setTitle("안녕하세요. 가입인사드립니다.");
		data.setUser("halgulu");
		data.setContent("안녕하세요. 가입했어요. 앞으로 잘부탁드립니다. 열심히 하겠습니다.");
	
		ResponseEntity<Introduce> entity = new ResponseEntity(data, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	
	
	
}