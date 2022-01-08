package com.bitcamp.myapp.controller;

import java.security.PrivateKey;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.myapp.service.MemberService;
import com.bitcamp.myapp.vo.MemberVO;

@Controller
public class MemberController {
	@Inject
	MemberService memberService;
	
	@RequestMapping("/login")
	public String loginForm(HttpServletRequest request) {
		Rsa r = new Rsa();
		r.initRsa(request);
		return "register/loginTest";
	}
	
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public String loginOk(MemberVO vo, HttpSession session) {
		// 로그인
		MemberVO resultVo = memberService.loginSelect(vo);
		// 세션처리
		if(resultVo != null) {
			session.setAttribute("userid", resultVo.getUserid());
			session.setAttribute("username", resultVo.getUsername());
		}
		return "home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
	
	
	
	
	// 테스트
	@RequestMapping(value="actionLogin", method=RequestMethod.POST)
	public String actionLogin(MemberVO vo, HttpSession session) throws Exception {
		System.out.println("컨트롤러1");
		Rsa r = new Rsa();
		//로그인전에 세션에 저장된 개인키를 가져온다.
		PrivateKey privateKey = (PrivateKey) session.getAttribute(Rsa.RSA_WEB_KEY);
		System.out.println(vo.getUserpwd());
		//암호화 된 비밀번호를 복호화 시킨다.
		String password = r.decryptRsa(privateKey, vo.getUserpwd());
		/*
		// ShA 256 암호화 = 단방향 
		String sha = EgovFileScrty.encryptPassword(password);
		*/
		// vo.setUserpwd(sha);
		vo.setUserpwd(password);
		System.out.println(password);
		
		
		// 로그인
		MemberVO resultVo = memberService.loginSelect(vo);
		// 세션처리
		if(resultVo != null) {
			session.setAttribute("userid", resultVo.getUserid());
			session.setAttribute("username", resultVo.getUsername());
		}
		return "home";
	}
	
}








