<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays, java.util.Enumeration"%>
<%
	// post방식의 전송 시 한글 인코딩 설정. 리퀘스트 하기 전에 인코딩 설정
	request.setCharacterEncoding("UTF-8");

	String userid = request.getParameter("userid");
	String username = request.getParameter("username");
	String gender = request.getParameter("gender");
	String inter[] = request.getParameterValues("inter"); // 관심분야
	
	String local[] = request.getParameterValues("local");
	String content = request.getParameter("content");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%=userid %><br/>
이름 : <%=username %><br/>
성별 : <%=gender %><br/>
관심분야 : 
	<%=Arrays.toString(inter) %><br/>
			<!-- for(int i=0; i<inter.length; i++){
				out.print(inter[i]);
			} -->
지역 : <%=Arrays.toString(local) %><br/>
<%=content %>
<hr/>

<h1>request 객체의 메서드</h1>
<ol>
	<li>
	<%	
		// 폼의 변수 목록을 얻어오기
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			//out.println(names.nextElement() + "<br/>");
			%>
				<%=names.nextElement() %>
			<%
		}
	
	%>
	
	</li>
	<li>접속자의 ip 정보 : <%=request.getRemoteAddr() %> </li> <!-- 접속하고 있는 사람의 IP -->
	<li>인코딩 코드값 : <%=request.getCharacterEncoding() %></li>
	<li>contentType : <%=request.getContentType() %></li> <!-- get방식일 땐 null로 나옴 -->
	<li>전송방식 : <%=request.getMethod() %></li>
	<li>프로토콜 : <%=request.getProtocol() %></li>
	<li>URI : <%=request.getRequestURI() %></li>
	<li>contextPath : <%=request.getContextPath() %></li> <!-- /webJSP  -->
	<li>서버 이름 : <%=request.getServerName() %></li>
	<li>포트번호 : <%=request.getServerPort() %></li>
	<li>절대주소 : <%=request.getServletContext().getRealPath("/")%> </li> <!--  // 현재 위치라는 뜻의 "/"  -->
</ol>

<img src="<%=request.getContextPath() %>/img/wbb2.jpg" width="300"/>
</body>


</html>






















