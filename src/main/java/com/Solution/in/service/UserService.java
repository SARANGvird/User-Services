package com.Solution.in.service;

import java.util.List;

import com.Solution.in.model.User;

public interface UserService {

	// User operation
	
	//create user
	
	User saveUser(User user);
	
	//all user
	
	List <User>getAlluser();
	
	//get single for given id
	User getUser(String Userid);
}
