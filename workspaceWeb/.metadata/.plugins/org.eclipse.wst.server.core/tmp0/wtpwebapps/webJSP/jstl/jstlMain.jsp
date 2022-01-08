<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- tag libray를 사용하기 위해서 지시부를 정의해야 한다. 
c라는 이름은 계속 쓰게 될 것,.. 태그 라이브러리를 추가했다.

-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL(Jsp Standard Tag Library)</h1>
<p style="background-color:#ddd;">
	https://tomcat.apache.org/taglibs/standard 에서 라이브러리 다운로드를 한다. <br>
	<br>
	1. 압축을 푼 다음 jstl.jar, standard.jar를 이클립스의 /WEB-INF/lib 폴더 복사 <br/>
	2. 지시부에 태그 추가	
</p>
<ol>
	<li><a href="01_setTag.jsp">set Tag : 변수 선언 및 삭제</a></li>
	<li><a href="02_ifTag.jsp?name=김연경&age=32&userid=goguma">if Tag : 조건문</a></li>
	<li><a href="03_forEachTag.jsp">forEach Tag : 반복문</a></li>
	<li><a href="04_forTokensTag.jsp">forTokensTag : 반복문</a></li>
	<li><a href="05_urlTag.jsp">urlTag : url 주소를 가지는 태그</a></li>
	<li><a href="06_chooseTag.jsp?name=hong&age=25">chooseTag : 다중 if문, switch문</a></li>
	<li><a href="07_redirectTag.jsp">redirect Tag : 페이지 자동 이동</a></li>
</ol>
</body>
</html>