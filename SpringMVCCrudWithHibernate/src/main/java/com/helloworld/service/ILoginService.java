package com.helloworld.service;

import java.util.List;

import com.helloworld.domain.User;

public interface ILoginService {


	public List<User> checkLoginCredentials();
}
