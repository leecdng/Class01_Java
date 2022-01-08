var http = require('http');
var fs = require('fs');
var mime = require('Mime');

var server = http.createServer(function(request, response){
    var mapping = request.url; //  /html   /images/glass1.gif     /movie/Wildlife.mp4
    if(mapping == '/html'){
        fs.readFile(__dirname + '/movie_play.html', 'utf-8', function(error, data){
            if(!error){
                response.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
                response.end(data);
            }
        });
    } else if(mapping.indexOf('/images')==0){
        var mimeName = mime.getType(mapping.substring(1));
        console.log("mimeType -> " + mimeName);
        fs.readFile(__dirname + mapping, function(error, imgData){
            if(!error){
                response.writeHead(200, {'Content-Type' : mimeName});
                response.end(imgData);
            }
        });
    } else if(mapping.indexOf('/movie')==0){ // 동영상 접속
        // 1. streaming 처리를 하는 객체 생성 (한 번에 65535바이트 읽음);
        var stream = fs.createReadStream(mapping.substring(1));

        var cnt = 1;
        // 2. 데이터 읽었을 때 처리할 이벤트 
        //      이벤트 종류, 실행할 이벤트
        stream.on('data', function(data){
            response.write(data);
            console.log(cnt++ + '번째, dataSize->' + data.length);
        });

        // 3. 남은 데이터가 마지막일 때 처리할 이벤트
        stream.on('end', function(){ // 마지막은 데이터 없으니까 매개변수 안 써도 괜찮음
            response.end();
            console.log('end stream......');
        });

        // 4. 데이터 읽기 에러 발생 시 처리할 이벤트
        stream.on('error', function(){
            response.end();
            console.log('error stream------!!');
        });
    } else{
        response.writeHead(404, {'Content-Type':'text/html;charset=utf-8'});
        response.end('404 error page...............');
    }
});

server.listen(10008, function(){
    console.log('server start........... http://127.0.0.1:10008/html');
});