<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 클라이언트 측에서 보낸 데이터를 서버로 가져오기 - request가 함
	
	String username = request.getParameter("username"); // 다 String 타입으로 넘어온다.
	String tel = request.getParameter("tel");
	String addr = request.getParameter("addr");
	
	System.out.println("username"+username);
	
%>

이름 : <%=username%><br/>
연락처 : <%=tel%><br/>
주소 : <%=addr%>