package com.cognizant.moviecruiserSpringRestful.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.moviecruiserSpringRestful.MoviecruiserSpringRestfulApplication;
import com.cognizant.moviecruiserSpringRestful.exception.FavoriteEmptyException;
import com.cognizant.moviecruiserSpringRestful.model.Favorite;
import com.cognizant.moviecruiserSpringRestful.model.Movie;
@Component
public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static Logger LOGGER = LoggerFactory.getLogger(MoviecruiserSpringRestfulApplication.class);

	private LinkedHashMap<String, Favorite> userFavorites;
	@Autowired
	private MovieDao movieDao;
	public FavoriteDaoCollectionImpl() {
		LOGGER.debug("Inside FavoriteDaoCollectionImpl constructor");

		this.userFavorites = new LinkedHashMap<>();
	}

	public LinkedHashMap<String, Favorite> getUserFavorites() {
		return userFavorites;
	}

	public void setUserFavorites(LinkedHashMap<String, Favorite> userFavorites) {
		this.userFavorites = userFavorites;
	}

	public MovieDao getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	@Override
	public void addMovie(String userId, long movieId) {
		LOGGER.info("START");
		Movie movie = movieDao.getMovie(movieId);
		if (userFavorites.containsKey(userId)) {
			Favorite favorite = userFavorites.get(userId);
			List<Movie> list = favorite.getMovieList();
			list.add(movie);
			favorite.setMovieList(list);
			userFavorites.put(userId, favorite);
		} else {
			Favorite favorite = new Favorite(new ArrayList<Movie>(), 0);
			List<Movie> list = favorite.getMovieList();
			list.add(movie);
			favorite.setMovieList(list);
			userFavorites.put(userId, favorite);
		}
		LOGGER.info("END");
		
	}

	@Override
	public Favorite getAllFavorites(String userId) throws FavoriteEmptyException {
		LOGGER.info("START");
		Favorite favorite = userFavorites.get(userId);
		if (favorite == null)
			throw new FavoriteEmptyException();

		List<Movie> list = favorite.getMovieList();
		if (list == null || list.size() < 1)
			throw new FavoriteEmptyException();
		else {
			double total = list.size();

			favorite.setTotal(total);
		}
		
		
		LOGGER.info("END");

		return favorite;
	}

	@Override
	public void removeFavorite(String userId, long movieId) throws FavoriteEmptyException {
		LOGGER.info("START");

		Favorite favorite = userFavorites.get(userId);
		if (favorite == null)
			throw new FavoriteEmptyException();
		List<Movie> list = favorite.getMovieList();
		if (list == null || list.size() < 1)
			throw new FavoriteEmptyException();
		for (Movie movie : list) {
			if (movie.getId() == movieId) {
				list.remove(movie);
				break;
			}
			favorite.setMovieList(list);
			userFavorites.put(userId, favorite);
		}
		LOGGER.info("END");

		
	}

}













	