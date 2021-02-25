package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.dao.EmployeeDao;
@Service
public class DepartmentService {
	@Autowired
	DepartmentDao departmentDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	@Transactional
	public ArrayList getAllDepartment() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return 	departmentDao.getAllDepartment();
	}

}
