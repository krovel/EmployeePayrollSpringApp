package com.cg.employeepayroll.dto;

import lombok.Data;

import com.cg.employeepayroll.model.EmployeePayrollData;

@Data
public class EmployeePayrollDTO {
	
	private String name;
	private long salary;
	
	public EmployeePayrollDTO(EmployeePayrollData employeePayroll) {
		this.setName(employeePayroll.getName());
		this.setSalary(employeePayroll.getSalary());
	}
	
	public EmployeePayrollDTO() {
		
	}
	
}