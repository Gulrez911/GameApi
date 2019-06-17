package com.kgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgate.bean.MainGameDataBean;
import com.kgate.entity.User;
import com.kgate.entity.UserGame;
import com.kgate.entity.UserLogin;
import com.kgate.exception.ResourceNotFoundExceptionTest;
import com.kgate.repository.UserGameRepository;
import com.kgate.repository.UserLoginRepository;
import com.kgate.repository.UserRepository;

@Service
@org.springframework.transaction.annotation.Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserLoginRepository userLoginRepo;

	@Autowired
	private UserGameRepository userGameRepo;
	// @Autowired
//	private MainGameDataRepository  mainGameDataRepository;

	@Override
	@org.springframework.transaction.annotation.Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserDetails(Long mobile) throws ResourceNotFoundExceptionTest {
		// TODO Auto-generated method stub
		return userRepository.findById(mobile).orElseThrow(() -> new ResourceNotFoundExceptionTest(mobile));
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public UserGame addUserGame(UserGame userGame) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * step 1 increase count of no of attempts in user - parent object
		 */
//		User user   = getUserDetails(Long.parseLong(userGame.getMobile()));
		User user = getUserDetails(Long.parseLong(userGame.getMobile()));
		if (user != null) {
			user.setNoOfAttempts(user.getNoOfAttempts() + 1);
			// userRepository.save(user);
		} else {
			throw new Exception(" user not found");
		}

		user.getUserGame().add(userGame);
		userRepository.save(user);
		return userGame;
	}

	@Override
	@Transactional
	public MainGameDataBean addMainGameData(MainGameDataBean mainGameData) {
		return null;
		// mainGameDataRepository.save(mainGameData);
	}

	@Override
	public UserLogin authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return userLoginRepo.authenticate(username, password);
	}

	@Override
	public List<UserGame> getUserGame(UserGame userGame) {
		// TODO Auto-generated method stub
		return userGameRepo.getUserGame();
	}

	@Override
	public List<User> getUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.getUser();
	}

	@Override
	public UserGame getUserInfo(Long gameId) {
		// TODO Auto-generated method stub
		return userGameRepo.getUserInfo(gameId);
	}

	@Override
	public UserLogin findPassword(String email) {
		// TODO Auto-generated method stub
		return userLoginRepo.findPassword(email);
	}

	@Override
	public void updateUser(String username, String password) {
		// TODO Auto-generated method stub
		userLoginRepo.updateUser(username, password);
	}

	@Override
	public User checkmobile(Long mobile) {
		// TODO Auto-generated method stub
		return userRepository.checkmobile(mobile);
	}

}
