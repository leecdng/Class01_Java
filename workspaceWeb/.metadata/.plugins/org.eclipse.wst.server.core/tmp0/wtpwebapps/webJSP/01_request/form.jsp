<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="formOK.jsp">
	<ul>
		<li>아이디 : <input type="text" name="userid" values="goguma"/></li>
		<li>이름 : <input type="text" name="username" values="고구마"/></li>
		<li>성별 : <input type="radio" name="gender" value="F" checked/>여
		<input type="radio" name="gender" value="M"/>남</li>
		<li>관심 분야 : 
		<input type="checkbox" name="inter" value="운동"/>운동
		<input type="checkbox" name="inter" value="쇼핑"/>쇼핑
		<input type="checkbox" name="inter" value="맛집"/>맛집
		<input type="checkbox" name="inter" value="웹툰" checked/>웹툰
		<input type="checkbox" name="inter" value="영화"/>영화
		<input type="checkbox" name="inter" value="게임"/>게임</li>
		
		<li>지역 : 
			<select name="local" multiple>
				<option value="서울">서울</option>
				<option value="강원" checked>강원</option>
				<option value="전북">전북</option>
				<option value="전남">전남</option>
				<option value="경남">경남</option>
				<option value="경북">경북</option>
			</select>
		</li>
		
		<li>
			<textarea name="content">안내글.........</textarea>
		</li>
		
		<li><input type="submit" value="확인"/></li>
		<li><button>확인</button></li>
	</ul>
</form>
</body>
</html>