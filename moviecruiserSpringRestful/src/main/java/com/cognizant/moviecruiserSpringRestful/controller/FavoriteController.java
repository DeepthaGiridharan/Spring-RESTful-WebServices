package com.cognizant.moviecruiserSpringRestful.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiserSpringRestful.MoviecruiserSpringRestfulApplication;
import com.cognizant.moviecruiserSpringRestful.exception.FavoriteEmptyException;
import com.cognizant.moviecruiserSpringRestful.model.Favorite;
import com.cognizant.moviecruiserSpringRestful.service.FavoriteService;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
	private static Logger LOGGER = LoggerFactory.getLogger(MoviecruiserSpringRestfulApplication.class);
	@Autowired
	private FavoriteService favoriteService;
	@PostMapping("/{userId}/{movieId}")
	public void addToFavorite(@PathVariable String userId,@PathVariable long movieId) {
		LOGGER.info("Start");

		favoriteService.addFavorite(userId, movieId);
		LOGGER.info("End");
	}
	@GetMapping("/{userId}")
	public Favorite getFavorites(@PathVariable String userId) throws FavoriteEmptyException {
		LOGGER.info("Start");
        
		LOGGER.info("End");
		return favoriteService.getAllFavorites(userId);
		}
	@DeleteMapping("/{userId}/{movieId}")
	public void deleteFavorite(@PathVariable String userId, @PathVariable long movieId) throws FavoriteEmptyException {
		LOGGER.info("START");
		LOGGER.info("END");
		favoriteService.removeFavorite(userId, movieId);

	}
}
