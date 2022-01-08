<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script>
	$(function(){
		
		// bx slider
		$('#slider').bxSlider({
			slideWidth: 800,
			slideHeight: 400,
			speed: 500,
			auto: true,
			captions: true,
			infiniteLoop: true,
			hideControlOnEnd: false,
			
			useCSS: true
		});
		
		
		// 게시판 전체선택 체크 설정
		$('#allChk').change(function(){
			console.log($(this).prop('checked'));
			if($(this).prop('checked')==true){
				$('.board-free > li > input').prop('checked', true);
			} else{
				$('.board-free > li > input').prop('checked', false);
			}
		});

	});
	
</script>


<article id="container">
	<div class="main-slide">
		<ul id="slider">
			<li><img src="img/banner1.jpg" title="Seoul Music Festival" /></li>
			<li><img src="img/banner2.jpg" title="SIBAC 2019" /></li>
			<li><img src="img/banner3.jpg" title="2019 서울전환도시 국제컨퍼런스" /></li>
			<li><img src="img/banner4.jpg" title="2019 다다다 발표대회" /></li>
			<li><img src="img/banner5.jpg" title="2019 서울인공지능챗본론" /></li>
			<li><img src="img/banner6.jpg" title="서울차 없는 날" /></li>
			<li><img src="img/banner7.jpg" title="Zero 제로페이 미국 캐나다 이벤트" /></li>
		</ul>
	</div>
	
	<div class="content">
		<h1 class="content-title">자유게시판</h1>
		<div class="board-wrap">
			<input type="checkbox" id="allChk"/>전체선택
			<ul class="board-free">
				<li class="board-col">번호</li>
				<li class="board-col">제목</li>
				<li class="board-col">작성자</li>
				<li class="board-col">작성일</li>
				<li class="board-col">조회수</li>
				
				<c:forEach var="bvo" items="${list }">
					<li><input type="checkbox" />${bvo.no }</li>
					<li><a href="list.jsp?num=1">${bvo.subject }</a></li>
					<li>${bvo.username }</li>
					<li>${bvo.writedate }</li>
					<li>${bvo.hit }</li>
				</c:forEach>
			</ul>
			<ul class="pagination">
				<li class="page-item">
					<a href="<c:if test='${pvo.nowPage > 1 }'>?nowPage=${pvo.nowPage-1 }</c:if><c:if test='${pvo.nowPage==1 }'>#</c:if>" class="page-link">prev</a>
				</li>
				<c:forEach var="i" begin="${pvo.groupStartPage }" end="${pvo.groupStartPage + pvo.oneGroupPage-1 }">
					<c:if test="${i <= pvo.totalPage}">
						<li class="page-item<c:if test='${pvo.nowPage == i }'> active</c:if>">
							<a href="?nowPage=${i }" class="page-link">${i }</a>
						</li>
					</c:if>
				</c:forEach>
				<li class="page-item">
					<a href="<c:if test='${pvo.nowPage < pvo.totalPage }'>?nowPage=${pvo.nowPage+1 }</c:if><c:if test='${pvo.nowPage == pvo.totalPage }'>#</c:if>" class="page-link">next</a>
				</li>
			</ul>
		</div>
	</div>
	
</article>