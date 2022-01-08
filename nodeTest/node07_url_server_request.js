var http = require('http');
var url = require('url');

// [[노드 전체 영역의 전역변수]]
// [1] __filename : 현재 실행 중이 파일의 이름과 경로를 절대주소로 가진다.
// [2] __dirname : 현재 실행 중인 파일의 경로를 절대주소로 가진다.

var server = http.createServer(function(req, res){ // 변수를 바꿔도 무조건 request, response 순서로 들어감
    // /address : 주소, / name : 이름 / tel : 연락처

    // 1. 실제 접속한 주소
    console.log('실제 접속 주소(req.url) : ' + req.url); // http://127.0.0.1:10005/address

    // var urlParsing = url.parseUrl(req.url);
    // console.log('urlParsing : ' + urlParsing);

    // var pathName = urlParsing.pathName;
    // console.log('pathName : ' + pathName);
    var pathName = req.url;

    res.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
    if(pathName == '/address'){
        res.write('<h1>주소: 서울시 마포구 백범로</h1>');
    } else if(pathName == '/name'){
        res.end('<h1>이름: 홍길동</h1>');
    } else if(pathName == '/tel'){
        res.end('<h1>연락처: 010-9999-8888</h1>');
    } else {
        res.end('<h1>404 page Not Found...</h1>');
    }
});

server.listen(10005, function(){
    console.log('__filename(s) : ' + __filename);
    console.log('__dirname(s) : ' + __dirname);

    console.log('server start......... http://127.0.0.1:10005');
    console.log('server start......... http://127.0.0.1:10005/address');
    console.log('server start......... http://127.0.0.1:10005/name');
    console.log('server start......... http://127.0.0.1:10005/tel');
});