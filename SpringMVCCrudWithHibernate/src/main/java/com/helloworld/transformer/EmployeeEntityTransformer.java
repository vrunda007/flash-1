package com.helloworld.transformer;

import org.springframework.stereotype.Service;

import com.helloworld.domain.Employee;
import com.helloworld.entity.EmployeeEntity;

@Service
public class EmployeeEntityTransformer {
	
	public Employee transformEmployeeEntity(
			EmployeeEntity entity) {		
		Employee employee = new Employee();		
		employee.setId(entity.getId());
		employee.setName(entity.getName());
		employee.setEmail(entity.getEmail());
		employee.setTelephone(entity.getTelephone());		
		employee.setAddress( entity.getAddress());			
		return employee;
	}
	
	public EmployeeEntity transformEmployee(
			Employee employee) {		
		EmployeeEntity employeeEntity = new EmployeeEntity();		
		employeeEntity.setName(employee.getName());
		employeeEntity.setEmail(employee.getEmail());
		employeeEntity.setTelephone(employee.getTelephone());
		employeeEntity.setAddress(employee.getAddress());
		return employeeEntity;
	}	
	
	public EmployeeEntity updateEmployeeById(
			Employee employee) {		
		EmployeeEntity employeeEntity = new EmployeeEntity();	
		employeeEntity.setId(employee.getId());
		employeeEntity.setName(employee.getName());
		employeeEntity.setEmail(employee.getEmail());
		employeeEntity.setTelephone(employee.getTelephone());
		employeeEntity.setAddress(employee.getAddress());
		return employeeEntity;
	}
}
