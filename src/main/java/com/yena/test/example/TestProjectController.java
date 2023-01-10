package com.yena.test.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestProjectController {

	@ResponseBody
	@RequestMapping("/test/ex01")
	public String testProject() {
		return "<h1>테스트 프로젝트 완성</h1><h4>해당 프로젝트를 통해서 문제 풀이를 진행합니다</h4>";
	}
}
