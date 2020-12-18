package com.cg.employeepayroll.model;

import java.time.LocalDate;

import java.util.List;

import com.cg.employeepayroll.dto.EmployeePayrollDTO;

import lombok.Data;


public @Data class EmployeePayrollData {
	private int empId;
	private String name;
	private long salary;
	
	public String gender;
	public LocalDate startDate;
	public String note;
	public String profilePic;
	public List<String> department;

	public EmployeePayrollData() {

	}

	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		this.empId=empId;
		this.updateEmployeePayrollData(empPayrollDTO);
	}
   
	public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.name=empPayrollDTO.name;
		this.salary=empPayrollDTO.salary;
		this.gender=empPayrollDTO.gender;
		this.startDate=empPayrollDTO.startDate;
		this.note=empPayrollDTO.note;
		this.profilePic=empPayrollDTO.profilePic;
		this.department=empPayrollDTO.department;
		
	}
}