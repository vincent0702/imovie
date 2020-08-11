package com.web.store.model;

import java.util.LinkedHashMap;
import java.util.Map;
public class FoodShoppingCart {   
	
	private Map<Integer, CartOrderFood> foodcart = new LinkedHashMap< >();
	
	public FoodShoppingCart() {
	}
	
	public Map<Integer, CartOrderFood>  getContent() { // ${ShoppingCart.content}
		return foodcart;
	}
	public void addToCart(int foodId, CartOrderFood  cof) {
		if (cof.getQty() == 0 ) {
			foodcart.remove(foodId);
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if ( foodcart.get(foodId) == null ) {
		    foodcart.put(foodId, cof);
		} else {
	        // 如果客戶在伺服器端已有此項商品的資料，則客戶『更改』此項商品
			CartOrderFood coff = foodcart.get(foodId);
			// 新增數量
			coff.setQty(cof.getQty());
		}
	}


	public int getItemSize(){   // ShoppingCart.itemNumber
		return foodcart.size();
	}
	//計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
//	public double getSubtotal(){
//		double subTotal = 0 ;
//		Set<Integer> set = foodcart.keySet();
//		for(int n : set){
//			CartOrderFood cof = foodcart.get(n);
//			double price    = cof.getPrice();
//			int qty      = cof.getQty();
//			subTotal +=  price *  qty;
//		}
//		return subTotal;
//	}
}
