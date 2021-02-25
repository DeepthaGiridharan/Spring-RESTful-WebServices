package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.SpringLearnApplication;
@Component
public class DepartmentDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	private static ArrayList<Department> departmentList;

	public DepartmentDao() {
		LOGGER.info("Start");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");

		departmentList = (ArrayList) context.getBean("departmentList", ArrayList.class);

		LOGGER.info("End");
		
	}
	public ArrayList getAllDepartment() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return departmentList;
	}

}
