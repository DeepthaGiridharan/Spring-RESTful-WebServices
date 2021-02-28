package com.cognizant.moviecruiserSpringRestful.dao;

import java.util.List;

import com.cognizant.moviecruiserSpringRestful.model.Movie;

public interface MovieDao {
	public List<Movie> getMovieListAdmin();

	List<Movie> getMovieListCustomer();

	void modifyMovie(Movie movie);

	Movie getMovie(long movieId);

}
