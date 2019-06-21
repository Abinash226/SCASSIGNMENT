package com.sc.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.Employee.Domain.Employee;
import com.sc.Employee.Exception.EmployeeNotFoundException;
import com.sc.Employee.Service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
@Api("Set of endpoints for Creating, Retrieving, Updating and Deleting of Employees.")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping
	@ApiOperation("Creates a new Employee.")
	public ResponseEntity<Employee> addEmployee(@ApiParam("Personal information for a new Employee to be created.") @RequestBody Employee emp) {
		System.out.println("********************"+emp);
		emp.setDateOfBirth(emp.getDateOfBirth().plusDays(1));
		Employee employee = empService.addEmployee(emp);
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	
	@GetMapping
	@ApiOperation(value = "View a list of available employees sorted by first name", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<List<Employee>> getAllbyFirstname(){
		List<Employee> employees = empService.byFirstName();
		if(employees.isEmpty() || employees.size() ==0) throw new EmployeeNotFoundException("NO EMPLOYEES EXIST");
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
}
