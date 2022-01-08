<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container{
	height:800px;
	border:2px solid #ddd;
	width:80%;
	margin:0 auto;
}
</style>
</head>
<body>
	<!-- top.jsp include -->
	<jsp:include page="top.jsp"/> <!-- 액션태그 -->
	<div id="container">
		include 파일의 선언변수는 호환되지 않는다.
		<%
			//out.println(n); //오류남
			//out.println(name); // 오류남
		%>
	</div>
	<!-- foot.jsp include -->
	<jsp:include page="foot.jsp"/>
</body>
</html>