<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/app/board/writeOk">
		<h1>글쓰기</h1>
		제목 : <input type="text" name="subject"/><br/>
		내용 : <textarea name="content" cols="50" rows="10"></textarea><br/>
		<input type="submit" value="등록"/>
	</form>
</body>
</html>