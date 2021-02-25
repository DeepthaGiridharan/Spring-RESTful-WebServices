package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	@Transactional
	public ArrayList getAllEmployee() {
		LOGGER.info("Start");
		

		

		LOGGER.info("End");
		return employeeDao.getAllEmployee();
	}
	@Transactional
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		
		LOGGER.info("Start");
		LOGGER.info("End");
		employeeDao.updateEmployee(employee);
	}
	@Transactional
	public void deleteEmployee(int code) throws EmployeeNotFoundException{
		
		LOGGER.info("Start");
		LOGGER.info("End");
		employeeDao.deleteEmployee(code);
	}

}
