package com.cg.employeepayroll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.employeepayroll.model.EmployeePayrollData;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeePayrollData, Integer>{
	
}
