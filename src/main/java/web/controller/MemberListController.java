package web.controller;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import _01_register.model.MemberBean;
import _01_register.service.MemberService;

@Controller
public class MemberListController {
//	@RequestMapping("/products")
	
	@Autowired
	MemberService service;
	
	@Autowired
	ServletContext context;
	
	@GetMapping("/MemberList")//後端畫面，有拉資料表的內容
	public String Manager(Model model, HttpServletRequest req) {
		Map<Integer, MemberBean> memberMap = service.getMemberList();
		model.addAttribute("member",memberMap);
		return "MemberList/MemberList";
	}
}
