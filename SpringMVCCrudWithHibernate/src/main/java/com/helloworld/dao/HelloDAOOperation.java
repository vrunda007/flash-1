package com.helloworld.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDAOOperation {
	
	public String fetchUsernamefromDB() {
		System.out.println("Welcome User DAO is invoked...");
		return "Mr. Raviraj Pradhan";		
	}	
}
