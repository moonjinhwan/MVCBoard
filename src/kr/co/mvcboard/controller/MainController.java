package kr.co.mvcboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.mvcboard.beans.ContentBean;
import kr.co.mvcboard.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping("main")
	public String main(Model model) {
		ArrayList<List<ContentBean>> list = new ArrayList<List<ContentBean>>();
		
		for(int i=1; i<=4 ;i++) {
			List<ContentBean> list1 = mainService.getContentList(i);
			list.add(list1);
		}
		model.addAttribute("list", list);
 		return "main";
	}
}
