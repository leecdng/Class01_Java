// npm install socket.io@2.3.0
var http = require('http');
var fs = require('fs');
var socketio = require('socket.io');

var server = http.createServer(function(request, response){
    if(request.url == '/chatEcho'){
        fs.readFile(__dirname + '/chat_form_01.html', 'utf-8', function(error, data){
            response.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
            response.end(data);
        });
    } else{

    }
}).listen(10010, function(){
    console.log('server start......http://127.0.0.1:10010/chatEcho');
});

// =========== 통신 프로그램 구현 =================
// 1) socket 서버를 생성하고 실행 (윗 서버와는 별개)
var io = socketio.listen(server);

// 2) 접속을 대기하는 이벤트를 생성 ('connection' 이벤트가 발생하면 실행될 곳)
io.sockets.on('connection', function(socket){ // socket : 클라이언트 정보 가지고 있는 변수

    // 3) 클라이언트가 보낸 문자를 받을 이벤트
    socket.on('hello', function(msg){
        console.log('서버가 받은 문자 : ' + msg);

        // 4) 클라이언트에게 서버가 정보 보내는 이벤트 발생
        socket.emit('echo', 'server message : 안녕 난 서버^^ (' + msg + ')');

    });
});