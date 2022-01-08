<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>choose Tag : 다중 if문, switch문</h1>
이름 : ${param.name } <br/>
나이 : ${param.age } <br/>
<c:choose>
	<c:when test="${param.name=='hong'}"> <!-- $가 output이라고 보면 됨 -->
      당신의 이름은 ${param.name }입니다.<br/>
   </c:when>
   <c:when test="${param.age==25 }">
      당신의 나이는 ${param.age }입니다.<br/>
   </c:when>

	<c:otherwise>
      당신의 이름은 ${param.name }도 아니고,
      나이는 ${param.age }세도 아닙니다.
   </c:otherwise>

</c:choose>
</body>
</html>