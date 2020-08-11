package com.web.store.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Room")
public class RoomBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomId;
	private String roomName;
	private Integer roomNameId;
	private String roomSize;
	private String  roomFileName;
	private String roomPrice;
	@JsonIgnore
	private Blob roomImg;
	@Transient
	@Column(updatable = true, name="roomNote", nullable = true, columnDefinition = "varchar(max)")
	private String roomNote= null;
	@Transient
	private String roomState = null;
	private Date roomDate;
	@Transient
	private String roomDateString;
	@JsonIgnore
	@Transient
	private MultipartFile productImage;
	private String roomPopulation;
	
	
	public RoomBean() {
		super();
	}
	public RoomBean(Integer roomId, String roomName, String roomSize, String roomFileName, String roomPrice,
			Blob roomImg, String roomNote, String roomState,Integer roomNameId) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomNameId = roomNameId;
		this.roomSize = roomSize;
		this.roomFileName = roomFileName;
		this.roomPrice = roomPrice;
		this.roomImg = roomImg;
		this.roomNote = roomNote;
		this.roomState = roomState;
	}
	
	
	public Integer getRoomNameId() {
		return roomNameId;
	}
	public void setRoomNameId(Integer roomNameId) {
		this.roomNameId = roomNameId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}
	public String getRoomFileName() {
		return roomFileName;
	}
	public void setRoomFileName(String roomFileName) {
		this.roomFileName = roomFileName;
	}
	public String getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}
	public Blob getRoomImg() {
		return roomImg;
	}
	public void setRoomImg(Blob roomImg) {
		this.roomImg = roomImg;
	}
	public String getRoomNote() {
		return roomNote;
	}
	public void setRoomNote(String roomNote) {
		this.roomNote = roomNote;
	}
	public String getRoomState() {
		return roomState;
	}
	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}
	public Date getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(Date roomDate) {
		this.roomDate = roomDate;
	}
	public String getRoomDateString() {
		return roomDateString;
	}
	public void setRoomDateString(String roomDateString) {
		this.roomDateString = roomDateString;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	public String getRoomPopulation() {
		return roomPopulation;
	}
	public void setRoomPopulation(String roomPopulation) {
		this.roomPopulation = roomPopulation;
	}
	
}
	