package com.helloworld.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.helloworld.domain.User;
import com.helloworld.entity.EmployeeEntity;
import com.helloworld.entity.UserEntity;

@Repository
@Qualifier("loginDaoOperation")
public class LoginDAOOperation implements ILoginDAOOperation {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<UserEntity> checkLoginCredentials() {
		
		Boolean isValidCredential = Boolean.FALSE;
		
		List<UserEntity> users = entityManager.createQuery("Select a From UserEntity a", UserEntity.class).getResultList();
		return users;
	}

}
