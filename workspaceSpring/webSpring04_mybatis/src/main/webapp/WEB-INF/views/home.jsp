<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>
	홈 ${username } 
	<a href="/myapp/logout">로그아웃</a>
	<a href="/myapp/list">게시판</a>
	<a href="/myapp/transactionTest">트랜잭션 테스트</a>
</h1>

<form method="post" action="/myapp/loginOk">
	아이디: <input type="text" name="userid"/>
	비밀번호: <input type="password" name="userpwd"/>
	<input type="submit" value="로그인"/>
</form>
</body>
</html>
