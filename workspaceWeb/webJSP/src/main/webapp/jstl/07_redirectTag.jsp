<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 게시판 목록으로 페이지 이동 -->
<c:redirect url="../board/boardList.jsp">
	<c:param name="nowPage">7</c:param> <!-- 사이에 value값을 써도 됨 -->
	<c:param name="searchWord" value="벤츠"/>
</c:redirect>