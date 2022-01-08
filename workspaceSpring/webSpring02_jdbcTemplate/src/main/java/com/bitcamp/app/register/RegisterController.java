package com.bitcamp.app.register;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	//@Autowired
	//public RegisterDAO dao; // 
	public RegisterDAO dao = new RegisterDAO();
	
	// 로그인폼
	@RequestMapping("/login")
	public String login() {
		return "register/login";
	}
	
	// 로그인 확인
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public ModelAndView loginOK(RegisterVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		RegisterVO logvo = dao.login(vo);
		//session
		if(logvo!=null) {
			session.setAttribute("userid", logvo.getUserid());
			session.setAttribute("username", logvo.getUsername());
		}
		mav.setViewName("redirect:/");
		
		return mav;
	}
}
