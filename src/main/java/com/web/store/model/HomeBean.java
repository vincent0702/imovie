package com.web.store.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Home")
public class HomeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer homeId;
	private String homeName;
	private String homeFileName;
	@JsonIgnore
	private Blob homeImg;
	private Integer homeTpy;
	
	@Transient
	private MultipartFile productImage;
	@Transient
	private MultipartFile productVedio;  
	
	public HomeBean(Integer homeId, String homeName, String homeFileName, Blob homeImg,Integer homeTpy) {
		super();
		this.homeId = homeId;
		this.homeName = homeName;
		this.homeFileName = homeFileName;
		this.homeImg = homeImg;
		this.homeTpy = homeTpy;
	}
	public HomeBean() {
		super();
	}
	
	public Integer getHomeTpy() {
		return homeTpy;
	}
	public void setHomeTpy(Integer homeTpy) {
		this.homeTpy = homeTpy;
	}
	public Integer getHomeId() {
		return homeId;
	}
	public void setHomeId(Integer homeId) {
		this.homeId = homeId;
	}
	public String getHomeName() {
		return homeName;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	public String getHomeFileName() {
		return homeFileName;
	}
	public void setHomeFileName(String homeFileName) {
		this.homeFileName = homeFileName;
	}
	public Blob getHomeImg() {
		return homeImg;
	}
	public void setHomeImg(Blob homeImg) {
		this.homeImg = homeImg;
	}

		
	
	public MultipartFile getProductVedio() {
		return productVedio;
	}
	public void setProductVedio(MultipartFile productVedio) {
		this.productVedio = productVedio;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	
}
