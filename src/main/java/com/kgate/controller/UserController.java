package com.kgate.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kgate.bean.LeaderBoard;
import com.kgate.entity.User;
import com.kgate.entity.UserGame;
import com.kgate.entity.UserLogin;
import com.kgate.exception.ResourceNotFoundExceptionTest;
import com.kgate.repository.UserGameRepository;
import com.kgate.repository.UserLoginRepository;
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
	@Autowired
	UserLoginRepository loginrepo;

	private static Logger logger = LogManager.getLogger(UserController.class);

	public UserController() {
	}

	@RequestMapping(value = "/downloadUserExcel.xls", method = RequestMethod.GET)
	public ModelAndView downloadUserExcel() throws ParseException {
		ModelAndView mav = new ModelAndView("excelView2");
		List<User> listUser = repo.findAll();
		mav.addObject("listUser", listUser);
		return mav;
	}

	@RequestMapping(value = "/BallOnTheBeach_PlayerInformationReport.xls", method = RequestMethod.GET)
	public ModelAndView downloadExcel() throws ParseException {
		ModelAndView mav = new ModelAndView("excelView");
		List<UserGame> listGame = gamerepo.getUserGame2();
		for (int i = 0; i < listGame.size(); i++) {
			UserGame ga = new UserGame();
			ga = listGame.get(i);
			String da = ga.getDateTime();
			da = da.replaceAll(".*,", "");
			// 01:59:37, 08-14-2019
			Date date1;
			try {
				System.out.println("da is " + da);
				date1 = new SimpleDateFormat("MM/dd/yyyy").parse(da);
				System.out.println("da parsed 1");
			} catch (Exception e) {
				System.out.println("da parsed fail 1");
				date1 = new SimpleDateFormat("MM-dd-yyyy").parse(da);
				System.out.println("da parsed 2");
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = formatter.format(date1);
			ga.setDateTime(strDate);
		}
		mav.addObject("listGame", listGame);
		return mav;
	}

//	@GetMapping("/downloadExcel")
//	public ModelAndView downloadExcel() {
//
//		UserGame game = new UserGame();
//		List<UserGame> usergame = userService.getUserGame(game);
//		return new ModelAndView("excelView", "usergame", usergame);
//	}

//	@GetMapping("/")
//	public ModelAndView home() {
//		return login();
//	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login_new");
		UserLogin userLogin = new UserLogin();
		mav.addObject("userLogin", userLogin);
		return mav;
	}

	@GetMapping("/getMaxStarPoint/{mobile}")
	public ResponseEntity<?> getMaxStarPoint(
			@org.springframework.web.bind.annotation.PathVariable("mobile") Long mobile) {
		String data = gamerepo.getMaxStarPoint(mobile.toString());
		System.out.println("starpoints: " + data);
		return ResponseEntity.ok().body(data);
	}

	@GetMapping("/getStarPoint/{mobile}")
	public ResponseEntity<?> getStarPoint(
			@org.springframework.web.bind.annotation.PathVariable("mobile") Long mobile) {
//		ModelAndView mav = new ModelAndView("login");
//		String mobile = "9833685778";
		User user = repo.getNoAttempt(mobile);
		System.out.println("user.........." + user);
		if (user == null) {
			return ResponseEntity.ok().body("no. doesn't exist");
		}
		System.out.println("no attempt: " + user.getNoOfAttempts());
//		String list2 = gamerepo.getRank(mobile.toString());
//		System.out.println("rank: " + list2);
//		List<String> list = gamerepo.getStarPoint();
//		System.out.println("star points:  " + list);
//		UserLogin userLogin = new UserLogin();
//		list2 = list2.split("\\,")[0];
//		System.out.println("rank list2::::::::::::::::;; " + list2);
//		list2 = list2 + ",";
//		String arr = list.toString().replace("[", "") // remove the right bracket
//				.replace("]", "").replaceAll("\\s", "");
//		System.out.println("1111::::::::::::::" + arr);
//		String data = (list2 + arr).toString().trim();
//		System.out.println("2::::::: " + data.replaceAll("\\s", ""));
		String list2 = gamerepo.getRank(mobile.toString());
		System.out.println("Position: " + list2.substring(list2.indexOf(",") + 1));
		list2 = list2.substring(list2.indexOf(",") + 1);
		List<Object> list = gamerepo.getlistRank();
		List<LeaderBoard> li = new ArrayList<>();
		String top = null;
//		for (int i=1;i<=3;i++) {
		Object arr1[] = (Object[]) list.get(0);
		String s1, s2, s3, s4;
		s1 = arr1[1].toString();
		Object arr2[] = (Object[]) list.get(1);
		s2 = arr2[1].toString();
		Object arr3[] = (Object[]) list.get(2);
		s3 = arr3[1].toString();
		System.out.println("Rank list: " + s1 + " " + s2 + " " + s3);
		// }

		System.out.println("testing........... " + list);
		String data = list2 + "," + s1 + "," + s2 + "," + s3;
		return ResponseEntity.ok().body(data);
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

	@GetMapping("/leaderboard")
	public ModelAndView getRankList() {
		ModelAndView mav = new ModelAndView("leaderboard");
		List<Object> list = gamerepo.getlistRank();
		List<LeaderBoard> li = new ArrayList<>();
		for (Object ob : list) {
			LeaderBoard board = new LeaderBoard();
			Object arr[] = (Object[]) ob;
			String s1, s2, s3, s4;
			s1 = arr[0].toString();
			s2 = arr[1].toString();
			s3 = arr[2].toString();
			s4 = arr[3].toString();
			System.out.println("111111111:::::: " + s1 + " " + s2 + " " + s3 + " " + s4);
			board.setMobile(Long.parseLong(s3));
			board.setStarPoints(s2);
			board.setRank(s4);
			li.add(board);
		}

		System.out.println("testing........... " + list);
		mav.addObject("list", li);
		return mav;

	}

	@GetMapping({ "/getRankListAPI" })
	public MappingJacksonValue getRankListAPI() {
		List<Object> list = gamerepo.getlistRank();
		List<LeaderBoard> li = new ArrayList<>();
		for (Object ob : list) {
			LeaderBoard board = new LeaderBoard();
			Object arr[] = (Object[]) ob;
			String s1, s2, s3, s4;
//			s1 = arr[0].toString();
			s2 = arr[1].toString();
//			s3 = arr[2].toString();
			s4 = arr[3].toString();
//			System.out.println("111111111:::::: " + s1 + " " + s2 + " " + s3 + " " + s4);
//			board.setMobile(Long.parseLong(s3));
			board.setStarPoints(s2);
			board.setRank(s4);
			li.add(board);
		}
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("starPoints");

		FilterProvider filters = new SimpleFilterProvider().addFilter("beanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(li);

		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping("/sendMail")
	public @ResponseBody Map<String, Object> sendMail() {
		Map<String, Object> map = new HashMap<>();
		UserLogin login = loginrepo.getInfo();
		UserController uc = new UserController();
		uc.sendMail("gulfarooqui09@gmail.com", "Your UserName is: " + login.getUsername()
				+ "\n Your Password is: " + login.getPassword(), "check mail");
		map.put("data", "Login and Password Send to email address");
		return map;
	}

	@GetMapping("/nextMobile")
	public ModelAndView userLogin(@RequestParam("mobile") String mobile) throws ParseException {
		ModelAndView mav = new ModelAndView("report2");
		List<UserGame> listGame = gamerepo.mobUsergame(mobile);
		User user = new User();
		List<User> listuser = userService.getUser(user);
		for (int i = 0; i < listGame.size(); i++) {
			UserGame ga = new UserGame();
			ga = listGame.get(i);
			String da = ga.getDateTime();
			da = da.replaceAll(".*,", "");
			// 01:59:37, 08-14-2019
			Date date1;
			try {
				System.out.println("da is " + da);
				date1 = new SimpleDateFormat("MM/dd/yyyy").parse(da);
				System.out.println("da parsed 1");
			} catch (Exception e) {
				System.out.println("da parsed fail 1");
				date1 = new SimpleDateFormat("MM-dd-yyyy").parse(da);
				System.out.println("da parsed 2");
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(date1);
			ga.setDateTime(strDate);
		}
		mav.addObject("listGame", listGame);
		mav.addObject("listuser", listuser);
		return mav;
	}

	@PostMapping("/userLogin")
	public ModelAndView userLogin(@ModelAttribute("userLogin") UserLogin userLogin) throws ParseException {
		ModelAndView mav = new ModelAndView();
		logger.info("UserLogin Method called..");
		UserLogin userLogin2 = null;

		try {
			userLogin2 = userService.authenticate(userLogin.getUsername(), userLogin.getPassword());
		} catch (Exception e) {
		}
		if (userLogin2 != null) {
			mav.setViewName("report2");
		} else {
			mav.addObject("error", "email or password incorrect");
			mav.setViewName("login_new");
		}
		System.out.println("userlogin: " + userLogin2);

//		UserGame usergame = new UserGame();
//		List<UserGame> game = userService.getUserGame(usergame);
		User user = new User();
		List<User> listuser = userService.getUser(user);
		System.out.println("userlist: " + listuser);
		List<UserGame> listGame = new ArrayList<>();
//		for (int i = 0; i < listuser.size(); i++) {
		User us = new User();
//		 System.out.println(listuser.get(i));
		try {

			us = listuser.get(0);
			listGame = us.getUserGame();
			System.out.println("game::::::: " + listGame);
			for (int i = 0; i < listGame.size(); i++) {
				UserGame ga = new UserGame();

				ga = listGame.get(i);
				String da = ga.getDateTime();
				System.out.println("date:::: " + da);
				System.out.println("change date::::: " + da.replaceAll(".*,", ""));
				da = da.replaceAll(".*,", "");

				Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(da);

				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String strDate = formatter.format(date1);
				System.out.println(strDate);
				ga.setDateTime(strDate);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
//		}

		mav.addObject("listGame", listGame);
		System.out.println("userlist: " + listuser);
//		UserGame game = gamerepo.getOne((long) 94);
//		System.out.println("game" + game);
		mav.addObject("listuser", listuser);
		mav.addObject("userlogin", userLogin2);
//		mav.addObject("listgame", game);

		return mav;
	}

	@GetMapping("/attemptinfo")
	public ModelAndView attemptinfo(@RequestParam("gameId") Long gameId,
			@RequestParam("atmptcount") String atmptcount, @RequestParam("mobile") Long mobile) {
		ModelAndView mav = new ModelAndView("attemptinfo");
		System.out.println("attempt: starpoint " + gameId);
		User user = repo.getNoAttempt(mobile);
		System.out.println("user attempt: " + user.getNoOfAttempts());
		User gameid = repo.getGameId(mobile);
		System.out.println("game info of user:: " + gameid.getUserGame());
		List<UserGame> gameids = gameid.getUserGame();

		UserGame userGame = gamerepo.getUserInfo(gameId);
		mav.addObject("atmptcount", atmptcount);
		mav.addObject("user", user);
		User user2 = new User();
		mav.addObject("u", user2);
		UserGame gameobj = new UserGame();
		mav.addObject("gameobj", gameobj);
//		mav.addObject("listid", gameids);
//		
		Map<Integer, Integer> map2 = new LinkedHashMap<Integer, Integer>();
		Integer list = null;
		int x = 0;
		for (UserGame game : gameids) {
			x++;
//			map2.put(game.getGameId().toString(), x);
//			System.out.println("game id;;;;;;;;;;;;;;   " + game.getGameId() + "   ...........   "
//					+ x);
			map2.put(game.getAttemptcount(), game.getAttemptcount());
		}

		for (Entry<Integer, Integer> entry : map2.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
//		map3.put(Integer.parseInt(atmptcount), Integer.parseInt(atmptcount));
		userGame.setAttemptcount(Integer.parseInt(atmptcount));
		map2.put(Integer.parseInt(atmptcount), Integer.parseInt(atmptcount));
		mav.addObject("listobj22", map2);
//		mav.addObject("listobj23", map3);
		mav.addObject("gmatmpts", gameids);
//		System.out.println("gameidsdsds:: "+gameids);
		mav.addObject("game", userGame);
		return mav;
	}

	@GetMapping("/changeAttempt")
	public ModelAndView changeAttempt(@RequestParam("attempt") int attempt, @RequestParam("mobile") String mobile) {
		ModelAndView mav = new ModelAndView("attemptinfo");
		UserGame userGame = gamerepo.getByAtmptNo(attempt, mobile);
		User gameid = repo.getGameId(Long.parseLong(mobile));
		List<UserGame> gameids = gameid.getUserGame();
		Map<Integer, Integer> map2 = new LinkedHashMap<Integer, Integer>();
		Integer list = null;
		int x = 0;
		for (UserGame game : gameids) {
			x++;
//			map2.put(game.getGameId().toString(), x);
//			System.out.println("game id;;;;;;;;;;;;;;   " + game.getGameId() + "   ...........   "
//					+ x);
			map2.put(game.getAttemptcount(), game.getAttemptcount());
		}

		for (Entry<Integer, Integer> entry : map2.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		UserGame gameobj = new UserGame();
		mav.addObject("gameobj", gameobj);
		mav.addObject("listobj22", map2);
		mav.addObject("gmatmpts", gameids);
//		System.out.println("gameidsdsds:: "+gameids);
		mav.addObject("game", userGame);
		return mav;
	}

	@PostMapping({ "/saveUserGame" })
	public ResponseEntity<?> saveUserGame(@RequestBody String json)
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
		System.out.println();
//		ObjectMapper mapper = new ObjectMapper();
//		Welcome welcome = mapper.readValue(json, Welcome.class);
//		System.out.println("welcome>>>   " + welcome);

		String phone = (String) getObject.get("phoneNumber");
		String feedback = (String) getObject.get("feedback");
		String duration = (String) getObject.get("Duration");
		String dateTime = (String) getObject.get("DateTime");
		String percentage = (String) getObject.get("Percentage");
		String starPoints = (String) getObject.get("StarPoints");
		System.out.println("done: " + phone + " " + feedback + " " + duration + " " + dateTime + " "
				+ percentage + " " + starPoints);
		UserGame q2 = new UserGame();
//		for (int i = 0; i < getArray.length(); i++) {
		System.out.println("**********************BEFORE****************************************  object 0");
		JSONObject objects1 = getArray.getJSONObject(0);
		System.out.println("**********************AFTER**************************************** object 0");
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
		q2.setStarPoints(Long.parseLong(starPoints));

		System.out.println("**********************BEFORE**************************************** 1");
		JSONObject objects2 = getArray.getJSONObject(1);
		System.out.println("**********************AFTER**************************************** 1");
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

		System.out.println("**********************BEFORE**************************************** 2");
		JSONObject objects3 = getArray.getJSONObject(2);
		System.out.println("**********************AFTER**************************************** 2");

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

		System.out.println("**********************BEFORE**************************************** 3");
		JSONObject objects4 = getArray.getJSONObject(3);
		System.out.println("**********************BEFORE**************************************** 3");

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

		System.out.println("**********************BEFORE**************************************** 4");
		JSONObject objects5 = getArray.getJSONObject(4);
		System.out.println("**********************AFTER**************************************** 4");

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

		System.out.println("**********************BEFORE**************************************** 5");
		JSONObject objects6 = getArray.getJSONObject(5);
		System.out.println("**********************AFTER**************************************** 5");
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

		System.out.println("**********************BEFORE**************************************** 6");
		JSONObject objects7 = getArray.getJSONObject(6);
		System.out.println("**********************AFTER**************************************** 6");
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
		System.out.println("**********************BEFORE****************************************  7");
		JSONObject objects8 = getArray.getJSONObject(7);
		System.out.println("**********************AFTER**************************************** 7");
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
		User user12 = repo.getNoAttempt(Long.parseLong(phone));
		System.out.println("user att:: " + user12.getNoOfAttempts());
		int i = user12.getNoOfAttempts().intValue();
		System.out.println("user att2:: " + i);
		q2.setAttemptcount(i + 1);
		UserGame user = null;
		try {
			user = userService.addUserGame(q2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (user == null) {
			return ResponseEntity.ok().body("No save");
		}

		return ResponseEntity.ok().body("saved successfully...  ");

//		return "save successfully";

	}

	@GetMapping({ "/getUserDetails/{mobile}" })
	public ResponseEntity<?> getUserDetails(
			@org.springframework.web.bind.annotation.PathVariable("mobile") Long mobile,
			@RequestBody String json) {
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

	@PostMapping({ "/savefeedback" })
	public ResponseEntity<?> savefeedback(@RequestBody String mobile) throws ResourceNotFoundExceptionTest {
		System.out.println("get feedback:>>>>>>>> " + mobile);
		String url = mobile;
		String result = "";
		try {
			result = java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());
			System.out.println("check url:>>>>>>>>  " + result);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject(result);
		System.out.println("jsonObject::::::::::::::  " + jsonObject);
		String mob = (String) jsonObject.get("mobile");
		String feed1 = (String) jsonObject.get("feedback1");
		String feed2 = (String) jsonObject.get("feedback2");
		System.out.println("mobile: " + mob);
		User user2 = userService.getUserDetails(Long.parseLong(mob));
		Long attempt = user2.getNoOfAttempts();
		int atempt = attempt.intValue();
		gamerepo.updateUserGame(mob, atempt, feed1, feed2);

		return ResponseEntity.ok().body("save");
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
				return new PasswordAuthentication("gulfarooqui1@gmail.com", "Gmail#7326");
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