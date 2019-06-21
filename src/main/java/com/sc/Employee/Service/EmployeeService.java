package com.sc.Employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.Employee.Domain.Employee;
import com.sc.Employee.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee addEmployee(Employee emp) {
		return empRepo.saveAndFlush(emp);
	}
	
	public List<Employee> byFirstName(){
		return empRepo.findAllByOrderByFirstNameAsc();
	}

	public void deleteAll(Long id) {
		empRepo.deleteById(id);
	}	

}
