<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<h1>set태그 : 변수를 선언(c:set) 및 삭제</h1>
<!--  var: 변수명  -->
<c:set var="num" value="${1234}"/>
<c:set var="username">홍길동</c:set>
<c:set var="nowDate" value="<%=new Date() %>"/>

<hr/>
번호 : ${num }<br/>
이름 : ${username }<br/>
오늘날짜 : ${nowDate }<br/>


</body>
</html>