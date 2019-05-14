package com.kgate.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgate.entity.User;
import com.kgate.entity.UserGame;
import com.kgate.exception.ResourceNotFoundExceptionTest;
import com.kgate.repository.UserRepository;

@Service
@org.springframework.transaction.annotation.Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@org.springframework.transaction.annotation.Transactional
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}

	@Override
	public User getUserDetails(Long mobile) throws ResourceNotFoundExceptionTest {
		// TODO Auto-generated method stub
		return userRepository.findById(mobile).orElseThrow(()-> new ResourceNotFoundExceptionTest(mobile));
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public UserGame addUserGame(UserGame userGame) throws Exception{
		// TODO Auto-generated method stub
		/**
		 * step 1 increase count of no of attempts in user - paarent object
		 */
		User user   = getUserDetails(Long.parseLong(userGame.getMobile()));
		if(user != null) {
			user.setNoOfAttempts(user.getNoOfAttempts()+1);
			//userRepository.save(user);
		}
		else {
			throw new Exception(" user npot found");
		}
		
		user.getUserGame().add(userGame);
		userRepository.save(user);
		return userGame;
	}

}
