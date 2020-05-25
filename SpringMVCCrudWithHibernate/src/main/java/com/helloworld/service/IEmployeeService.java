package com.helloworld.service;

import java.util.List;

import com.helloworld.domain.Employee;

public interface IEmployeeService {
	
	public List<Employee> getAllEmployeeDetails();		
	
	public Boolean insertEmployeeDetails(Employee employee);
	
	public void deleteEmployee(Integer employeeId);

	public Employee getEmployeeDetail(Integer employeeId);
	
	public Boolean updateEmployeeDetails(Employee employee);
}
