package com.bitcamp.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/initTest.do")
public class InitParam extends HttpServlet {

    public InitParam() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// xml�� ������ ������ request �ϱ�
		String userid = getInitParameter("userid");
		String userpwd = getInitParameter("userpwd");
		String username = getInitParameter("username");
		
		System.out.println("username=" + username);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print("<html><head><title>Init �׽�Ʈ</title></head><body>");
		pw.print("���̵� : " + userid + "<br/>");
		pw.print("��й�ȣ : " + userpwd + "<br/>");
		pw.print("�̸� : " + username + "<br/>");
		pw.print("</body></html>");
	}

}
