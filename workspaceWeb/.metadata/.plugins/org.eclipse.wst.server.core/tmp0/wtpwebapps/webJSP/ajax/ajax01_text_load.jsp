<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style>
	#ajaxResult{
		border:1px solid #ddd;
		background-color:lightblue;
		height:200px;
	}
</style>
<script>
	$(function(){
		$('#h1').click(()=>{
			var url = 'ajax_test.txt';
			$.ajax({
				url : url,
				success : function(result){
					$('#ajaxResult').append(result); //text(), html(), append(), prepend(),...
				}, error : function(){
					console.log("읽기 실패..");
				}
			});
		});
		
		
		$('#h2').click(function(){
			//								파일명, 콜백함수	// 결과값 저장 / success:성공, error:실패
			$('#ajaxResult2').load("ajax_test.txt", function(responseText, statusTxt){
				if(statusTxt=='success'){ //읽기 성공
					$('#ajaxResult2').html(responseText);
				} else if(statusTxt=='error'){ //읽기 실패
					$('#ajaxResult2').html('받은 데이터가 없습니다.');
				}
			});
		});
	});

</script>
</head>
<body>
<h1 id="h1">jsp에서 서버에 있는 Text문서를 비동기식으로 가져오기</h1>
<div id="ajaxResult"></div>
<h1 id="h2">jsp에서 서버에 있는 Text문서를 비동기식으로 가져오기</h1>
<div id="ajaxResult2"></div>
<img src="../img/01.jpg" width="500"/>
</body>
</html>