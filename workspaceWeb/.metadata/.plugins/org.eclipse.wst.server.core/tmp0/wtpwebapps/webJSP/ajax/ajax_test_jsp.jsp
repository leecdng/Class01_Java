<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	
	String tel = "010-1234-5678";
	String addr = "서울시 마포구 백범로";
%>

<h1>처리 결과</h1>
성 : <%=firstName %><br/>
이름 : <%=lastName %><br/>
연락처 : <%=tel %><br/>
주소 : <%=addr %><br/>
