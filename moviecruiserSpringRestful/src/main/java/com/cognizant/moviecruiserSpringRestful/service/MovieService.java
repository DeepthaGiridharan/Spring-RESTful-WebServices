package com.cognizant.moviecruiserSpringRestful.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiserSpringRestful.MoviecruiserSpringRestfulApplication;
import com.cognizant.moviecruiserSpringRestful.dao.MovieDao;
import com.cognizant.moviecruiserSpringRestful.model.Movie;

@Service
public class MovieService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserSpringRestfulApplication.class);
	@Autowired
	private MovieDao movieDao;

	

	public MovieDao getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	
	public List<Movie> getMovieListAdmin() {
		  LOGGER.info("Start");
		  LOGGER.info("End");
		  return movieDao.getMovieListAdmin();
		}
	public List<Movie> getMovieListCustomer() {
		 LOGGER.info("Start");
		  LOGGER.info("End");
		return movieDao.getMovieListCustomer();
		

	}

	public void modifyMovie(Movie movie) {
		LOGGER.info("Start");
		  LOGGER.info("End");
			movieDao.modifyMovie(movie);
		
	}

	public Movie getMovie(long movieId) {
		LOGGER.info("Start");
		  LOGGER.info("End");
			return movieDao.getMovie(movieId);
		
	}
	
}
