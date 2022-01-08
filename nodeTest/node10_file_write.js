// 파일로 쓰기
// fs : File System

var fs = require('fs');

var dataAsync = '비동기식으로 파일 쓰기 연습 중 \r\n줄바꿈 확인하기....';

// 비동기식으로 쓰기
//                 파일명, 쓰기 할 내용, 인코딩 정보
fs.writeFile(__dirname + '/file_write_async.txt', dataAsync, 'utf-8', function(error){
    if(error){ // error에 메세지가 있으면 true, 에러가 발생했다.
        console.log('비동기식으로 파일 쓰기 실패' + error);
    } else {
        console.log('비동기식으로 파일 쓰기 완료...');
    }
});

// 동기식으로 쓰기 : 바로 실행
var dataSync = '동기식으로 file write test....';
try{
    fs.writeFileSync(__dirname + '/file_write_sync.txt', dataSync, 'utf-8');
    console.log('동기식 파일 쓰기 완료....');
} catch(error){
    console.log('동기식 파일 쓰기 에러 발생.....' + error);
}