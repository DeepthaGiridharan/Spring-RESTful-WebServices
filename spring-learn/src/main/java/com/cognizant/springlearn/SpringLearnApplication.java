package com.cognizant.springlearn;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.controller.HelloController;


@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Main");
		displayDate();
		displayCountry();
		displayCountries();
		
		
	}

	public static void displayCountries() {
		LOGGER.info("Start");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countryList = (List<Country>) context.getBean("countryList", ArrayList.class);

		LOGGER.debug("Country List: {}", countryList.toString());
		
	}

	public static void displayCountry() {
		LOGGER.info("Start");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country.toString());
		Country anotherCountry = (Country) context.getBean("country", Country.class);
		
		
		LOGGER.info("End");
		
	}

	public static void displayDate(){
		LOGGER.info("Start");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date date;
		try {
			date = format.parse("31/12/2018");
			//System.out.println(date);
			LOGGER.debug(date.toString());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		LOGGER.info("End");
		
	}

}

