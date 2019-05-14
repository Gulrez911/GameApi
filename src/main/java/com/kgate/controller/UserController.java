package com.kgate.controller;

import com.kgate.entity.User;
import com.kgate.entity.UserGame;
import com.kgate.exception.ResourceNotFoundExceptionTest;
import com.kgate.repository.UserRepository;
import com.kgate.service.UserService;
import java.io.PrintStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	UserRepository repo;

	public UserController() {
	}

	@PostMapping({ "/saveUser" })
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		System.out.println("save called");
		User usr = userService.saveUser(user);

		return ResponseEntity.ok().body("user saved...  " + usr);
	}

	@PostMapping({ "/saveUserGame" })
	public ResponseEntity<?> saveUserGame(@RequestBody UserGame userGame) {
		System.out.println("save called");
		UserGame user = null;
		try {
			user = userService.addUserGame(userGame);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user == null) {
			return ResponseEntity.ok().body("Mobile No. Doesn't Exist");
		}

		return ResponseEntity.ok().body("user saved...  ");
	}

	@org.springframework.web.bind.annotation.GetMapping({ "/getUserDetails/{mobile}" })
	public ResponseEntity<?> getUserDetails(
			@org.springframework.web.bind.annotation.PathVariable("mobile") Long mobile) {
		System.out.println("method called");

		User user2 = null;
		try {
			user2 = userService.getUserDetails(mobile);
		} catch (ResourceNotFoundExceptionTest e) {
			e.printStackTrace();
		}

		if (user2 == null) {
			return ResponseEntity.ok().body("No_User_Exists");
		}

		user2.setUserGame(null);
		System.out.println("repo:  " + user2);
		return ResponseEntity.ok().body(user2);
	}
}