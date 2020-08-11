package com.web.store.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderFood")
public class CartOrderFood implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer seq;
	
	private Integer foodId;
	private String foodTitle;
	private Integer qty;
	private Integer foodPrice;
	
	@ManyToOne
	@JoinColumn(name = "FK_CartOrderId")
	private CartOrderBean cartOrderBean;
	public CartOrderFood() {
		super();
	}
	
	public CartOrderFood(Integer seq, Integer foodId, String foodTitle, Integer qty, Integer foodPrice) {
		super();
		this.seq = seq;
		this.foodId = foodId;
		this.foodTitle = foodTitle;
		this.qty = qty;
		this.foodPrice = foodPrice;
	}

	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getFoodTitle() {
		return foodTitle;
	}
	public void setFoodTitle(String foodTitle) {
		this.foodTitle = foodTitle;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}
	public CartOrderBean getCartOrderBean() {
		return cartOrderBean;
	}
	public void setCartOrderBean(CartOrderBean cartOrderBean) {
		this.cartOrderBean = cartOrderBean;
	}
	
	
	
	
}
