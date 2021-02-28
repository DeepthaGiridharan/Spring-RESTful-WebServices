package com.cognizant.truyum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	private static Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	private CartService cartService;
	@PostMapping("/{userId}/{menuItemId}")
	public void addToCart(@PathVariable String userId,@PathVariable long menuItemId) {
		LOGGER.info("Start");

		cartService.addCartItem(userId, menuItemId);
		LOGGER.info("End");
	}
	@GetMapping("/{userId}")
	public Cart getAllCartItems(@PathVariable String userId) throws CartEmptyException {
		LOGGER.info("Start");
        
		LOGGER.info("End");
		return cartService.getAllCartItems(userId);
		}
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable String userId, @PathVariable long menuItemId) throws CartEmptyException {
		LOGGER.info("START");
		LOGGER.info("END");
		cartService.removeCartItem(userId, menuItemId);

	}
}

