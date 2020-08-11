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
@Table(name = "Movie")
public class MovieBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;
	private String movieName;
	private String movieLength;
	private String movieFileName;
	private String movieGenre1;	
	private Integer movieTypeId;
	private String movieRated;
	@JsonIgnore
	private Blob movieImg;
	private String movieEName;
	@Column(updatable = true, name="movieNote", nullable = true, columnDefinition = "varchar(max)")
	private String movieNote;
	private Date movieDate;
	@Transient
	private String movieDateString;
	@JsonIgnore
	@Transient
	private MultipartFile productImage;
	
	
	public MovieBean() {
		super();
	}

	public MovieBean(Integer movieId, String movieName, String movieLength, String moveFileName, String movieGenre1,
			 String movieRated, Blob movieImg, String movieEName, String movieNote ,Integer movieTypeId) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLength = movieLength;
		this.movieFileName = moveFileName;
		this.movieGenre1 = movieGenre1;
		this.movieTypeId = movieTypeId;
		this.movieRated = movieRated;
		this.movieImg = movieImg;
		this.movieEName = movieEName;
		this.movieNote = movieNote;
		
	}

	public Integer getMovieTypeId() {
		return movieTypeId;
	}

	public void setMovieTypeId(Integer movieTypeId) {
		this.movieTypeId = movieTypeId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(String movieLength) {
		this.movieLength = movieLength;
	}

	public String getMovieFileName() {
		return movieFileName;
	}

	public void setMovieFileName(String moveFileName) {
		this.movieFileName = moveFileName;
	}

	public String getMovieGenre1() {
		return movieGenre1;
	}

	public void setMovieGenre1(String movieGenre1) {
		this.movieGenre1 = movieGenre1;
	}

	public String getMovieRated() {
		return movieRated;
	}

	public void setMovieRated(String movieRated) {
		this.movieRated = movieRated;
	}

	public Blob getMovieImg() {
		return movieImg;
	}

	public void setMovieImg(Blob movieImg) {
		this.movieImg = movieImg;
	}

	public String getMovieEName() {
		return movieEName;
	}

	public void setMovieEName(String movieEName) {
		this.movieEName = movieEName;
	}

	public String getMovieNote() {
		return movieNote;
	}

	public void setMovieNote(String movieNote) {
		this.movieNote = movieNote;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieDateString() {
		return movieDateString;
	}

	public void setMovieDateString(String movieDateString) {
		this.movieDateString = movieDateString;
	}
	
	
	
	
	
}
