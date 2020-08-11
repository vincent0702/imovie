package com.web.store.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.store.model.CartOrderBean;
import com.web.store.model.CartOrderFood;
import com.web.store.model.FoodShoppingCart;
import com.web.store.model.MovieBean;
import com.web.store.model.RoomBean;
import com.web.store.service.ProductServiec;

import _01_register.model.MemberBean;



@Controller
//@RequestMapping("_03_listBooks") 有另外folder再訂
@SessionAttributes({"OrderCart","FoodCart","LoginOK"}) //"LoginOK"
public class CartConfirmController {
	@Autowired
	ServletContext context;
	
	@Autowired
	ProductServiec service;
	
	@PostMapping("/confirm")
	protected String buyFood(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
//      判定是否有登入，晚點再說
//		MemberBean memberBean = (MemberBean) model.getAttribute("LoginOK");
//		if (memberBean == null) {
//			return "redirect: " + context.getContextPath() + "/_02_login/login";
//		}
//	
//		HttpSession session = request.getSession(false); 
//		if (session == null) {
//			return "redirect: " + context.getContextPath() + "/_02_login/login";
//		}
		
		int randomNo = 0;
		boolean testNum = true;
		String testDB = "";
		
		while(testNum) {
			testDB = "";
			randomNo = (int) (Math.random()*899990000 +100000000);
			testDB = String.valueOf(randomNo);
			testDB += "JhflgjfMGif";
			if(service.checkOrderNo(testDB)) {
				break;
			}
		}
//		(int) (Math.random()*899999999 +100000000);
		
		
		MemberBean mb = (MemberBean)model.getAttribute("LoginOK");
		System.out.println(mb.getPkey());
		String mbId = Integer.toString(mb.getPkey());
		
		
		FoodShoppingCart foodCart = (FoodShoppingCart) model.getAttribute("FoodCart");

		String roomIdStr 	= request.getParameter("roodId");
		int roomId          = Integer.parseInt(roomIdStr.trim());
		
		String movieIdStr 	= request.getParameter("movieId");
		int movieId          = Integer.parseInt(movieIdStr.trim());

		//-----------------------日期--------------------------		  
		
		RoomBean rBean = service.getProductById2(roomId);
		MovieBean mBean = service.getProductById1(movieId);
		
		System.out.println(rBean); //觀察用
		System.out.println(mBean); //觀察用
		
//		String memberId = null; //測試用，沒意義。
//		String aa = null; //測試用，沒意義。
//		String bb = null; //測試用，沒意義。
//		String cc = null; //測試用，沒意義。
		String date = request.getParameter("TimeDate");
		String start = request.getParameter("timeStart");
		String end = request.getParameter("timeEnd");
		Set<CartOrderFood> items = null;
		int roomPrice = Integer.parseInt(rBean.getRoomPrice());
		int foodAllPrice = 0;
		int total = 0;
		CartOrderBean orderC = new CartOrderBean(testDB,rBean,mBean,roomId,movieId,mbId,total,date,start,end,null);
			
			Map<Integer, CartOrderFood> content = new HashMap<>();
			//CartOrderBean orderC = new CartOrderBean(null,rBean,mBean,roomId,movieId,memberId,total,aa,bb,null);
		if(foodCart!=null) {
			
			content = foodCart.getContent();
			items = new LinkedHashSet<>();
//-------------------------------------------------------------
			Set<Integer> set = content.keySet();

			for(Integer i : set) {
				CartOrderFood toSet = content.get(i);
				toSet.setCartOrderBean(orderC);
				items.add(toSet);
			}
			for(CartOrderFood cof : items) {
				foodAllPrice += cof.getFoodPrice() * cof.getQty();
			}
		}
			total = roomPrice + foodAllPrice;
			
			orderC.setOrderFood(items);
			orderC.setTotalAmount(total);
		System.out.println("*************** = "+orderC.getOrderDate());

		model.addAttribute("OrderCart", orderC);
		System.out.println("房間ID = "+orderC.getRoomId());

		return  "cartConfirm";
	}
	
}
