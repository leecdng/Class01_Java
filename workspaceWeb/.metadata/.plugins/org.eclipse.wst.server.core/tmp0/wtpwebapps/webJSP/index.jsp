<!-- 지시부 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 이 뒤에 import 써도 됨 -->
<!-- %@import %> -->
<%! // 선언부
// 메서드 정의할 곳
public int sum(int a, int b){
	return a+b;
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{
		width:300px;
		height:200px;
	}
</style>
<script>
	//document.write('javascript~~~ 이게 먼저 찍힘');

</script>
</head>
<body>
<%@ include file="04_include/top.jspf" %>
<br/>
<%=session.getId()%>

<hr/>
<!-- 로그인 확인 
	로그인 상태 : 회원이름 로그아웃
	로그인이 안 된 상태 : 로그인

-->
<%
	// logId, logName
	if(session.getAttribute("logId")!=null && !session.getAttribute("logId").equals("")){ // 로그인 상태
		%>
		<%=session.getAttribute("logName")%>님, <a href="<%=request.getContextPath()%>/daum_login/logout.jsp">로그아웃</a>
		<%
	} else{ // 로그인 안 한 상태
		%>
		<a href="<%=request.getContextPath()%>/daum_login/login1.html">로그인</a>
		<%
	}
%>






<h1>JSP 첫 번째 페이지</h1>
<% // 스크립트릿
	// 자바 들어오는 곳
	
	int a = 100;
	String name ="김연경";
	
	a = a*2;
	
	out.println("a="+a); // response 했다는 것
	out.println("<img src='img/wbb2.jpg'/>");
	out.println("sum(100,200)="+sum(100,200));
	
	System.out.println("sum(56,43)="+sum(56,43)); // 콘솔에 찍힘
	
	
	for(int i=1; i<10; i++){
		out.println(i);
	}
%>
<hr/>
<h1>변수, 간단한 수식, 메서드 호출하여 결과를 클라이언트한테 보낼 때</h1>
a = <%
	out.println(a);
%>
a = <%=a%> <!-- 반드시 %=는 반드시 붙여야 함. out.print라고 생각하면 됨 -->
<br/>
a = <%=a+10 %><br/>
sum = <%=sum(5,124) %> <!-- 여기선 세미콜론 쓰면 에러남 -->

</body>
</html>