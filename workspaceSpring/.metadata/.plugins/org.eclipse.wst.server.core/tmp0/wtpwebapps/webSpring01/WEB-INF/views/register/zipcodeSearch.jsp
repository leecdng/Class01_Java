<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#menu, #bottom{
		display:none;
	}
	
	#zipList > li{
		cursor:pointer;
		border:1px solid #ddd;
	}
</style>
<script>
	$(function(){
		
		$('#zip').click(function(){
			if($('#doro').val()==''){
				alert('도로명을 입력 후 우편번호 찾기를 하세요.');
			} else{
				var url='/myapp/zipFind';
				var params = 'doro=' + $('#doro').val(); // doro=이어도로
				$.ajax({
					type : 'get',
					url : url,
					data : params,
					success : function(result){
						// result에 List가 저장되어있다.
						var $result = $(result);
						var tag = "";
						$result.each(function(idx, vo){
							tag += "<li>" + vo.zipcodeFull +"</li>";
						});
						console.log(tag);
						$('#zipList').html(tag);
					}, error : function(){
						console.log('우편번호 가져오기 실패');
					}
				});	// ajax
			} // if
		}); // click
		
		$(document).on('click', '#zipList>li', function(){
				var address = $(this).text();	// 63564 제주특별자치도 서귀포시 이어도로...
				var zipcode = address.substring(0, 5);
				var addr = address.substring(6);
				
				opener.document.getElementById('zipcode').value=zipcode;
				opener.document.getElementById('addr').value=addr;
				
				window.close();
		});
		
	}); 
</script>

<div>
	<div>도로명을 입력 후 우편번호 찾기를 선택하세요.</div>
	<input type="text" name="doro" id="doro"/>
	<input type="button" id="zip" value="우편번호찾기"/>
	
	<hr/>
	<ul id="zipList">
		
	</ul>
</div>