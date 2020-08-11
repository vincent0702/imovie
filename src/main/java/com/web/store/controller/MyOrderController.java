package com.web.store.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.store.model.CartOrderBean;
import com.web.store.model.CartOrderFood;
import com.web.store.service.ProductServiec;

import _01_register.model.MemberBean;

@Controller
@SessionAttributes({"FoodCart","room","movie","LoginOK","OrderCart"})
public class MyOrderController {

	@Autowired
	ProductServiec service;

	@Autowired
	ServletContext context;

	
	@GetMapping("/allmyorder")
	public String allmyorder(Model model, HttpServletRequest req) { 
		
		MemberBean mb = (MemberBean)model.getAttribute("LoginOK");/////判斷使用者
		model.addAttribute("memberid", mb);
		String mbId = Integer.toString(mb.getPkey());
		
		List<CartOrderBean> memberOrders = service.getOrderById(mbId);
		model.addAttribute("memberOrders", memberOrders);

		return "AllMyOrder";
	}
	
	@PostMapping("/lookorder")
	protected String lookorder(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		
		MemberBean mb = (MemberBean)model.getAttribute("LoginOK");/////判斷使用者
		model.addAttribute("memberid", mb);
		//String mbId = Integer.toString(mb.getPkey());
		
		//List<CartOrderBean> memberOrders = service.getOrderById(mbId);
		//model.addAttribute("memberOrders", memberOrders);
		
		String orderno = request.getParameter("look");
		CartOrderBean bb = service.getIdByNo(orderno);//由orderNo換算ID取得CarOrderBean
		
		List<CartOrderFood> cc = service.getFoodByBean(bb);//取得食物List
		
		model.addAttribute("movieproduct", service.getProductById1(bb.getMovieId()));
		model.addAttribute("roomproduct", service.getProductById2(bb.getRoomId()));
		model.addAttribute("memberID", bb.getMemberId());
		model.addAttribute("OrderNo", bb.getOrderNo());
		model.addAttribute("OrderDate", bb.getOrderDate());
		model.addAttribute("OrderDateStart", bb.getOrderDateStart());
		model.addAttribute("OrderDateEnd", bb.getOrderDateEnd());
		model.addAttribute("Ordertotal", bb.getTotalAmount());
		model.addAttribute("OrderFood", cc);

		return "MyOrder";
	
	}
}