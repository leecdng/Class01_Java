<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
   integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
   crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
   <h1>로그인폼</h1>
   <form method="post" action="<%=request.getContextPath()%>/member/loginOk.do">
      아이디 : <input type="text" name="userid" id="userid" /><br /> 비밀번호 : <input
         type="text" name="userpwd" id="userpwd" /><br /> <input type="submit"
         value="로그인" />
   </form>
</body>
</html>