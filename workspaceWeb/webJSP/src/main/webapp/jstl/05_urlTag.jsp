<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>url tag</h1>
<c:url var="home" value="../index.jsp"/> <!-- 데이터 안 가져감 -->

<c:url var="board" value="/board/boardList.jsp"> <!-- param에 있는 데이터들을 가지고 감 -->
	<c:param name="page" value="2"/>
	<c:param name="searchKey" value="subject"/>
	<c:param name="searchWord" value="미니"/>
</c:url>
<a href="${home }">홈</a>
<a href="${board })">게시판 목록</a>
</body>
</html>