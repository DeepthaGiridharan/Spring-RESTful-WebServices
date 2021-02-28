package com.cognizant.moviecruiserSpringRestful.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Favorites is empty")
public class FavoriteEmptyException extends Exception {
	

	
}
