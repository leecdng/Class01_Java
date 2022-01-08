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
		
		// �α׾ƿ�
		HttpSession session = request.getSession();
		session.invalidate(); // ���ǿ� �ִ� ��� ���� ����
		
		return "/index.jsp";
	}

}
