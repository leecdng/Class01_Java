<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 내용 보기</h1>
번호: ${vo.no } <br/>
작성자: ${vo.userid } <br/>
등록일: ${vo.writedate }, 조회수 ${vo.hit } <br/>
제목: ${vo.subject } <br/>
글 내용: ${vo.content }
<hr/>
<a href="#">수정</a>
<a href="#">삭제</a>
</body>
</html>