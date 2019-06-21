package com.sc.Employee.Domain;

import java.time.LocalDate;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ApiModel(description = "All details about the Employee. ")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated employee ID")
	private Long employeeId;
	@NotNull(message = "The first Name must not be null")
	@ApiModelProperty(notes = "The employee first name")
	@Column(nullable = false)
	private String firstName;
	@NotNull(message = "The lastName must not be null")
	@ApiModelProperty(notes = "The employee last name")
	@Column(nullable = false)
	private String lastName;
	@NotNull(message = "The Gender must not be null")
	@ApiModelProperty(notes = "The employee Gender")
	@Column(nullable = false)
	private String gender;
	@ApiModelProperty(notes = "The employee Department")
	private String department;
	@NotNull(message = "The DOB must not be null")
	@ApiModelProperty(notes = "The employee DOB")
	@Column(nullable = false)
	private LocalDate dateOfBirth;

	public static Comparator<Employee> byFirstName = 
			(Employee o1, Employee o2)->o1.getFirstName().toLowerCase().compareTo(o2.getFirstName().toLowerCase());

}
