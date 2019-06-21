package com.sc.Employee.Domain;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	@NotNull(message = "The first Name must not be null")
	private String firstName;
	@NotNull(message = "The lastName must not be null")
	private String lastName;
	@NotNull(message = "The Gender must not be null")
	private String gender;
	private String department;
	@NotNull(message = "The DOB must not be null")
	private String dateOfBirth;

	public static Comparator<Employee> byFirstName = 
			(Employee o1, Employee o2)->o1.getFirstName().toLowerCase().compareTo(o2.getFirstName().toLowerCase());

}
