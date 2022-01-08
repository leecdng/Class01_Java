// 사용자 정의 모듈 만들기
// 모듈을 생성하기 위해서는 exports 내장객체를 이용하여 변수, 메서드를 정의한다.

// 1. 변수 선언하는 방법
exports.num = 1234;
exports.username = '홍길동';

// 2. 함수를 모듈로 선언하는 방법

exports.hap = function(p1, p2){ // (p1, p2) => {실행}
    return p1+p2;
}


exports.sum = function(max){
    var s = 0;
    for(var i=1; i=max; i++){
        s = s + i;
    }
    return s;
}

// 단을 입력받아 해당하는 구구단을 구하는 함수를 만든다.
exports.gugudan = (dan)=>{
    var result='';
    for(var i=2; i<=9; i++){
        var r = dan * i;
        result += dan + "*" + i + "=" + r*i;
    }
    return result;
}