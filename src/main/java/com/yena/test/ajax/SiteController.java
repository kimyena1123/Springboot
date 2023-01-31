package com.yena.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yena.test.ajax.bo.SiteBO;
import com.yena.test.ajax.model.Site;

@RequestMapping("/ajax/site")
@Controller
public class SiteController {
	@Autowired
	private SiteBO siteBO;
	
	//Read - (select)
	@GetMapping("/list")
	public String ReadSite(Model model) {
		List<Site> siteList = siteBO.ReadSite();
		
		model.addAttribute("siteList", siteList);
		
		return "/ajax/siteList";
	}
	
	//Create - (insert)
	@ResponseBody
	@RequestMapping("/create")
	public Map<String, String> CreateSite(
			@RequestParam("name") String name
			,@RequestParam("url") String url) {
		
		int count = siteBO.CreateSite(name, url);
		
		//성공시 : {result : "true"}
		//실패시 : {result : "false"{
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "true");
		}else {
			result.put("result", "false");
		}
		return result;
	}
	
	@GetMapping("/input")
	public String input() {
		return "ajax/siteInput";
	}
	
	//url 주소를 전달받고, 해당 주소가 new_user 테이블에 존재하는지 확인하는 API
	//url 중복 여부 확인 API
	@ResponseBody
	@GetMapping("/checkUrl")
	public Map<String, Boolean> checkUrl(@RequestParam("url") String url){
		
		Map<String, Boolean> check = new HashMap<>();
		
		if(siteBO.checkUrl(url)) { // 중복임
			check.put("check", true);
		}else { // 중복 아님
			check.put("check", false);
		}
		
		return check;
	}
	
	//삭제버튼
	@ResponseBody
	@PostMapping("/deleteById")
	public Map<String, Boolean> destroyById(@RequestParam("id") int id){
		
		int count = siteBO.destroyById(id);
		
		Map<String, Boolean> result = new HashMap<>();
		
		//삭제성공 : {"result" : true}
		//삭제실패 : {"result" : false}
		
		if(count == 1) {
			result.put("result", true); //삭제성공
		}else {
			result.put("result", false);//삭제실패
		}
		
		return result;
	}
}
