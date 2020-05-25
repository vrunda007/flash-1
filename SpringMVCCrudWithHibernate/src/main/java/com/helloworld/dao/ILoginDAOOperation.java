package com.helloworld.dao;

import java.util.List;

import com.helloworld.domain.User;
import com.helloworld.entity.UserEntity;

public interface ILoginDAOOperation {

	public List<UserEntity> checkLoginCredentials();
}
