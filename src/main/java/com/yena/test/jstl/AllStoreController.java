package com.yena.test.jstl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yena.test.jstl.bo.AllStoreBO;
import com.yena.test.jstl.model.AllStore;
import com.yena.test.jstl.model.NewReview;

@RequestMapping("/store")
@Controller
public class AllStoreController {
	@Autowired
	private AllStoreBO storeBO;

	//READ (select) - Store 테이블 조회
	@GetMapping("/show")
	public String ReadStore(Model model) {
		List<AllStore> storeList = storeBO.ReadStore();
		
		model.addAttribute("storeList", storeList);
		
		return "jstl/store/store";
	}
	
	// READ (select) - new_review 테이블 조회
	@GetMapping("/review")
	public String ReadReview(Model model
							,@RequestParam("storeId") int storeId) {
		List<NewReview> reviewList = storeBO.ReadReview(storeId);
		
		model.addAttribute("reviewList", reviewList);

		return "jstl/store/review";
	}
}
