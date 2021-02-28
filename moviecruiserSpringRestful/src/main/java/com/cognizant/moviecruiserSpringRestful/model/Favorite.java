package com.cognizant.moviecruiserSpringRestful.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Favorite {
	private List<Movie> movieList;
	private double total;

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Favorite(List<Movie> movieList, double total) {
		setMovieList(movieList);
		setTotal(total);
	}

	public Favorite() {

	}

}
