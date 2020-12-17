package com.cg.employeepayroll.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeepayroll.dto.EmployeePayrollDTO;
import com.cg.employeepayroll.model.EmployeePayrollData;
import com.cg.employeepayroll.repository.EmployeeRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeeDataList = new ArrayList<>();
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		employeeDataList.clear();
		employeeRepository.findAll().forEach(employee -> employeeDataList.add(employee));
		 return employeeDataList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeeRepository.findById(empId).get();
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeeData = new EmployeePayrollData(employeePayrollDTO.getName(), employeePayrollDTO.getSalary());
		employeeData = employeeRepository.save(employeeData);
		employeeDataList.add(employeeData);
		return employeeData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeeData = this.getEmployeePayrollDataById(empId);
		if(employeeData != null) {
			employeeDataList.remove(employeeData);
			deleteEmployeePayrolllData(empId);
			employeeData.setName(employeePayrollDTO.getName());
			employeeData.setSalary(employeePayrollDTO.getSalary());
			employeeData = employeeRepository.save(employeeData);
			employeeDataList.add(employeeData);
		}
		return employeeData;
	}

	@Override
	public void deleteEmployeePayrolllData(int empId) {
		EmployeePayrollData employeeData = this.getEmployeePayrollDataById(empId);
		if(employeeData != null) {
			employeeDataList.remove(employeeData);
		}
		employeeRepository.deleteById(empId);
	}
}