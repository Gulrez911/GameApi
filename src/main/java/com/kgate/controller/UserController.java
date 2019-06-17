package com.kgate.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kgate.entity.User;
import com.kgate.entity.UserGame;
import com.kgate.entity.UserLogin;
import com.kgate.exception.ResourceNotFoundExceptionTest;
import com.kgate.repository.UserGameRepository;
import com.kgate.repository.UserRepository;
import com.kgate.service.UserService;

@RestController
@SessionAttributes("userLogin")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	UserRepository repo;
	@Autowired
	UserGameRepository gamerepo;

	private static Logger logger = LogManager.getLogger(UserController.class);

	public UserController() {
	}

	@GetMapping("/downloadExcel")
	public ModelAndView downloadExcel() {

		UserGame game = new UserGame();
		List<UserGame> usergame = userService.getUserGame(game);
		return new ModelAndView("excelView", "usergame", usergame);
	}

//	@GetMapping("/")
//	public ModelAndView home() {
//		return login();
//	}
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		UserLogin userLogin = new UserLogin();
		mav.addObject("userLogin", userLogin);
		return mav;
	}

	@GetMapping({ "/validateMobile/{mobile}" })
	public ResponseEntity<?> validateMobile(
			@org.springframework.web.bind.annotation.PathVariable("mobile") Long mobile) {
		System.out.println("method called");

		User user2 = null;
		try {
			user2 = userService.checkmobile(mobile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (user2 == null) {
			return ResponseEntity.ok().body("nok");
		}

//		user2.setUserGame(null);
		System.out.println("mobile:  " + user2.getMobile());
		return ResponseEntity.ok().body("ok");
	}

	@GetMapping("/backadmin")
	public ModelAndView backadmin(@SessionAttribute("userLogin") UserLogin userLogin) {

		ModelAndView mav = new ModelAndView("report");
		User user = new User();
		UserLogin userLogin2 = null;
		try {
			userLogin2 = userService.authenticate(userLogin.getUsername(), userLogin.getPassword());
		} catch (Exception e) {
		}
		List<User> listuser = userService.getUser(user);
		System.out.println("userlist: " + listuser);
		mav.addObject("listuser", listuser);
		return mav;
	}

	@PostMapping("/changePassword")
	public ModelAndView changePassword(@SessionAttribute("userLogin") UserLogin userLogin,
			@RequestParam("pass1") String pass1, @RequestParam("pass2") String pass2) {
		ModelAndView mav = new ModelAndView("changepass");
		UserLogin login = null;
		try {
			login = userService.authenticate(userLogin.getUsername(), pass1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (login == null) {
			mav.addObject("error", "incorrect old password");
		} else {
			userService.updateUser(userLogin.getUsername(), pass2);
			mav.addObject("msg", "Password successfully changed");
		}
//		System.out.println("test succ: "+login2.getPassword());
		return mav;
	}

	@PostMapping("/resetPassword")
	public ModelAndView resetPassword(@RequestParam("email") String email) {
		ModelAndView mav = new ModelAndView();
		UserLogin login = null;
		try {
			login = userService.findPassword(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (login == null) {
			mav.setViewName("resetPassword");
			mav.addObject("error", "Please insert valid email");
			return mav;
		}
		String pass = login.getPassword();
		System.out.println("pass: " + pass);
		UserController uc = new UserController();
		uc.sendMail(email, "Your Password is: " + pass, "check mail");
		UserLogin userLogin = new UserLogin();
		mav.addObject("userLogin", userLogin);
		mav.setViewName("login");
		return mav;
	}

	@GetMapping("/changePass")
	public ModelAndView changePass() {
		ModelAndView mav = new ModelAndView("changepass");
		return mav;
	}

	@GetMapping("/reset")
	public ModelAndView reset() {
		ModelAndView mav = new ModelAndView("resetPassword");
		return mav;
	}

	@PostMapping("/userLogin")
	public ModelAndView userLogin(@ModelAttribute("userLogin") UserLogin userLogin) {
		ModelAndView mav = new ModelAndView();
		logger.info("UserLogin Method called..");
		UserLogin userLogin2 = null;

		try {
			userLogin2 = userService.authenticate(userLogin.getUsername(), userLogin.getPassword());
		} catch (Exception e) {
		}
		if (userLogin2 != null) {
			mav.setViewName("report");
		} else {
			mav.addObject("error", "email or password incorrect");
			mav.setViewName("login");
		}
		System.out.println("userlogin: " + userLogin2);

		UserGame usergame = new UserGame();
		List<UserGame> game = userService.getUserGame(usergame);
		User user = new User();
		List<User> listuser = userService.getUser(user);
		System.out.println("userlist: " + listuser);
//		UserGame game = gamerepo.getOne((long) 94);
//		System.out.println("game" + game);
		mav.addObject("listuser", listuser);
		mav.addObject("userlogin", userLogin2);
		mav.addObject("listgame", game);

		return mav;
	}

	@GetMapping("/attemptinfo")
	public ModelAndView attemptinfo(@RequestParam("gameId") Long gameId,
			@RequestParam("atmptcount") String atmptcount) {
		ModelAndView mav = new ModelAndView("attemptinfo");
		System.out.println("attempt: starpoint " + gameId);
		UserGame userGame = gamerepo.getUserInfo(gameId);
		mav.addObject("atmptcount", atmptcount);
		mav.addObject("game", userGame);
		return mav;
	}

	@PostMapping({ "/saveUserGame" })
	public String saveUserGame(@RequestBody String json)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("save called");

		String url = json;
		String result = "";
		try {
			result = java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());
			System.out.println("check url:  " + result);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("json >>>>>>>> " + result);
		JSONObject jsonObject = new JSONObject(result);
		System.out.println("jsonObject >>>>>>> " + jsonObject);
		JSONObject getObject = jsonObject.getJSONObject("MainGameData");
		System.out.println("getObject >>>>>>> " + getObject);
		JSONArray getArray = jsonObject.getJSONArray("QuestionData");
		System.out.println("getArraytObject >>>>>>> " + getArray);
		/*
		 * for (int i = 0; i < getArray.length(); i++) { JSONObject innerObj =
		 * getArray.getJSONObject(i); for (Iterator it = innerObj.keys(); it.hasNext();)
		 * { String key = (String) it.next(); System.out.println(key + ":" +
		 * innerObj.get(key)); } }
		 */
		System.out.println();
//		ObjectMapper mapper = new ObjectMapper();
//		Welcome welcome = mapper.readValue(json, Welcome.class);
//		System.out.println("welcome>>>   " + welcome);

		String phone = (String) getObject.get("phoneNumber");
		String feedback = (String) getObject.get("feedback");
		String duration = (String) getObject.get("Duration");
		String dateTime = (String) getObject.get("DateTime");
		String percentage = (String) getObject.get("Percentage");
		System.out.println("done: " + phone + " " + feedback + " " + duration + " " + dateTime + " "
				+ percentage);
		UserGame q2 = new UserGame();
//		for (int i = 0; i < getArray.length(); i++) {
		JSONObject objects1 = getArray.getJSONObject(0);

//			Question q2 = new Question();
		String objective1 = (String) objects1.get("objective");
		String qNo1 = (String) objects1.get("qNo");
		String question1 = (String) objects1.get("question");
		String option1 = (String) objects1.get("option");
		String result1 = (String) objects1.get("result");
		String type1 = (String) objects1.get("type");
		System.out.println("question: " + objective1 + " " + qNo1 + " " + question1 + " " + option1 + " "
				+ result1 + " " + type1);
		q2.setMobile(phone);
		q2.setFeedback(feedback);
		q2.setDuration(duration);
		q2.setDateTime(dateTime);
		q2.setPercentage(percentage);
		q2.setObjective(objective1);
		q2.setqNo1(Integer.parseInt(qNo1));
		q2.setQ1(question1);
		q2.setQa1(option1);
		q2.setRestult1(result1);
		q2.setType1(type1);

		JSONObject objects2 = getArray.getJSONObject(1);

//			Question q2 = new Question();
		String objective2 = (String) objects2.get("objective");
		String qNo2 = (String) objects2.get("qNo");
		String question2 = (String) objects2.get("question");
		String option2 = (String) objects2.get("option");
		String result2 = (String) objects2.get("result");
		String type2 = (String) objects2.get("type");
		System.out.println("question: " + objective1 + " " + qNo2 + " " + question2 + " " + option2 + " "
				+ result1 + " " + type1);
//			q2.setObjective(objective);(objective);
		q2.setqNo2(Integer.parseInt(qNo2));
		q2.setQ2(question2);
		q2.setQa2(option2);
		q2.setRestult2(result2);
		q2.setType2(type2);

		JSONObject objects3 = getArray.getJSONObject(2);

//			Question q2 = new Question();
		String objective3 = (String) objects3.get("objective");
		String qNo3 = (String) objects3.get("qNo");
		String question3 = (String) objects3.get("question");
		String option3 = (String) objects3.get("option");
		String result3 = (String) objects3.get("result");
		String type3 = (String) objects3.get("type");
		System.out.println("question: " + objective3 + " " + qNo3 + " " + question3 + " " + option3 + " "
				+ result3 + " " + type3);
		q2.setqNo3(Integer.parseInt(qNo3));
		q2.setQ3(question3);
		q2.setQa3(option3);
		q2.setRestult3(result3);
		q2.setType3(type3);

		JSONObject objects4 = getArray.getJSONObject(3);

//			Question q2 = new Question();
		String objective4 = (String) objects4.get("objective");
		String qNo4 = (String) objects4.get("qNo");
		String question4 = (String) objects4.get("question");
		String option4 = (String) objects4.get("option");
		String result4 = (String) objects4.get("result");
		String type4 = (String) objects4.get("type");
		System.out.println("question: " + objective4 + " " + qNo4 + " " + question4 + " " + option4 + " "
				+ result4 + " " + type4);
		q2.setqNo4(Integer.parseInt(qNo4));
		q2.setQ4(question4);
		q2.setQa4(option4);
		q2.setRestult4(result4);
		q2.setType4(type4);

		JSONObject objects5 = getArray.getJSONObject(4);

//			Question q2 = new Question();
		String objective5 = (String) objects5.get("objective");
		String qNo5 = (String) objects5.get("qNo");
		String question5 = (String) objects5.get("question");
		String option5 = (String) objects5.get("option");
		String result5 = (String) objects5.get("result");
		String type5 = (String) objects5.get("type");
		System.out.println("question: " + objective5 + " " + qNo5 + " " + question5 + " " + option5 + " "
				+ result5 + " " + type5);
		q2.setqNo5(Integer.parseInt(qNo5));
		q2.setQ5(question5);
		q2.setQa5(option5);
		q2.setRestult5(result5);
		q2.setType5(type5);

		JSONObject objects6 = getArray.getJSONObject(5);

//			Question q2 = new Question();
		String objective6 = (String) objects6.get("objective");
		String qNo6 = (String) objects6.get("qNo");
		String question6 = (String) objects6.get("question");
		String option6 = (String) objects6.get("option");
		String result6 = (String) objects6.get("result");
		String type6 = (String) objects6.get("type");
		System.out.println("question: " + objective6 + " " + qNo6 + " " + question6 + " " + option6 + " "
				+ result6 + " " + type6);
		q2.setqNo6(Integer.parseInt(qNo6));
		q2.setQ6(question6);
		q2.setQa6(option6);
		q2.setRestult6(result6);
		q2.setType6(type6);

		JSONObject objects7 = getArray.getJSONObject(6);

//			Question q2 = new Question();
		String objective7 = (String) objects7.get("objective");
		String qNo7 = (String) objects7.get("qNo");
		String question7 = (String) objects7.get("question");
		String option7 = (String) objects7.get("option");
		String result7 = (String) objects7.get("result");
		String type7 = (String) objects7.get("type");
		System.out.println("question: " + objective7 + " " + qNo7 + " " + question7 + " " + option7 + " "
				+ result7 + " " + type7);
		q2.setqNo7(Integer.parseInt(qNo7));
		q2.setQ7(question7);
		q2.setQa7(option7);
		q2.setRestult7(result7);
		q2.setType7(type7);

		JSONObject objects8 = getArray.getJSONObject(7);

//			Question q2 = new Question();
		String objective8 = (String) objects8.get("objective");
		String qNo8 = (String) objects8.get("qNo");
		String question8 = (String) objects8.get("question");
		String option8 = (String) objects8.get("option");
		String result8 = (String) objects8.get("result");
		String type8 = (String) objects8.get("type");
		System.out.println("question: " + objective8 + " " + qNo8 + " " + question8 + " " + option8 + " "
				+ result8 + " " + type8);
		q2.setqNo8(Integer.parseInt(qNo8));
		q2.setQ8(question8);
		q2.setQa8(option8);
		q2.setRestult8(result8);
		q2.setType8(type8);
//			q2.setqNo(qNo);
//			q2.setOptions(option);
//			q2.setQuestion(question);
//			q2.setResult(result);
//			q2.setType(type);
//			q2.setMobile((long) 3242342);
//			listquestion.add(q2);

//			}

//		}
		UserGame user = null;
		try {
			user = userService.addUserGame(q2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * if (user == null) { return
		 * ResponseEntity.ok().body("Mobile No. Doesn't Exist"); }
		 * 
		 * return ResponseEntity.ok().body("user saved...  ");
		 */
		return "save successfully";
	}

	@GetMapping({ "/getUserDetails/{mobile}" })
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

	@PostMapping({ "/saveUser" })
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		System.out.println("save called");
		User usr = userService.saveUser(user);

		return ResponseEntity.ok().body("user saved...  " + usr);
	}

	public void sendMail(String to, String message, String subject) {
//		final Employee e = new Employee();
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("gulfarooqui1@gmail.com", "Gulrez#7326");
			}

		});

		Message message1 = new MimeMessage(session);

		try {

			message1.setFrom(new InternetAddress("test@gmail.com"));
			message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message1.setSubject(subject);
			message1.setText(message);

			Transport.send(message1);

			System.out.println("Done");

		} catch (MessagingException e1) {
			throw new RuntimeException(e1);
		}
		// return "employeelist";

	}
}