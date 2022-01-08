// npm install express
// npm install oracledb
// npm install ejs
// npm install express-session
// express : 접속 시 처리되는 함수 구현 get, post 방식을 별도 구현

var http = require('http');
var express = require('express');
var fs = require('fs'); // 파일 입출력
var ejs = require('ejs'); // Embedded javascript template
var session = require('express-session');

var app = express();
var server = http.createServer(app);

// ******* JDBC **********************************
var oracledb = require('oracledb');
oracledb.autoCommit = true; // 자동커밋

var conn;
// DB 연결
oracledb.getConnection({
    user : 'c##scott',
    password : 'tiger',
    connectString : 'localhost:1521/xe'
    }, function(error, con){
        // 연결 시 에러 발생하면 실행할 콜백함수
        if(error){
            console.log('DB연결 에러 발생... -> ' + error);
        } else{
            console.log('DB연결됨');
            conn = con;
        }
    }
);
// **********************************************************

// ============= POST 방식 접속 시 데이터 request를 위한 설정 ============
var bodyParser = require('body-parser');
app.use(express.static(__dirname)); // express에 기본 디렉토리 세팅
app.use(bodyParser.urlencoded({extended:true})); // 한글 인코딩 세팅
//=====================================================================

// 홈페이지로 이동하기
app.get('/home', function(request, response){
    fs.readFile(__dirname + '/home.html', 'utf-8', function(error, data){
        if(!error){
            response.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
            response.end(data);
        }
    });
});
// 로그인 폼
app.get('/login', function(request, response){
    fs.readFile(__dirname + '/loginForm.html', 'utf-8', function(error, data){
        if(!error){
            response.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
            response.end(data);
        }
    });
});

// 로그인
app.post('/loginOk', function(request, response){
    // 아이디와 비밀번호 서버로 가져오기
    var userid = request.param('userid');
    var userpwd = request.param('userpwd');
    console.log('아이디 = ' + userid + '비밀번호 = ' + userpwd);

    // 아이디, 이름을 선택
    var sql = "select userid, username from register where userid='" + userid + "' and userpwd='" + userpwd + "'";

    conn.execute(sql, function(error, result){ // DB처리 완료 시 실행되는 곳
        if(result.rows.length==0){ // 로그인 실패
            fs.readFile(__dirname + 'loginForm.html', 'utf-8', function(error, data){
                if(!error){
                    response.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
                    response.end(data);
                }
            });
        } else{ // 로그인 성공
            // 세션 기록
            session.user = {
                userid : result.rows[0][0],
                username : result.rows[0][1],
                autorized : true // 인증받은, 검정필
            };
            //
            fs.readFile(__dirname + '/home.ejs', 'utf-8', function(error, data){
                if(error){
                    response.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
                    response.end('404 error.........');
                } else{
                    response.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
                    response.end(ejs.render(data, { // 이 파일로 데이터를 넘겨준다
                        user: session.user, logStatus:'Y'
                    }));
                }
            });
        }
    });
});

// 서버에 접속 대기
server.listen('10020', function(){
    console.log('start server..... http://127.0.0.1:10020/home');
});