package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

public Country getCountry(String code) throws CountryNotFoundException {
	LOGGER.info("Start");
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
	Country country = null;
	try {
		country = countries.stream().filter(country1 -> country1.getCode().equalsIgnoreCase(code)).findFirst()
				.get();
	} catch (NoSuchElementException e) {
		throw new CountryNotFoundException();
	}
	LOGGER.info("END");

	return country;
	
}
}
