package com.web.store.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import _01_register.model.MemberBean;


@Entity
@Table(name="CartOrders")
public class CartOrderBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String orderNo;
	
	@Transient
	private RoomBean room;
	@Transient
	private MovieBean movie;
	@Transient
	private MemberBean member;
	
	private Integer roomId;
	private Integer movieId;
	
	private String 	memberId;
//	@Transient
//	private Map<Integer,Integer> foodAll; //(foodId,qty)
	private Integer	totalAmount;
	private String  orderDate;
	private String  orderDateStart;
	private String  orderDateEnd;
	
	@OneToMany(mappedBy="cartOrderBean", cascade=CascadeType.ALL)
	Set<CartOrderFood> orderFood = new LinkedHashSet<>();

	public CartOrderBean() {
		
	}
	

	public CartOrderBean(String orderNo, RoomBean room, MovieBean movie, Integer roomId, Integer movieId,
			String memberId, Integer totalAmount, String orderDate, String orderDateStart, String orderDateEnd,
			Set<CartOrderFood> orderFood) {
		super();
		this.orderNo = orderNo;
		this.room = room;
		this.movie = movie;
		this.roomId = roomId;
		this.movieId = movieId;
		this.memberId = memberId;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.orderDateStart = orderDateStart;
		this.orderDateEnd = orderDateEnd;
		this.orderFood = orderFood;
	}


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public RoomBean getRoom() {
		return room;
	}

	public void setRoom(RoomBean room) {
		this.room = room;
	}

	public MovieBean getMovie() {
		return movie;
	}

	public void setMovie(MovieBean movie) {
		this.movie = movie;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDateStart() {
		return orderDateStart;
	}

	public void setOrderDateStart(String orderDateStart) {
		this.orderDateStart = orderDateStart;
	}

	public String getOrderDateEnd() {
		return orderDateEnd;
	}

	public void setOrderDateEnd(String orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}

	public Set<CartOrderFood> getOrderFood() {
		return orderFood;
	}

	public void setOrderFood(Set<CartOrderFood> orderFood) {
		this.orderFood = orderFood;
	}


	public MemberBean getMember() {
		return member;
	}


	public void setMember(MemberBean member) {
		this.member = member;
	}

	
	

	
}
