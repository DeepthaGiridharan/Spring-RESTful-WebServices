package com.cognizant.truyum.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;

@Service
public class CartService {
	private static Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	private CartDao cartDao;
	public CartDao getCartDao() {
		return cartDao;
	}
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	public void addCartItem(String userId, long menuItemId) {
		LOGGER.info("Start");
			cartDao.addCartItem(userId, menuItemId);
		LOGGER.info("End");
	}

	public Cart getAllCartItems(String userId) throws CartEmptyException{
		LOGGER.info("Start");
		LOGGER.info("End");
			return cartDao.getAllCartItems(userId);
			
		
	}

	public void removeCartItem(String userId, long menuItemId) throws CartEmptyException {
		LOGGER.info("Start");
			cartDao.removeCartItem(userId, menuItemId);
			LOGGER.info("End");
	}
}
