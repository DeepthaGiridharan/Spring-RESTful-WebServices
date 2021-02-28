package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
@Component
public class CartDaoCollectionImpl implements CartDao {
	private static Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	private LinkedHashMap<String, Cart> userCarts;
	@Autowired
	private MenuItemDao menuItemDao;

	public CartDaoCollectionImpl() {
		LOGGER.debug("Inside CartDaoCollectionImpl constructor");

		this.userCarts = new LinkedHashMap<>();
	}

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public LinkedHashMap<String, Cart> getUserCarts() {
		return userCarts;
	}

	public void setUserCarts(LinkedHashMap<String, Cart> userCarts) {
		this.userCarts = userCarts;
	}

	@Override
	public void addCartItem(String userId, long menuItemId) {
		LOGGER.info("START");
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			List<MenuItem> list = cart.getMenuItemList();
			list.add(menuItem);
			cart.setMenuItemList(list);
			userCarts.put(userId, cart);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0);
			List<MenuItem> list = cart.getMenuItemList();
			list.add(menuItem);
			cart.setMenuItemList(list);
			userCarts.put(userId, cart);
		}
		LOGGER.info("END");

	}

	@Override
	public Cart getAllCartItems(String userId) throws CartEmptyException {

		LOGGER.info("START");
		Cart cart = userCarts.get(userId);
		if (cart == null)
			throw new CartEmptyException();

		List<MenuItem> list = cart.getMenuItemList();
		if (list == null || list.size() < 1)
			throw new CartEmptyException();
		else {
			double total = 0;
			for (MenuItem menuItem : list) {
				total += menuItem.getPrice();
			}
			cart.setTotal(total);
		}
		LOGGER.info("END");

		return cart;
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) throws CartEmptyException {
		LOGGER.info("START");

		Cart cart = userCarts.get(userId);
		if (cart == null)
			throw new CartEmptyException();
		List<MenuItem> list = cart.getMenuItemList();
		if (list == null || list.size() < 1)
			throw new CartEmptyException();
		for (MenuItem menuItem : list) {
			if (menuItem.getId() == menuItemId) {
				list.remove(menuItem);
				break;
			}
			cart.setMenuItemList(list);
			userCarts.put(userId, cart);
		}
		LOGGER.info("END");

	}
	

}
