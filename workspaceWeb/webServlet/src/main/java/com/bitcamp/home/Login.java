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
		//로그인폼
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.print("<html><head><title>로그인용</title><script>");
		pw.print("function logChk() { if(document.getElementById('userid').value == '')");
		pw.print("{alert('아이디를 입력하세요.'); return false;}");
		pw.print("if(document.getElementById('userpwd').value=='')");
		pw.print("{alert('비밀번호를 입력하세요.'); return false;} return true;}</script>");
		pw.print("<body>");
		pw.print("<h1>로그인폼</h1>");
		pw.print("<form method='post' action='/webServlet/loginForm.do' onsubmit='return logChk()'>");
		pw.print("아이디: <input type='text' name='userid' id='userid'/><br/>");
		pw.print("비밀번호: <input type='password' name='userpwd' id='userpwd'/><br/>");
		pw.print("<input type='submit' value='로그인'/></form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인하기
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
			if(rs.next()) {	// 로그인 성공
				HttpSession sesstion = request.getSession();
				
				sesstion.setAttribute("userid", rs.getString(1));
				sesstion.setAttribute("username", rs.getString(2));
				
				System.out.println(sesstion.getId());
				System.out.println(sesstion.getAttribute("userid"));
				System.out.println(sesstion.getAttribute("username"));
				
				response.sendRedirect(request.getContextPath() + "/index.do");
			} else {	// 로그인 실패
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter pw = response.getWriter();
				pw.print("<script>");
				pw.print("alert('다시 로그인하세요.');");
				pw.print("history.back();");
				pw.print("</script>");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// DB 연결 닫기 - 종료 안 하면 몇 분 뒤? 락 걸림
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
