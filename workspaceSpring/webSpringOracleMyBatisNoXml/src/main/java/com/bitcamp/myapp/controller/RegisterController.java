package com.bitcamp.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myapp.service.RegisterService;
import com.bitcamp.myapp.vo.RegisterVO;

@Controller
public class RegisterController {
	@Inject
	RegisterService registerService;
	
	// �α�����
	@RequestMapping("/login")
	public String login() {
		return "register/login";
	}

	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public ModelAndView loginOk(RegisterVO vo, HttpSession session) {
		System.out.print("�α���");
		ModelAndView mav = new ModelAndView();
		RegisterVO resultvo = registerService.login(vo);
		if(resultvo !=null) { // �α����� �Ǿ��� �� 
			System.out.print("�α��μ���");
			session.setAttribute("logid", resultvo.getUserid());
			session.setAttribute("logname", resultvo.getUsername());
			mav.setViewName("redirect:/");
		} else if(resultvo ==null) { // �α��� ����
			System.out.print("�α��ν���");
			mav.setViewName("redirect:login");
		}
		return mav;
	}
	
	// �α׾ƿ�
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
}
