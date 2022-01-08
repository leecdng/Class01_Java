package com.seoul.myapp.register;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	// 로그인
	@RequestMapping(value="/loginOk")
	public String loginOk(String userid, String userpwd, HttpSession session) {
		RegisterVO vo = new RegisterVO();
		RegisterDAO dao = new RegisterDAO();
		vo = dao.selectUser(userid, userpwd);
		
		session.setAttribute("logId", vo.getUserid());
		session.setAttribute("logPwd", vo.getUserpwd());
		session.setAttribute("logName", vo.getUsername());
		
		return "loginOk";
	}
	
	// 로그아웃
	@RequestMapping(value="logoutOk")
	public String logoutOk(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
