<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="errorTest.jsp">
	수1 : <input type="text" name="su1"/><br/>
	수2 : <input type="text" name="su2"/><br/>
	<input type="submit" value="계산하기"/>

</form>
<h1>계산 결과</h1>
<%
	String num1 = request.getParameter("su1");
	String num2 = request.getParameter("su2");
	if(num1!=null && num2!=null && !num1.equals("") && !num2.equals("")){ // 두 개의 값이 있으면 -- 공백문자보다 null을 먼저 체크해야 함.
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		
		int add = n1 + n2;
		int mul = n1 * n2;
		
		out.println(n1+"+"+n2+"="+add+"<br/>");
		out.println(n1+"*"+n2+"="+mul+"<br/>");

	} else{
		out.println("잘못 입력된 값입니다.");
	}

%>
</body>
</html>