package com.bitcamp.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcamp.home.CommandService;

public class LoginOkCommand implements CommandService {

	public LoginOkCommand() {
		
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 아이디와 비밀번호 request
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		// 로그인이 성공하면 userid, username 선택 // DB작업은 DAO에서 할 것
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.loginOk(userid, userpwd);
		
		// 로그인 성공
		String viewFile = "";
		if(vo.getUsername()!=null && !vo.getUsername().equals("")) {
			// 세션에 아이디, 이름을 session 기록한다.
			HttpSession ses = request.getSession();
			ses.setAttribute("userid", vo.getUserid());
			ses.setAttribute("username", vo.getUsername());
			
			viewFile = "/index.jsp";
		} else { // 로그인 실패
			viewFile = "login.jsp";
		}
		return viewFile;
	}

}
