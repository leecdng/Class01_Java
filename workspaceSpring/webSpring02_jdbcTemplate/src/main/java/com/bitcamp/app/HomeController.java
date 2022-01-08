package com.bitcamp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	public JdbcTemplate template;
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constants.template = template;
	}



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {

		
		return "home";
	}
	
}