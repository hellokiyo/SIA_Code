//변수상자 만들기
let name1; // name1이라는 변수 선언 (초기화 X → undefined 상태)
name1 = '홍길동1'; // name1에 문자열 할당

let name2 = '홍길동2'; // 선언과 동시에 문자열 할당

let age1 = 21; // 숫자형 변수
let visible = true; // 불린형 변수

console.log(`name1 변수상자의 크기 : ${typeof(name1)}`); // string
console.log(`age1 변수상자의 크기 : ${typeof(age1)}`);   // number
console.log(`visible 변수상자의 크기 : ${typeof(visible)}`); // boolean

let name3; // 선언만 하고 값은 안 줌 → undefined
console.log(`name3 변수상자의 크기 : ${typeof(name3)}`); // undefined

if(typeof(name3) == 'undefined') { // 변수의 타입이 undefined이면
    console.log(`name3 변수상자는 크기를 알 수 없습니다.`) // 설명 출력
}
