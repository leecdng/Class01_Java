<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$(function(){
		$('#down').on('click', function(){
			var url = '/webMVC/data/downCount.do';
			var params = 'num=${dataVo.num}';
			$.ajax({
				url: url,
				data: params,
				success: function(result){
					var cnt = result.split("downCount");
					$('#cnt').text(cnt[1]);
				}, error: function(){
					console.log('다운로드횟수 증가 실패');
				}
			});
		});
	});
</script>

	<h1>글내용 보기</h1>
	<ul>
		<li>번호 : ${dataVo.num }</li>
		<li>글쓴이 : ${dataVo.userid }</li>
		<li>등록일 : ${dataVo.writedate }, 조회수 : ${dataVo.hit }, 다운로드횟수 : <span id="cnt">${dataVo.downcount }</li>
		<li>첨부파일 : <a href="/webMVC/upload/${dataVo.filename }" download id="down">${dataVo.filename }</a></li>
		<li>제목 : ${dataVo.title }</li>
		<li>
			<hr/>
			${dataVo.content }
		</li>
	</ul>