// 함수상자 만들기 (자바스크립트 버전)
// 자바라면 아래와 같음
// int add(int a, int b ) {
//    return a + b;
// }

// ✅ 1. 기본 함수 선언 방식
function add(a, b) {
    return a + b; // 두 수를 더해서 반환
}

let output1 = add(10, 10); // 함수 호출 → 10 + 10 = 20
console.log(`더하기 결과 : ${output1}`); // 결과 출력: 더하기 결과 : 20

// ✅ 2. 파라미터로 값 넘기기
function print(a) {
    console.log(`print 함수상자 안에서 a 상자의 값 : ${a}`);
}

print(10); // 출력: print 함수상자 안에서 a 상자의 값 : 10

// ✅ 3. 함수상자를 변수상자에 넣기
let show = print; // print라는 함수 자체를 변수 show에 복사해서 넣음
show(); // print()와 동일하게 작동 → undefined를 출력함 (a 파라미터 없이 호출)

// ✅ 4. 익명 함수 표현식 (이름 없는 함수)
let show2 = function () {
    // 함수 이름 없이 정의 → 함수 표현식 (함수도 값처럼 변수에 저장 가능)
    console.log(`print2 함수 실행됨.`);
};

// show2(); // 필요 시 호출 가능

// ✅ 5. 화살표 함수 (Arrow Function) → 더 짧은 문법
//화살표 함수는 콜백, 1회성 함수에만 쓰는 게 안전합니다.
let show3 = () => {
    console.log(`print2 함수 실행됨.`);
};

// show3(); // 필요 시 호출 가능

// ✅ 6. 또 다른 함수 선언 예시
function add2(a, b) {
    return a + b;
}

let output2 = add2(10, 10);
console.log(`더하기 결과 : ${output2}`); // 출력: 더하기 결과 : 20

// ✅ 7. 콜백 함수 예시
// c는 함수(콜백)를 인자로 받음
function add3(a, b, c) {
    c(a + b); // c는 함수이므로, 결과값을 넘겨서 실행시킴
}

// 호출: 10 + 10 한 결과를 output으로 받고, 그걸 console.log에 넘김
add3(10, 10, (output) => {
    console.log(`더하기 결과 : ${output}`);
});
