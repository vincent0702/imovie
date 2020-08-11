package com.web.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@SessionAttributes({"FoodCart"})
public class resetController {
	@GetMapping("/reset.do")
	public String removeCart(Model model, WebRequest webRequest, SessionStatus status) {
		System.out.println("remove : FoodCart OK");
		status.setComplete();
		webRequest.removeAttribute("FoodCart", WebRequest.SCOPE_SESSION);
		return "redirect:/testCart";
	}
}
