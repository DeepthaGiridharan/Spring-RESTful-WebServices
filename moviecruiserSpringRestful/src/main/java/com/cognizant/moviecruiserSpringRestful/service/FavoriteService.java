package com.cognizant.moviecruiserSpringRestful.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiserSpringRestful.MoviecruiserSpringRestfulApplication;
import com.cognizant.moviecruiserSpringRestful.dao.FavoriteDao;
import com.cognizant.moviecruiserSpringRestful.exception.FavoriteEmptyException;
import com.cognizant.moviecruiserSpringRestful.model.Favorite;

@Service
public class FavoriteService {
	private static Logger LOGGER = LoggerFactory.getLogger(MoviecruiserSpringRestfulApplication.class);
	@Autowired
	private FavoriteDao favoriteDao;
	
	public FavoriteDao getFavoriteDao() {
		return favoriteDao;
	}

	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

	public void addFavorite(String userId, long movieId) {
		LOGGER.info("Start");
			favoriteDao.addMovie(userId, movieId);
		LOGGER.info("End");
	}

	public Favorite getAllFavorites(String userId) throws FavoriteEmptyException{
		LOGGER.info("Start");
		LOGGER.info("End");
			return favoriteDao.getAllFavorites(userId);
			
		
	}

	public void removeFavorite(String userId, long movieId) throws FavoriteEmptyException {
		LOGGER.info("Start");
			favoriteDao.removeFavorite(userId, movieId);
			LOGGER.info("End");
	}
}
