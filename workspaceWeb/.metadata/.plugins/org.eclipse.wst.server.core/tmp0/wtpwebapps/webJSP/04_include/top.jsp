<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
#top {
	height:100px;
	background-color:pink;
}

</style>

<div id="top">
	<%
		int n = 100;
		String name = "홍길동";
	%>
	<%=n %>, <%=name %>
</div>
<div id="wrap">
