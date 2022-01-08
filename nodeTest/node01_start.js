// node.js : 이벤트 기반 서버 프레임워크

// 1. 서버를 생성하기 위해서는 http 모듈을 객체 생성한다.
var http = require('http');

// 서버를 생성하는 함수를 http 객체를 통해서 구현한다.  // 클라이언트와 서버 간의 request, response 객체를 가지고 있음.
var server = http.createServer(function(request, response){
	// response : 접속한 클라이언트에게 정보 보내기
	
	// 1. response에 Head 정보를 설정
	response.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'}); // 200: 정상 접속이 됐을 때
	// 2. response 컨텐츠 보내기 (클라이언트에게 보낼 내용)
	response.write('<h1>노드에서 보낸 문자</h1>');
	response.write('http 모듈을 이용한 서버 접속 테스트 중....');
	// 3. response에 종료를 설정한다.
	response.end('마지막 내용...'); // 내용 안 써도 되고 그냥 마지막 것만 end를 붙여도 됨. 마지막 write에 쓰는 것..?
});


// 클라이언트의 접속대기  // 클라이언트 접속을 기다리는 함수
//			port, 콜백함수
server.listen(9999, function(){
	console.log('server in running..... http://127.0.0.1:9999');
});