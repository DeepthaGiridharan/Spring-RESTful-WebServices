package com.cognizant.springlearn;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.cognizant.springlearn.controller.CountryController;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
	@Autowired
	private CountryController countryController;
	@Autowired

	private MockMvc mvc;
	@Test
	void contextLoads() {
		assertNotNull(countryController);
	}
	@Test

	public void getCountry() throws Exception {

	ResultActions actions = mvc.perform(get("/country"));

	actions.andExpect(status().isOk());

	actions.andExpect(jsonPath("$.code").exists());

	actions.andExpect(jsonPath("$.code").value("IN"));

	}
	@Test
	public void testGetCountryException() throws Exception {
		ResultActions actions = mvc.perform(get("/country/ad"));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Country not found"));
	}
	@Test
	public void testUpdateEmployeeException() throws Exception{
		Department department = new Department();
		department.setId(2);
		department.setName("Finance");
		Skill skill = new Skill();
		skill.setId(2);
		skill.setName("Accounting");
		Set<Skill> skillList = new HashSet<Skill>();
		skillList.add(skill);
		Employee employee = new Employee();
		employee.setId(5);
		employee.setName("George");
		employee.setDateOfBirth(new Date("24/09/1978"));
		employee.setSalary(30000);
		employee.setPermanent(true);
		employee.setDepartment(department);
		employee.setSkillList(skillList);
		ResultActions actions = mvc.perform(put("/employees").contentType(MediaType.APPLICATION_JSON).
				   content(jsonAsString(employee)));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Employee not found"));
	}
	public static String jsonAsString(Employee employee) {
		try {
			return new ObjectMapper().writeValueAsString(employee);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	@Test
	public void testDeleteEmployeeException() throws Exception {
		ResultActions actions = mvc.perform(delete("/employees/6"));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Employee not found"));
	}
	
}
