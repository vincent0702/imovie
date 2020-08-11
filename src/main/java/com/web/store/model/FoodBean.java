package com.web.store.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
// 本類別封裝單筆書籍資料
@Entity
@Table(name="Food")
public class FoodBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer foodId ;
	private String foodName;
	@JsonIgnore
	private Blob foodImg;	
	private Integer foodPrice;
	private String foodType ;
	private String foodFileName;
	private Integer foodTypeId;
	private Date foodDate;
	@Transient
	private String foodDateString;
	@JsonIgnore
	@Transient
	private MultipartFile productImage;
	public FoodBean() {
		super();
	}

	public FoodBean(Integer foodId, String foodName, Blob foodImg, Integer foodPrice, String foodType,Integer foodTypeId,
			String foodFileName) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodImg = foodImg;
		this.foodPrice = foodPrice;
		this.foodType = foodType;
		this.foodFileName = foodFileName;
		this.foodTypeId = foodTypeId ;
	}

	public Integer getFoodTypeId() {
		return foodTypeId;
	}

	public void setFoodTypeId(Integer foodTypeId) {
		this.foodTypeId = foodTypeId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Blob getFoodImg() {
		return foodImg;
	}

	public void setFoodImg(Blob foodImg) {
		this.foodImg = foodImg;
	}

	public Integer getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getFoodFileName() {
		return foodFileName;
	}

	public void setFoodFileName(String foodFileName) {
		this.foodFileName = foodFileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public Date getFoodDate() {
		return foodDate;
	}

	public void setFoodDate(Date foodDate) {
		this.foodDate = foodDate;
	}

	public String getFoodDateString() {
		return foodDateString;
	}

	public void setFoodDateString(String foodDateString) {
		this.foodDateString = foodDateString;
	}
	
	

}
