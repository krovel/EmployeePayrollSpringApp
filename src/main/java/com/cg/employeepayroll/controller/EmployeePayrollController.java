package com.cg.employeepayroll.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeepayroll.dto.EmployeePayrollDTO;
import com.cg.employeepayroll.dto.ResponseDTO;
import com.cg.employeepayroll.model.EmployeePayrollData;
import com.cg.employeepayroll.services.IEmployeePayrollService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(description= "Controller to handle all requests")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@ApiOperation(value= "API to get all employees' details")
	@GetMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respDTO = new ResponseDTO("Get call for Success ", empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value= "API to get employee's details by ID")
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData empData =null;
		empData =employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO respDTO = new ResponseDTO("Get Call success for ID  ", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value= "API to get employee data by department")
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollDataByDepartment(@PathVariable("department") String department) {
		List<EmployeePayrollData> empList=null;
		empList =employeePayrollService.getEmployeePayrollDataByDepartment(department);
		ResponseDTO respDTO = new ResponseDTO("Get Call success for ID  ", empList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value= "API to add a employee payroll data")
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=null;
		log.debug(empPayrollDTO.toString());
		empData =employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created EmployeePayroll Data Success", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value= "API to update employee's details by ID")
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid@PathVariable("empId") int empId,@Valid@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=null;
		empData =employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated EmployeePayroll Data Success  ", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value= "API to delete a employee payroll data")
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id " + empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}