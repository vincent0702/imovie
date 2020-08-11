package com.web.store.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie_Genre")
public class Movie_Genre implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer mGenreId;
	private String mGenreName;
	private String mGenreEName;
	
	
	
	public Movie_Genre() {
		super();
	}

	public Movie_Genre(Integer mGenreId, String mGenreName, String mGenreEName) {
		super();
		this.mGenreId = mGenreId;
		this.mGenreName = mGenreName;
		this.mGenreEName = mGenreEName;
	}

	public Integer getmGenreId() {
		return mGenreId;
	}

	public void setmGenreId(Integer mGenreId) {
		this.mGenreId = mGenreId;
	}

	public String getmGenreName() {
		return mGenreName;
	}

	public void setmGenreName(String mGenreName) {
		this.mGenreName = mGenreName;
	}

	public String getmGenreEName() {
		return mGenreEName;
	}

	public void setmGenreEName(String mGenreEName) {
		this.mGenreEName = mGenreEName;
	}

	
	
	
}
