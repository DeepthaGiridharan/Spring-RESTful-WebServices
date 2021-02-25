package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
@RestController
public class EmployeeController {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/employees")
	public ArrayList getAllEmployee() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return employeeService.getAllEmployee();
		
	}
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("Start");
		LOGGER.info("End");
		employeeService.updateEmployee(employee);
		
	}
	@DeleteMapping("/employees/{code}")
	public void deleteEmployee(@PathVariable int code)throws EmployeeNotFoundException {
		LOGGER.info("Start");
		LOGGER.info("End");
		employeeService.deleteEmployee(code);
	}
}
