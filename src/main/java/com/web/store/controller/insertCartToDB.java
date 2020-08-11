package com.web.store.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.web.store.model.CartOrderBean;
import com.web.store.model.CartOrderFood;
import com.web.store.model.FoodShoppingCart;
import com.web.store.service.ProductServiec;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@Controller
@SessionAttributes({"OrderCart","FoodCart"})
public class insertCartToDB {
	
	@Autowired
	ProductServiec service;
	
	@Autowired
	ServletContext context;

	
	@GetMapping("/insert.do")
	protected String insertDATA(Model model, WebRequest webRequest, SessionStatus status) {
		CartOrderBean cob = (CartOrderBean) model.getAttribute("OrderCart");
		FoodShoppingCart fsc = (FoodShoppingCart) model.getAttribute("FoodCart");
		
		System.out.println("TotalAmount = "+cob.getTotalAmount());
		System.out.println("cobID = "+cob.getOrderNo());
		System.out.println("fsc = "+fsc);
		
		service.cartToDB(cob);
		status.setComplete();
		webRequest.removeAttribute("FoodCart", WebRequest.SCOPE_SESSION);
		webRequest.removeAttribute("OrderCart", WebRequest.SCOPE_SESSION);
		return "redirect:/";
}
	
	      
	
}
