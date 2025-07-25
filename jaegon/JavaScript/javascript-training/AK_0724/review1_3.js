// 함수상자 만들기
function add1(a, b) { // a와 b를 더해서 결과를 반환하는 함수
    return a + b;
}

let a = 10; // 숫자 변수 a
let b = 10; // 숫자 변수 b
add1(a, b); // 함수를 호출했지만 결과를 저장하지 않음 (출력 없음)

let output1 = add1(a, b); // 함수 결과를 변수에 저장
console.log(`더하기 결과 : ${output1}`); // 결과 출력


// 함수상자를 변수상자에 넣기
let add2 = function(a, b) { // 익명 함수(이름 없는 함수)를 변수에 저장
    return a + b;
}

let add3 = (a, b) => { // 화살표 함수 (Arrow Function)
    return a + b;
}


// 콜백 함수 사용하기
let add4 = (a, b, callback) => { // 세 번째 인자로 콜백 함수를 받는 함수
    callback(a + b); // 계산 결과를 콜백 함수에 넘겨줌
}
    
add4(10, 10, (output) => { // 콜백 함수를 인자로 전달
    console.log(`콜백 함수 안에서 결과 : ${output}`); // 콜백 내부에서 결과 출력
})
