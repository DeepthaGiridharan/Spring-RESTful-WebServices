package com.cognizant.moviecruiserSpringRestful.dao;

import com.cognizant.moviecruiserSpringRestful.exception.FavoriteEmptyException;
import com.cognizant.moviecruiserSpringRestful.model.Favorite;

public interface FavoriteDao {
	void addMovie(String userId, long movieId);
	

	Favorite getAllFavorites(String userId) throws FavoriteEmptyException;

	void removeFavorite(String userId, long movieId) throws FavoriteEmptyException;
}
