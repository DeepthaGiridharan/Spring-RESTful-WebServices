package com.cognizant.moviecruiserSpringRestful.model;

import java.util.Date;

import org.springframework.stereotype.Component;


public class Movie {
	private long id;
	private String title;
	private float boxOffice;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean teaser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(float boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isTeaser() {
		return teaser;
	}

	public void setTeaser(boolean teaser) {
		this.teaser = teaser;
	}

	public Movie() {
	}

	public Movie(long id, String title, float boxOffice, boolean active, Date dateOfLaunch, String genre,
			boolean teaser) {
		setId(id);
		setTitle(title);
		setBoxOffice(boxOffice);
		setActive(active);
		setDateOfLaunch(dateOfLaunch);
		setGenre(genre);
		setTeaser(teaser);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", boxOffice=" + boxOffice + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", genre=" + genre + ", teaser=" + teaser + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Movie other = (Movie) obj;
		return id == other.id;
	}

}
