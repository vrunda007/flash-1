package com.helloworld.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.helloworld.dao.ILoginDAOOperation;
import com.helloworld.domain.Employee;
import com.helloworld.domain.User;
import com.helloworld.entity.EmployeeEntity;
import com.helloworld.entity.UserEntity;
import com.helloworld.transformer.EmployeeEntityTransformer;
import com.helloworld.transformer.LoginEntityTransformer;

@Service
@Qualifier("loginService")
public class Loginservice implements ILoginService {

	@Autowired
	@Qualifier("loginDaoOperation")
	ILoginDAOOperation loginDaoOperation;
	
	@Autowired
	private LoginEntityTransformer loginEntityTransformer;
	
	public List<User> checkLoginCredentials() {
		
		List<UserEntity> userList = loginDaoOperation.checkLoginCredentials();
		
		//TRANSORM ENTITY OBJECT INTO DOMAIN OBJECT
		List<User> allUserDetails = new ArrayList<User>();
		for(UserEntity userEntity : userList) {
			allUserDetails.add(loginEntityTransformer.transformUserEntity(userEntity));
		}
		
		return allUserDetails;
		
	}

}
