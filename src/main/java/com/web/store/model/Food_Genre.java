package com.web.store.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Food_Genre")
public class Food_Genre implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer fGenreId;
	private String fGenreName;
	
	
	
	public Food_Genre() {
		super();
	}

	public Food_Genre(Integer fGenreId, String fGenreName) {
		super();
		this.fGenreId = fGenreId;
		this.fGenreName = fGenreName;
	}

	public Integer getfGenreId() {
		return fGenreId;
	}

	public void setfGenreId(Integer fGenreId) {
		this.fGenreId = fGenreId;
	}

	public String getfGenreName() {
		return fGenreName;
	}

	public void setfGenreName(String fGenreName) {
		this.fGenreName = fGenreName;
	}
	
	
}
