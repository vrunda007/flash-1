package com.helloworld.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.helloworld.domain.Employee;
import com.helloworld.entity.EmployeeEntity;

@Repository
@Qualifier("employeeDAOOperation")
public class EmployeeDAOOperation implements IEmployeeDAOOperation {

	@PersistenceContext
	private EntityManager entityManager;

	public List<EmployeeEntity> getAllEmployeeDetails() {
		List<EmployeeEntity> employees = entityManager.createQuery("Select a From EmployeeEntity a", EmployeeEntity.class).getResultList();
		return employees;
	}

	/* (non-Javadoc)
	 * @see com.bnt.helloworld.dao.IEmployeeDAOOperation#insertEmployeeDetails(com.bnt.helloworld.entity.EmployeeEntity)
	 */
	public Boolean insertEmployeeDetails(
			EmployeeEntity employeeEntity) {
		
		Boolean isEmployeeDetailsInserted = Boolean.FALSE;

		try {
			entityManager.persist(employeeEntity);
			isEmployeeDetailsInserted = Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("Error while inserting Employee Details :: Exception" + e);
		}
		
		return isEmployeeDetailsInserted;
	}
	
	public Boolean updateEmployeeDetails(
			EmployeeEntity employeeEntity) {
		
		Boolean isEmployeeDetailsInserted = Boolean.FALSE;

		try {
			entityManager.merge(employeeEntity);
			isEmployeeDetailsInserted = Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("Error while updateEmployeeDetails:: Exception" + e);
		}
		
		return isEmployeeDetailsInserted;
	}

	public void deleteEmployee(Integer employeeId) {
				
		entityManager.remove((EmployeeEntity) entityManager.find(EmployeeEntity.class, employeeId));
		 System.out.println("entity deleted: " + employeeId);
	}

	public EmployeeEntity getEmployeeDetail(Integer employeeId) {
		
		EmployeeEntity employeeEntity = null;
		 Query query = entityManager.createQuery("SELECT u FROM EmployeeEntity u WHERE u.id=:empId");
		    query.setParameter("empId", employeeId);
		    try {
		    	employeeEntity = (EmployeeEntity) query.getSingleResult();
		    } catch (Exception e) {
		        // Handle exception
		    	System.out.println("Error while getEmployeeDetails:: Exception" + e);
		    }
		    return employeeEntity;
	}
	
	
	
}
