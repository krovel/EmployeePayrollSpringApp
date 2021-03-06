package com.cg.employeepayroll.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	@Pattern(regexp="^^[A-Z]{1}[a-z]{2,}([ ][A-Z]{1}[a-z]{2,})?$",message="Employee Name Invalid")
	public String name;
	@Min(value=30000,message="Employee Wage should be more than 30000")
	public long salary;
	@Pattern(regexp="male|female",message="Gender needs to be male or female")
	public String gender;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@NotNull(message="startDate should not be empty")
	@PastOrPresent(message="startDate should be past or todays date")
	public LocalDate startDate;
	
	@NotBlank(message="note should not be blank")
	public String note;
	@NotBlank(message="profilePic should not be blank")
	public String profilePic;
	
	@NotNull(message="deprtment should not be empty")
	public List<String> department;
}