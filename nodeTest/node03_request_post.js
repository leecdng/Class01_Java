var http = require('http');
var querystring = require('querystring');

var server = http.createServer(function(request, response){
	// post 방식으로 서버에 접속할 경우
	// 서버로 전송된 데이터를 누적시킬 변수
	var postData = "";

	// form의 데이터가 서버에 전송되면 data 이벤트가 발생한다.
	//			이벤트명,			전송된 데이터
	request.on('data', function(data){
		postData += data; // 누적됨
	});
	
	// 데이터 전송이 완료되면 end 이벤트가 발생
	request.on('end', function(){
		var parseQuery = querystring.parse(postData);
		console.log('postData->' + postData);
		//console.log('parseQuery->' + parseQuery);

		response.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
		response.write('아이디=' + parseQuery.userid);
		response.end('<br/>비밀번호=' + parseQuery.userpwd);
	});

}).listen(10002, function(){
	console.log('http;//127.0.0.1:10002');
});