package com.cognizant.moviecruiserSpringRestful.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiserSpringRestful.MoviecruiserSpringRestfulApplication;
import com.cognizant.moviecruiserSpringRestful.model.Movie;
import com.cognizant.moviecruiserSpringRestful.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserSpringRestfulApplication.class);
	@GetMapping
	public List<Movie> getAllMovies() {
		LOGGER.info("START");
		LOGGER.info("END");
		return movieService.getMovieListCustomer();
	}
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable long id) {
		LOGGER.info("START");
		LOGGER.info("END");
		return movieService.getMovie(id);
	}
	@PutMapping
	public void modifyMenuItem(@RequestBody @Valid Movie movie) {
		LOGGER.info("START");
		
		movieService.modifyMovie(movie);
		LOGGER.info("END");
	}
}
