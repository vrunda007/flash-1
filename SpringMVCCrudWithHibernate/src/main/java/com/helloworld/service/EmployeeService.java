package com.helloworld.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.helloworld.dao.IEmployeeDAOOperation;
import com.helloworld.domain.Employee;
import com.helloworld.entity.EmployeeEntity;
import com.helloworld.transformer.EmployeeEntityTransformer;

@Service
@Qualifier("employeeService")
public class EmployeeService implements IEmployeeService {

	@Autowired
	@Qualifier("employeeDAOOperation")
	private IEmployeeDAOOperation employeeDAOOperation;

	@Autowired
	private EmployeeEntityTransformer employeeEntityTransformer;
	
	/* (non-Javadoc)
	 * @see com.bnt.helloworld.service.IEmployeeService#getAllEmployeeDetails()
	 */
	@Transactional
	public List<Employee> getAllEmployeeDetails() {
		List<EmployeeEntity> employeeList = employeeDAOOperation.getAllEmployeeDetails();
		
		//TRANSORM ENTITY OBJECT INTO DOMAIN OBJECT
		List<Employee> allEmployeeDetails = new ArrayList<Employee>();
		for(EmployeeEntity employeeEntity : employeeList) {
			allEmployeeDetails.add(employeeEntityTransformer.transformEmployeeEntity(employeeEntity));
		}
		
		return allEmployeeDetails;
	}

	/* (non-Javadoc)
	 * @see com.bnt.helloworld.service.IEmployeeService#insertEmployeeDetails(com.bnt.helloworld.domain.Employee)
	 */
	@Transactional
	public Boolean insertEmployeeDetails(Employee employee) {

		//TRANSORM DOMAIN OBJECT INTO ENTITY OBJECT 
		EmployeeEntity employeeEntity = employeeEntityTransformer.transformEmployee(employee);
		
		return employeeDAOOperation.insertEmployeeDetails(employeeEntity);
	}

	
	@Transactional
	public Boolean updateEmployeeDetails(Employee employee) {

		//TRANSORM DOMAIN OBJECT INTO ENTITY OBJECT 
		EmployeeEntity employeeEntity = employeeEntityTransformer.updateEmployeeById(employee);
		
		return employeeDAOOperation.updateEmployeeDetails(employeeEntity);
	}
	
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		
		 employeeDAOOperation.deleteEmployee(employeeId);
		
	}

	public Employee getEmployeeDetail(Integer employeeId) {
		
		EmployeeEntity employeeEntity =employeeDAOOperation.getEmployeeDetail(employeeId);
		
		Employee employee = employeeEntityTransformer.transformEmployeeEntity(employeeEntity);
		
		return employee;
	}
	
	
	
	
	
}
