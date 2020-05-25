package com.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloworld.dao.HelloDAOOperation;

@Service
public class HelloService {
	
	@Autowired
	private HelloDAOOperation helloDAOOperation;
	
	public String returnUserName() {
		System.out.println("Welcome User Service is invoked...");
		return helloDAOOperation.fetchUsernamefromDB();
	}
}
