<%@page import="com.bitcamp.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("UTF-8");
%>
<!-- DB에 넣고 다른 페이지로 갈 것임. 사용자가 보는 페이지가 아니니까 프론트언어 지움-->

<!-- request -->
<!-- Beans를 이용한 request - vo멤버변수, form의 name과 같은 경우 request하여 vo에 값을 세팅한다. 
	
	BoardVO vo = new BoardVO();
	id : 객체명
	class : 패키지를 포함한 클래스명
	scope : 현재 객체가 언제까지 사용가능한지 설정
	
	request, session, page, application
	리퀘스트 할 때만 // 세션에 있을 때만? / 같은 페이지에 있을 때만 / 서버가 스탑될 때까지
-->
<jsp:useBean id="vo" class="com.bitcamp.board.BoardVO" scope="page" />
<!-- form의 값을 request하여 vo에 세팅 
	name : vo 객체명
	
-->
<jsp:setProperty name="vo" property="*" /> <!-- form안에 있는 변수랑, request에 있는 변수랑 일치하는 거 모두..????????????? -->

<!-- DB등록 -->
<%
	vo.setUserid((String)session.getAttribute("logId")); // object로 데이터를 가져옴
	vo.setIp(request.getRemoteAddr());
	
	BoardDAO dao = new BoardDAO();
	int result = dao.boardInsert(vo);
	
	// 등록 여부에 따라 페이지 이동 --> response로 보내면 글 없어짐, history는 남아있음
	if(result>0){	// 글 등록됨
		response.sendRedirect("boardList.jsp");
	} else{	// 글 등록됨
		%>
			<script>
				alert("글 등록 실패하였습니다.");
				history.back(); // history.go(-1);
			</script>		
		<%
	}	
%>





















