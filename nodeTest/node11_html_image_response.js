var http = require('http');
var fs = require('fs');

// 모듈 추가하는 방법 : mime
// npm 명령어를 이용하여 추가
// > npm install mime@2.5.2
var mime = require('Mime');
const { getFips } = require('crypto');


var server = http.createServer(function(request, response){
    var addr = request.url; // /images/wbb2.jpg    /subpage
    // 원래 url 객체 따로 만들어줬는데(?) 버전 업 되면서 그냥 이렇게 써도 되는 듯 (?)
    console.log("addr->" + addr);
    var path = __dirname;

    if(addr == '/home'){ // 홈페이지로 접속
        // home.html  문서를 읽기를 하여 response에 쓰기
        fs.readFile(path + '/home.html', 'utf-8', function(error, readData){
            // 파일을 읽으면 실행
            if(error){ // 파일 읽기 에러 발생
                console.log('파일 읽기 실패...home.html');
            }else{
                response.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
                response.end(readData); // 읽어온 데이터
            }
        });
    } else if(addr.indexOf('/images')==0){ // 이미지 접속
        var resource = addr.substring(1); // / 앞에 거 하나 없앰
        console.log('resource->' + resource);

        // 마임을 구하기
        var mimeName = mime.getType(resource);
        console.log('mimeName->' + mimeName);

        fs.readFile(path + addr, function(error, imgData){
            if(!error){
                response.writeHead(200, {'Content-Type': mimeName});
                response.end(imgData);
            }
        });
    } else if(addr == '/subpage'){
        fs.readFile(path + '/home_subpage.html','utf-8',function(error, data){
            if(!error){
                response.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
                response.end(data);
            }
        });
    }
});

server.listen(10007, function(){
    console.log('server start.....');
    console.log("http://127.0.0.1:10007/home");
});