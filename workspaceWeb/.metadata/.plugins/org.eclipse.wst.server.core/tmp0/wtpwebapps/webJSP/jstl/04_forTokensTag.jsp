<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forTokens : 문자열 토큰화하여 반복한다.</h1>
<c:forTokens var="colorName" items="빨간색, 노란색, 파란색, 주황색/, 초록색...검정색^^남색" delims=",./^">
	[${colorName }]<br/>
</c:forTokens>
</body>
</html>