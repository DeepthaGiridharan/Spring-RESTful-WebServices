package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
@Service("menuItemService")
public class MenuItemService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	private MenuItemDao menuItemDao;

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}
	public List<MenuItem> getMenuItemListAdmin() {
		  LOGGER.info("Start");
		  LOGGER.info("End");
		  return menuItemDao.getMenuItemListAdmin();
		}
	public List<MenuItem> getMenuItemListCustomer() {
		 LOGGER.info("Start");
		  LOGGER.info("End");
		return menuItemDao.getMenuItemListCustomer();
		

	}

	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		  LOGGER.info("End");
			menuItemDao.modifyMenuItem(menuItem);
		
	}

	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("Start");
		  LOGGER.info("End");
			return menuItemDao.getMenuItem(menuItemId);
		
	}
	
}
