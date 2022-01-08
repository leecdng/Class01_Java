<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function delCheck(){
		if(confirm("글을 삭제하시겠습니까?")){
			location.href="/myapp/delete?no=${bvo.no}";
		}
	}
</script>
</head>
<body>
<h1>글 내용 보기</h1>
<ul>
	<li>번호: ${bvo.no }</li>
	<li>작성자: ${bvo.userid }</li>
	<li>등록일: ${bvo.writedate }, 조회수: ${bvo.hit }</li>
	<li>제목: ${bvo.subject }</li>
	<li>글 내용<br/>
		${bvo.content }
	</li>
</ul>
<a href="/myapp/edit?no=${bvo.no }">수정</a>
<a href="javascript:delCheck()">삭제</a>
</body>
</html>