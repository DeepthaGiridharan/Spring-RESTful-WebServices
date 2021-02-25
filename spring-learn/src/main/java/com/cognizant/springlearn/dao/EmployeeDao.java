package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
@Component
public class EmployeeDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
private static ArrayList<Employee> employeeList;

public EmployeeDao() {
	LOGGER.info("Start");
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");

 employeeList = (ArrayList<Employee>) context.getBean("employeeList", ArrayList.class);
	LOGGER.info("End");

	
}
public ArrayList<Employee> getAllEmployee() {
	LOGGER.info("Start");
	LOGGER.info("End");
	return employeeList;
}

public void updateEmployee(Employee employee ) throws EmployeeNotFoundException{
	LOGGER.info("Start");
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
    employeeList = (ArrayList<Employee>) context.getBean("employeeList", ArrayList.class);
    
    for(Employee e:employeeList) {
    	if(e.getId()==employee.getId()) {
    		employeeList.remove(e);
    		employeeList.add(employee);
    		LOGGER.info("End");
    		return;
    	}
    	
    		
    }
    throw new EmployeeNotFoundException();
 
	
}
public void deleteEmployee(int code) throws EmployeeNotFoundException{
	LOGGER.info("Start");
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
    employeeList = (ArrayList<Employee>) context.getBean("employeeList", ArrayList.class);
    
    for(Employee e:employeeList) {
    	if(e.getId()==code) {
    		employeeList.remove(e);
    		
    		LOGGER.info("End");
    		return;
    	}
    	
    		
    }
    throw new EmployeeNotFoundException();
}

}
