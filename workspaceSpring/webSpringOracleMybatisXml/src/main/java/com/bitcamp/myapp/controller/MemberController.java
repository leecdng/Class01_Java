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
		// �α���
		MemberVO resultVo = memberService.loginSelect(vo);
		// ����ó��
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
	
	
	
	
	// �׽�Ʈ
	@RequestMapping(value="actionLogin", method=RequestMethod.POST)
	public String actionLogin(MemberVO vo, HttpSession session) throws Exception {
		System.out.println("��Ʈ�ѷ�1");
		Rsa r = new Rsa();
		//�α������� ���ǿ� ����� ����Ű�� �����´�.
		PrivateKey privateKey = (PrivateKey) session.getAttribute(Rsa.RSA_WEB_KEY);
		System.out.println(vo.getUserpwd());
		//��ȣȭ �� ��й�ȣ�� ��ȣȭ ��Ų��.
		String password = r.decryptRsa(privateKey, vo.getUserpwd());
		/*
		// ShA 256 ��ȣȭ = �ܹ��� 
		String sha = EgovFileScrty.encryptPassword(password);
		*/
		// vo.setUserpwd(sha);
		vo.setUserpwd(password);
		System.out.println(password);
		
		
		// �α���
		MemberVO resultVo = memberService.loginSelect(vo);
		// ����ó��
		if(resultVo != null) {
			session.setAttribute("userid", resultVo.getUserid());
			session.setAttribute("username", resultVo.getUsername());
		}
		return "home";
	}
	
}








