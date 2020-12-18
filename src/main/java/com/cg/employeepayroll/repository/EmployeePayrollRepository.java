package com.cg.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employeepayroll.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer>{

}