package com.cg.employeepayroll.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import lombok.Data;

public @Data class EmployeePayrollDTO { 
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}([ ][A-Z]{1}[a-zA-Z\\s]{2,})?$",
			message = "Employee name is Invalid")
	public String name;
	@Min(value = 30000, message = "Salary should be more than Rs. 30,000")
	@Max(value = 100000, message = "Salary should be less than Rs. 100,000")
	public long salary;

	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}
}