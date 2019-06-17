package com.kgate.service;

import java.util.List;

import com.kgate.bean.MainGameDataBean;
import com.kgate.entity.User;
import com.kgate.entity.UserGame;
import com.kgate.entity.UserLogin;
import com.kgate.exception.ResourceNotFoundExceptionTest;

public interface UserService {
	User saveUser(User user);

	UserGame addUserGame(UserGame userGame) throws Exception;

	MainGameDataBean addMainGameData(MainGameDataBean mainGameData);

	User getUserDetails(Long mobile) throws ResourceNotFoundExceptionTest;

	UserLogin authenticate(String username, String password);

	List<UserGame> getUserGame(UserGame userGame);

	List<User> getUser(User user);
	
	UserGame getUserInfo(Long gameId);
	
	UserLogin findPassword(String email);
	
	void updateUser(String username, String password);
	
	User checkmobile(Long mobile);
}
