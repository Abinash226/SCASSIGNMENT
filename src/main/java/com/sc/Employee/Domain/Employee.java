package com.sc.Employee.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String gender;
	private String department;
	private String dateOfBirth;

	/*public static Comparator<Employee> byFirstName = 
			(Employee o1, Employee o2)->o1.getFirstName().compareTo(o2.getFirstName());*/

}
