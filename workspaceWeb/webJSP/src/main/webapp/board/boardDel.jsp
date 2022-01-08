<%@page import="com.bitcamp.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 삭제할 레코드 번호
	int no = Integer.parseInt(request.getParameter("no"));
	String userid = (String)session.getAttribute("logId");	

	// DB삭제
	BoardDAO dao = new BoardDAO();
	int result = dao.boardDelete(no, userid);
	
	// 페이지 이동
	if(result > 0){ // 삭제..
		response.sendRedirect(request.getContextPath() + "/board/boardList.jsp");
	} else{
		response.sendRedirect(request.getContextPath() + "/board/boardView.jsp?no=" + no);
	}
%>