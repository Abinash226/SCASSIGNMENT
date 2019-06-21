package com.sc.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Api("Set of endpoints for Creating, Retrieving, Updating and Deleting of Employees.")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping
	@ApiOperation("Creates a new Employee.")
	public ResponseEntity<Employee> addEmployee(@ApiParam("Personal information for a new Employee to be created.") @RequestBody Employee emp) {
		Employee employee = empService.addEmployee(emp);
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	
	@GetMapping
	@ApiOperation("Fetches an employee ordered by Firstname.")
	public ResponseEntity<List<Employee>> getAllbyFirstname(){
		List<Employee> employees = empService.byFirstName();
		if(employees.isEmpty() || employees.size() ==0) throw new EmployeeNotFoundException("NO EMPLOYEES EXIST");
		return new ResponseEntity<List<Employee>>(empService.byFirstName(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Deletes all employee.")
	public ResponseEntity<HttpStatus> removeEmployee (@PathVariable("id") Long id)
	{
		empService.deleteAll(id);
	    return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}

}
