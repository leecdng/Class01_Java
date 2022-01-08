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
	
	public HomeController() { // ���� �߰����� ��
		System.out.println("Ȩ������"); // ���� ������ ������ ��ü�� ���� (�����ڸ� �����)
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // �⺻ �ּ� ���� "/"���� �� ������ ����� �´�. ""ó�� ���� ��� ����� ��.
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		System.out.println("�ִ�Ȩ�̾�");
		
		return "home";
	}
	
	
//	MVC
//	�� ---.do -> �� HomeController -> �� ---Command.java -> �� ---.jsp

//	Spring
//	�� /--- -> �� ---Controller.java�� �޼��� -> �� (/WEB-INF/views/) --- (.jsp)
//	����
//	�� / (Ȥ�� ���� ����) -> �� HomeController.java (�޼��� home()) -> �� (/WEB-INF/views/) home(.jsp)
//	�� /registerForm -> �� RegisterController.java (�޼��� registerForm()) -> �� register/form
	
}
