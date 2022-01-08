package com.bitcamp.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcamp.home.CommandService;

public class LogoutCommand implements CommandService {

	public LogoutCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 로그아웃
		HttpSession session = request.getSession();
		session.invalidate(); // 세션에 있는 모든 정보 지움
		
		return "/index.jsp";
	}

}
