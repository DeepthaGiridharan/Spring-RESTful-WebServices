package com.cognizant.truyum.dao;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;

public interface CartDao {
	void addCartItem(String userId, long menuItemId);
			

	Cart getAllCartItems(String userId) throws CartEmptyException;

	void removeCartItem(String userId, long menuItemId) throws CartEmptyException;

}
