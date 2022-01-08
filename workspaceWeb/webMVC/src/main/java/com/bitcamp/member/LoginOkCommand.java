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
		// ���̵�� ��й�ȣ request
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		// �α����� �����ϸ� userid, username ���� // DB�۾��� DAO���� �� ��
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.loginOk(userid, userpwd);
		
		// �α��� ����
		String viewFile = "";
		if(vo.getUsername()!=null && !vo.getUsername().equals("")) {
			// ���ǿ� ���̵�, �̸��� session ����Ѵ�.
			HttpSession ses = request.getSession();
			ses.setAttribute("userid", vo.getUserid());
			ses.setAttribute("username", vo.getUsername());
			
			viewFile = "/index.jsp";
		} else { // �α��� ����
			viewFile = "login.jsp";
		}
		return viewFile;
	}

}
