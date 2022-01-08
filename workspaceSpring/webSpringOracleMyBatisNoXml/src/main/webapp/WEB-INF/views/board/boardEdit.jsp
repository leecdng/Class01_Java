<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 수정</h1>
<form method="post" action="board/boardEditOk">
	제목 : <input type="text" name="subject" value="${vo.subject }"/><br/>
	글 내용: <textarea name="content" rows="10" cols="100">${vo.content }</textarea><br/>
	<input type="hidden" name="no" value="${vo.no }"/><br/>
	<input type="submit" value="글수정"/>
</form>
</body>
</html>