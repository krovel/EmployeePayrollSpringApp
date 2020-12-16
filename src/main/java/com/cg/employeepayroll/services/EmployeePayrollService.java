package com.cg.employeepayroll.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.employeepayroll.dto.EmployeePayrollDTO;
import com.cg.employeepayroll.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeeDataList = new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeDataList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeeDataList.get(empId - 1);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData((employeeDataList.size() + 1), employeePayrollDTO);
		employeeDataList.add(employeeData);
		return employeeData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeeData = this.getEmployeePayrollDataById(empId);
		employeeData.setName(employeePayrollDTO.name);
		employeeData.setSalary(employeePayrollDTO.salary);
		employeeDataList.set((empId - 1), employeeData);
		return employeeData;
	}

	@Override
	public void deleteEmployeePayrolllData(int empId) {
		employeeDataList.remove(empId-1);
	}
}