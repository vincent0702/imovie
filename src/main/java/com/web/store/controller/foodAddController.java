package com.web.store.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.store.model.CartOrderFood;
import com.web.store.model.FoodBean;
import com.web.store.model.FoodShoppingCart;
import com.web.store.model.RoomBean;
import com.web.store.service.ProductServiec;

@Controller
//@RequestMapping("_03_listBooks") 有另外folder再訂
@SessionAttributes({"FoodCart","allFood","room","movie","main","dessert","drink","packa"}) //"LoginOK"
public class foodAddController {
	
	@Autowired
	ProductServiec service;
	
	@PostMapping(value= "/addFood", produces = {"application/json"})
	protected ResponseEntity<Map<String,String>> addFoodToCart(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam (value = "foodId") String foodIdStr,
			@RequestParam (value = "foodNum") String qtyStr,
			@RequestParam (value = "foodP") String foodPriceStr,
			@RequestParam (value = "foodTitle") String foodT, 
			@RequestParam (value = "rId") String rId  ) throws ServletException, IOException {
		
		Map<String,String> map = new HashMap<>();
		
		FoodShoppingCart foodCart = (FoodShoppingCart) model.getAttribute("FoodCart");
		
		System.out.println("test = "+foodCart);
		if (foodCart == null) {
			// 就新建OrderCart物件
			foodCart = new FoodShoppingCart();
			// 並將此新建OrderCart的物件放到session物件內，成為它的屬性物件
			System.out.println("!!!!!!!!!!!!!!!!新建FoodCart...!!!!!!!!!!!!!!!!!");
			
			model.addAttribute("FoodCart", foodCart);   
		}
		
//		System.out.println("hiiii="+foodIdStr);
		int foodId = Integer.parseInt(foodIdStr.trim());
		
//		System.out.println("hi="+foodPriceStr);
		int foodPrice = Integer.parseInt(foodPriceStr.trim());
		
		Integer foodQty = 0 ; 
		try{
			// 進行資料型態的轉換
			foodQty = Integer.parseInt(qtyStr.trim());
		} catch(NumberFormatException e){
			throw new ServletException(e); 
		}
		
		CartOrderFood cof = new  CartOrderFood(null,foodId, foodT,foodQty,foodPrice);
		foodCart.addToCart(foodId, cof);
		
		System.out.println("食物種類 : "+foodCart.getItemSize());
//-----------------------------------------------------------------
		int roomPrice = 0;
//		System.out.println(request.getParameter("roodId"));
		int roomId  = Integer.parseInt(rId.trim());
//		String roomIdStr 	= request.getParameter("roodId");
//		System.out.println("***********"+roomIdStr);
		if(roomId != 0) {
			RoomBean roomBean = service.getProductById2(roomId);
			roomPrice = Integer.parseInt(roomBean.getRoomPrice().trim());
		}
		
		int foodTotal = 0;
		Set<Integer> set = foodCart.getContent().keySet();
		Iterator<Integer> it = set.iterator();
		for (Map.Entry<Integer, CartOrderFood> entry : foodCart.getContent().entrySet()) {
			foodTotal += entry.getValue().getFoodPrice()*entry.getValue().getQty();
		}
		foodTotal += roomPrice;
//-----------------------------------------------------------------		
//		String totalAll = request.getParameter("total");
		String foodTotalStr = String.valueOf(foodTotal);
		
		System.out.println("foodTotal:" + foodTotal);
		FoodBean bean = service.getProductById(foodId);
		map.put("foodName",bean.getFoodName());
		map.put("foodQty",qtyStr);
		map.put("foodP",foodPriceStr);
		map.put("foodT",foodT);
		
		map.put("foodTotal",foodTotalStr);
		ResponseEntity<Map<String,String>> re = new ResponseEntity<>(map,HttpStatus.OK);
		return re;
	
	}
	
//	@PostMapping("/addFood")
//	protected String addFoodToCart(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		FoodShoppingCart foodCart = (FoodShoppingCart) model.getAttribute("FoodCart");
//		
//		if (foodCart == null) {
//			// 就新建OrderCart物件
//			foodCart = new FoodShoppingCart();
//			// 並將此新建OrderCart的物件放到session物件內，成為它的屬性物件
//			System.out.println("新建FoodCart...");
//			model.addAttribute("FoodCart", foodCart);   
//		}
//		
//		String foodIdStr = request.getParameter("foodId");
//		System.out.println("hiiii="+foodIdStr);
//		int foodId = Integer.parseInt(foodIdStr.trim());
//		//用int 而非Integer應該沒問題嗎
//		
//		//4.
//		String foodPriceStr = request.getParameter("foodPrice");
//		System.out.println("hi="+foodPriceStr);
//		int foodPrice = Integer.parseInt(foodPriceStr.trim());
//		
//		String qtyStr = request.getParameter("qty");
//		Integer foodQty = 0 ; 
//		try{
//			// 進行資料型態的轉換
//			foodQty = Integer.parseInt(qtyStr.trim());
//		} catch(NumberFormatException e){
//			throw new ServletException(e); 
//		}
//		
//		CartOrderFood cof = new  CartOrderFood(foodId,foodQty,foodPrice);
//		foodCart.addToCart(foodId, cof);
//		
//		return "testProject";
//	
//	}
//	@ModelAttribute("FoodCart")
//	public FoodShoppingCart createFoodShopping(Model model) {
//		FoodShoppingCart fsc = new FoodShoppingCart();
//		System.out.println("新增foodCart");
//		return fsc;
//	}
}
