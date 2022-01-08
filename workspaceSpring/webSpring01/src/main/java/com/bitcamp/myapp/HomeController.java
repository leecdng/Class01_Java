package com.bitcamp.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public HomeController() { // 내가 추가해준 것
		System.out.println("홈생성자"); // 서버 연결할 때마다 객체를 생성 (생성자만 실행됨)
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // 기본 주소 끝에 "/"값만 딱 있으면 여기로 온다. ""처럼 값이 없어도 여기로 옴.
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		System.out.println("있던홈이야");
		
		return "home";
	}
	
	
//	MVC
//	① ---.do -> ② HomeController -> ③ ---Command.java -> ④ ---.jsp

//	Spring
//	① /--- -> ② ---Controller.java의 메서드 -> ③ (/WEB-INF/views/) --- (.jsp)
//	예시
//	① / (혹은 값이 없음) -> ② HomeController.java (메서드 home()) -> ③ (/WEB-INF/views/) home(.jsp)
//	① /registerForm -> ② RegisterController.java (메서드 registerForm()) -> ③ register/form
	
}
