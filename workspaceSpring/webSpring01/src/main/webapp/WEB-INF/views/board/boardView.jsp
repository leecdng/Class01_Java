<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>

	$(function(){
		// 해당 게시물의 댓글 목록 구하기
		function replyList(){
			var rParam = 'no=${bvo.no}';
			var rUrl = '/myapp/replyList';
			$.ajax({
				url: rUrl,
				data: rParam,
				success: function(result){
					var $result = $(result);
					var tag = '';
					$result.each(function(idx, vo){
						tag+= '<li><div>' + vo.userid + ' (' + vo.writedate + ') ';
						if(vo.userid=='${logid}'){ // 본인이 쓴 댓글일 때 ---- 세션값 가져오지만 ''가 없음!
							// 수정, 삭제 버튼
							tag += '<input type="button" value="수정"/>';
							tag += '<input type="button" value="삭제" title="'+ vo.num +'" />';
							tag += '<br/>' + vo.coment + '</div>';
							// 수정폼
							tag += '<div style="display:none;">';
							tag += '<form method="post">';
							tag += '<textarea name="coment">' + vo.coment + '</textarea>';
							tag += '<input type="submit" value="Edit" />';
							tag += '<input type="hidden" name="num" value="' + vo.num +'"/>'; // 댓글번호
							tag += '</form></div></li>';
						}else{ // 본인이 쓴 댓글이 아닐 때
							tag += '<br/>' + vo.coment + '</div></li>';
						}
					});
					console.log(tag);
					$('#replyList').html(tag);
				}, error: function(){
					console.log('댓글 목록 조회 에러d');
				}
			});
		}
		
		
		// 댓글 등록 시
		$('#replyBtn').click(function(){
			// 댓글 내용을 입력하지 않은 경우
			if($('#coment').val()==''){
				alert('댓글 내용을 입력하세요.');
			} else{
				// 폼의 데이터를 전송데이터로 변환해주는 함수
				var params = $('#replyFrm').serialize(); // coment=댓내용&no=34 --- 이런 형식으로 데이터를 저장
				// 서버에 댓글을 등록하는 ajax 호출
				$.ajax({
					url: '/myapp/replyWrite',
					type: 'POST',
					data: params, // coment=댓내용&no=34
					success: function(result){
						if(result==0){
							alert('댓글 등록 실패');							
						} else{
							// 목록을 다시 선택한다.
							replyList();
							// 이전 입력 댓글 지우기
							$('#coment').val('');
						}
					}, error: function(){
						console.log('댓글 쓰기 에러');
					}
				});
			}
		}); // 댓 등록
		
		
		// 댓글 수정 버튼 눌렀을 때
		// $(documet) 써주는 이유: 나중에 제이쿼리로 댓 정보를 불러왔기 때문에
		$(document).on('click', '#replyList input[value="수정"]', function(){
			$(this).parent().hide(); // 댓 정보 숨기기
			$(this).parent().next().show(); // 댓 수정폼 보이기
		});
		
		// 댓글 수정 완료 시
		$(document).on('submit', '#replyList form', function(){
			var url = '/myapp/replyEditOk';
			var params = $(this).serialize(); // coment=문자&num=888
			
			$.ajax({
				url : url,
				data: params,
				type: 'POST',
				success: function(result){
					result > 0 ? replyList() : alert('댓글 수정을 실패했습니다.');
				}, error: function(e){
					console.log(e.responseText);
				}
			});
			return false; // submit은 action으로 이동하여 페이지가 실행됨 ---> false로 차단
		});
		
		
		// 댓글 삭제
		$(document).on('click', '#replyList input[value="삭제"]', function(){
			if(confirm('댓글을 삭제하시겠습니까?')){
				var params = "num=" + $(this).attr('title');
				$.ajax({
					url: '/myapp/replyDel',
					data: params,
					success: function(result){
						replyList();
					}
					
				});
			}
		});
		
		
		// 댓글목록을 처리하는 함수 호출
		replyList();
	});
</script>
<h1>글내용 보기</h1>
<ul>
	<li>번호 : ${bvo.no }</li>
	<li>작성자 : ${bvo.userid }</li>
	<li>작성일 : ${bvo.writedate }, 조회수 : ${bvo.hit }</li>
	<li>제목 : ${bvo.subject }</li>
	<li>${bvo.content }</li>
	<li>
		수정
		삭제
		<a href="/myapp/boardList?nowPage=${pVo.nowPage }">목록</a>
	</li>
</ul>
<hr/>
<!-- 로그인이 된 경우 댓글 쓰기 폼을 보여준다. -->
<c:if test="${logStatus==true }">
	<form id="replyFrm" method="post">
		<textarea name="coment" id="coment" cols="50"></textarea>
		<input type="button" id="replyBtn" value="댓글쓰기"/>
		<input type="hidden" name="no" value="${bvo.no }"/> <!-- 원글 번호 -->
	</form>
</c:if>
<ul id="replyList">
	<!-- 
	<c:forEach var="rvo" items="${list }">
		<li>
			<div>${rvo.userid } (${rvo.writedate }) 
			<c:if test="${rvo.userid==logid }">
				<input type="button" value="수정"/><input type="button" value="삭제"/>
				<br/>${rvo.coment }
			</div>
			<div style="display:none;">
				<form method="post">
					<textarea name="coment">${rvo.coment }</textarea>
					<input type="submit" value="Edit" />
					<input type="hidden" name="num" value="${rvo.num }"/>
				</form>
			</c:if>
			<c:if test="${rvo.userid!=logid }">
				<br/>${rvo.coment }
			</c:if>
			</div>
		</li>
		<hr/>
	</c:forEach>
	 -->
</ul>























