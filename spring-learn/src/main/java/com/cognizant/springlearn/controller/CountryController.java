package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

@RequestMapping(value="/country",method=RequestMethod.GET)
public Country getCountryIndia() {
	LOGGER.info("Start");
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	Country country = (Country) context.getBean("in", Country.class);

	
	
	LOGGER.info("End");
	return country;
	
}
@GetMapping("/countries")
public List getAllCountries() {
	LOGGER.info("Start");
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	List countries = (List) context.getBean("countryList", ArrayList.class);

	
	
	LOGGER.info("End");
	return countries;
	
}
@RequestMapping(value = "/country/{code}", method = RequestMethod.GET)
public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
	LOGGER.info("Start");
	CountryService countryService=new CountryService();
	Country country=countryService.getCountry(code);
	LOGGER.info("End");
	return country;
}

@PostMapping("/countries")
public Country addCounrty(@RequestBody @Valid Country country) {
	LOGGER.info("Start");
	LOGGER.debug("Country {}:",country);
	// Create validator factory

	/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	Validator validator = factory.getValidator();

	// Validation is done against the annotations defined in country bean

	Set<ConstraintViolation<Country>> violations = validator.validate(country);

	List<String> errors = new ArrayList<String>();

	// Accumulate all errors in an ArrayList of type String

	for (ConstraintViolation<Country> violation : violations) {

	errors.add(violation.getMessage());
	}

	// Throw exception so that the user of this web service receives appropriate error message

	if (violations.size() > 0) {

	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());

	}*/
	LOGGER.info("End");
	return country;
	
	
}


}
