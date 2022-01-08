<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style>
	ul, li{
		margin:0;
		padding:0;
		list-style:none;
	}
	
	li{
		float:left;
		width:10%;
		border-bottom:1px solid #ddd;
	}
	
	li:nth-child(3n+2){
		width:80%;
	}

</style>
</head>
<body>
<ul>
<%
	// 1. Context 객체 생성
	Context ct = new InitialContext();
	Context envCtx = (Context)ct.lookup("java:comp/env");

	// 2. DataSource 객체 생성
	DataSource ds = (DataSource)envCtx.lookup("jdbc/myoracle"); // 아래 Global naming 어쩌고에 있는 거 써준 것(?)

	Connection conn = ds.getConnection();
	String sql = "select no, subject, userid from board order by no desc";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		out.println("<li>"+ rs.getInt(1) + "</li>");
		%>
			<li><%=rs.getString(2) %></li> <!-- 이 형식을 좀 더 많이 씀 -->
			<li><%=rs.getString(3) %></li>
		<%
	}
%>
</ul>
</body>
</html>
<!-- 

DBCP 설정 (DataBase Connection Pool)
데이터베이스 여러 회선 연결해놓고 임대하여 사용한다.
연결 회선보다 많은 접속이 일어나면 대기 후 연결된다.

1. DBCP framework 준비하기
	http://commons.apache.org 에서 다운로드하기
	
	POOL : commons-pool2-2.11.1-bin.zip
	Collections : commons=colections4-4.4-bin.zip
	DBCP : commons-dbcp2-2.9.0-bin.zip
	
	
2. http://www.oracle.com 에서 다운로드
	ojdbc8.jar
	
	
3. 이클립스(WEB-INF/lib)와 톰캣 서버(tomcat9.0/lib)에 복사한다.
	
	commons-collections4-4.4.jar
	commons-dbcp2-2.9.0.jar
	commons-pool2-2.11.1.jar
	ojdbc8.jar


4. CLASSPATH 설정하기
	
	commons-collections4-4.4.jar
	commons-dbcp2-2.9.0.jar
	commons-pool2-2.11.1.jar
	ojdbc8.jar
	
	
5. 톰캣의 conf/server.xml의 <GlovalNamingResouces> 
	
- 아래 내용 추가 
<Resource name="jdbc/myoracle"
auto="container"
type="javax.sql.DataSource"
driverClassName="oracle.jdbc.driver.OracleDriver"
url="jdbc:oracle:thin:@localhost:1521:xe"
username="c##scott"
password="tiger"
maxActive="20"
maxIdle="10"
maxWait="-1"
/>


6. 톰캣의 conf/context.xml의 <Context reloadable="true">태그 사이에 추가

<ResourceLink
		global="jdbc/myoracle"
		name="jdbc/myoracle"
		type="javax.sql.DataSource"
	/>
	
	
7. 이클립스의 WEB-INF/web.xml의 <web-app>태그 사이에 추가

<resource-ref>
     <description>Oracle Datasource example</description>
     <res-ref-name>jdbc/myoracle</res-ref-name>
     <res-type>javax.sql.DataSource</res-type>
     <res-auth>Container</res-auth>
  </resource-ref>


8. 톰캣의 conf/context.xml의 파일을 이클립스의 META-INF 폴더에 복사한다.

	server.xml의
	<Resource name="jdbc/myoracle"
			auto="container"
			type="javax.sql.DataSource"
			driverClassName="oracle.jdbc.driver.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:xe"
			username="c##scott"
			password="tiger"
			maxActive="20"
			maxIdle="10"
			maxWait="-1"
	/> 를 Resource 태그를 추가
	
 -->