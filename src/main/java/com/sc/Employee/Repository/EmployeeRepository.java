package com.sc.Employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sc.Employee.Domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findAllByOrderByFirstNameAsc();

}
