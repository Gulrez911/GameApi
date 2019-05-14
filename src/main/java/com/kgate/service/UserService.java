package com.kgate.service;

import com.kgate.entity.User;
import com.kgate.entity.UserGame;
import com.kgate.exception.ResourceNotFoundExceptionTest;

public interface UserService {
	User saveUser(User user);
	
	UserGame addUserGame(UserGame userGame ) throws Exception ;
	
	User getUserDetails(Long mobile) throws ResourceNotFoundExceptionTest;
}
