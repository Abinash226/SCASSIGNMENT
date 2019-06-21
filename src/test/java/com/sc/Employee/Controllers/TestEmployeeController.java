package com.sc.Employee.Controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sc.Employee.Controller.EmployeeController;
import com.sc.Employee.Domain.Employee;
import com.sc.Employee.Service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class TestEmployeeController {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private EmployeeService eService;
	@Test
	public void getAllEmployeesAPI() throws Exception
	{
		List<Employee> employees = Arrays.asList(
                new Employee(1L, "Abinash","eqew","wrerw","rew","ewwre"),
                new Employee(2L, "Mohanty","eqew","wrerw","rew","ewwre"));
		when(eService.byFirstName()).thenReturn(employees);
		
		mvc.perform( MockMvcRequestBuilders
				.get("/employees")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].employeeId", is(1)));
		

	}

	@Test
	public void createEmployeeAPI() throws Exception
	{
		Employee emp = new Employee(1L, "Abinash", "Mohanty", "Male","AM&C","22-06-1993");
		when(eService.addEmployee(emp)).thenReturn(emp);
		mvc.perform( MockMvcRequestBuilders
				.post("/employees")
				.content(asJsonString(emp))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
	}
	

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}







