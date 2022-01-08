<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String logId = (String)session.getAttribute("logId");
	String logPwd = (String)session.getAttribute("logPwd");
	String logName = (String)session.getAttribute("logName");
%>

<c:if test="${(logId==null || logId=='') && (logPwd==null || logPwd=='')}">
	<script>
		alert('일치하는 회원정보가 없습니다.');
		history.back();
	</script>
</c:if>

<c:if test="${(logId!=null && logId!='') && (logPwd!=null && logPwd!='')}">
	<script>
		location.href='/seoul/';
	</script>
</c:if>