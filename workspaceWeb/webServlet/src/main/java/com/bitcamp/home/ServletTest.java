package com.bitcamp.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index.do")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletTest() {
        super();
    }
    
    // doGet(), doPost() ������ �����
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("init");
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget"+ request.getParameter("name"));
		
		// �����ڿ��� �������� ������
		
		// ��� ����
		response.setContentType("text/html; charset=UTF-8");
		
		// Ŭ���̾�Ʈ���� ���� output ��ü �����
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>�������� Ȩ�������� �����ϱ�</title>");
		pw.println("<style>");
		pw.println("body{color:red}");
		pw.println("</style>");
		pw.println("<script>");
		pw.println("document.write('servlet �׽�Ʈ �� <br/>')");
		pw.println("</script></head><body>");
		pw.println("<h1>������ �̿��� Ȩ</h1>");
		pw.println("<a href='"+ request.getContextPath() +"/loginForm.do'><img src='/webServlet/img/05.jpg' width='500'/>�α���</a>");
		pw.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

}
