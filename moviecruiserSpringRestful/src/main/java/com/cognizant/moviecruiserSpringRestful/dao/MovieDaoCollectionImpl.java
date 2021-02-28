package com.cognizant.moviecruiserSpringRestful.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.moviecruiserSpringRestful.MoviecruiserSpringRestfulApplication;
import com.cognizant.moviecruiserSpringRestful.model.Movie;
@Component
public class MovieDaoCollectionImpl implements MovieDao {
	private ArrayList<Movie> movieList;
	public MovieDaoCollectionImpl() {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("movie.xml");
		this.movieList=(ArrayList<Movie>)context.getBean("movies");
	}
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserSpringRestfulApplication.class);

	@Override
	public List<Movie> getMovieListAdmin() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return movieList;
	}

	

	@Override
	public List<Movie> getMovieListCustomer() {
		LOGGER.info("Start");
		List<Movie> list = new ArrayList<Movie>();
		for (Movie movie : movieList) {
			if (((movie.getDateOfLaunch()).equals(new Date()))
					|| (movie.getDateOfLaunch()).before(new Date()) && movie.isActive()) {
				list.add(movie);
			}
		}
		LOGGER.info("End");
		return list;
	}

	@Override
	public void modifyMovie(Movie movie) {
		LOGGER.info("Start");
		for (Movie movieInList : movieList) {
			if (movie.equals(movieInList)) {
				movieList.remove(movieInList);
				movieList.add(movie);
				break;
			}
		}
		LOGGER.info("End");
		
	}

	@Override
	public Movie getMovie(long movieId) {
		for (Movie movieInList : movieList) {
			if (movieId == movieInList.getId())
				return movieInList;
		}
		return null;
	
	}
	

}
