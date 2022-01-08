package com.bitcamp.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginForm.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�α�����
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.print("<html><head><title>�α��ο�</title><script>");
		pw.print("function logChk() { if(document.getElementById('userid').value == '')");
		pw.print("{alert('���̵� �Է��ϼ���.'); return false;}");
		pw.print("if(document.getElementById('userpwd').value=='')");
		pw.print("{alert('��й�ȣ�� �Է��ϼ���.'); return false;} return true;}</script>");
		pw.print("<body>");
		pw.print("<h1>�α�����</h1>");
		pw.print("<form method='post' action='/webServlet/loginForm.do' onsubmit='return logChk()'>");
		pw.print("���̵�: <input type='text' name='userid' id='userid'/><br/>");
		pw.print("��й�ȣ: <input type='password' name='userpwd' id='userpwd'/><br/>");
		pw.print("<input type='submit' value='�α���'/></form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �α����ϱ�
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		driverLoading();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##scott", "tiger");
			
			String sql = "select userid, username from register where userid=? and userpwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {	// �α��� ����
				HttpSession sesstion = request.getSession();
				
				sesstion.setAttribute("userid", rs.getString(1));
				sesstion.setAttribute("username", rs.getString(2));
				
				System.out.println(sesstion.getId());
				System.out.println(sesstion.getAttribute("userid"));
				System.out.println(sesstion.getAttribute("username"));
				
				response.sendRedirect(request.getContextPath() + "/index.do");
			} else {	// �α��� ����
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter pw = response.getWriter();
				pw.print("<script>");
				pw.print("alert('�ٽ� �α����ϼ���.');");
				pw.print("history.back();");
				pw.print("</script>");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// DB ���� �ݱ� - ���� �� �ϸ� �� �� ��? �� �ɸ�
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void driverLoading() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
