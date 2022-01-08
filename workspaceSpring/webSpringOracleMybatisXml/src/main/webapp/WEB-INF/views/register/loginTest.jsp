<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>로그인</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jsbn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/rsa.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/prng4.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/rng.js"></script>
<script type="text/javascript">
	// 비밀번호 암호화
	function frm_check(){
		var RSAModulus = document.getElementById("RSAModulus").value;
		var RSAExponent = document.getElementById("RSAExponent").value;
		
		var pw = document.getElementById("userpwd").value;

		// rsa 암호화
		var rsa = new RSAKey();
		rsa.setPublic(RSAModulus, RSAExponent);
		document.getElementById("userpwd").value = rsa.encrypt(pw);
		console.log(pw);
		

	}

</script>
</head>
<body>
<h1>로그인 테스트</h1>
<form id="loginForm" method="post" action="actionLogin" onsubmit="return frm_check();">
	<label for="userid"></label>
	<input type="text" id="userid" name="userid" maxlength="16"/>
	
	<label for="userpwd"></label>
	<input type="password" id="userpwd" name="userpwd" maxlength="16"/>
	
	<!-- hidden -->
	<input type="hidden" id="RSAModulus" value="${RSAModulus}"/>
	<input type="hidden" id="RSAExponent" value="${RSAExponent}"/>
	
	<input type="submit" value="Login"/>
</form>
</body>
</html>