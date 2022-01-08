<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
   integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
   crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>

//원래 get방식은 문자 안깨짐요 post 만 깨짐
   $(()=>{
      //비동기식으로 문자열 가져오기.
      $("#str").click(function(){
         $.ajax({
            url:"/home/ajaxStr",
            data:"num=23&name=이순신",
            success:function(result){
               $("#view").append(result)
            }
         });
      });
      //서버에서 List컬렉션 객체 가져오기(비동기식으로)
      //사용자가 보는 페이지.
      $("#lst").on('click',function(){
         var url="/home/ajaxList";  //var aaa
         var params="num=100&nick=고구마";
         $.ajax({
            url :url, //aaa
            data:params,
            success:function(r){
               
               var rr = $(r); //result 한글자만 써서r 변수는 마음대로 해도됌. 
               
               rr.each(function(idx, vo){
                  $("#view").append("<hr/>"+idx+"-->"+vo.num+":"+vo.userid+":"+vo.nick);
               });

            },error:function(e){
               console.log("List 전송 에러발생함..",e.responseText)
            }
         });
         
      });
      
      //서버에서 비동기식으로 OBJ가져오기
      $(document).on('click','#obj',function(){
         $.ajax({
            url:"/home/ajaxObject",
            success:function(result){
            	$('#view').append('<hr/>num=' + result.num + ", userid=" + result.userid + ", nick=" + result.nick);
            }
         });
      });
      
      // 서버에서 비동기식으로 Map객체 가져오기
      $(document).on('click', '#map', function(){
    	 $.ajax({
    		url: '/home/ajaxMap',
    		success: function(result){
    			
    		}
    	 });
      });
      
   });

</script>   
</head>
<body>


<input type="button" id="str" value="ajax(문자열)"/>
<input type="button" id="lst" value="ajax(list)"/>
<input type="button" id="obj" value="ajax(Object)"/>
<input type="button" id="map" value="ajax(Map)"/>

<hr/>
<div id="view"></div>
</body>
</html>