// 변수상자 만들기

let name1 = '홍길동1';  // String
let age1 = 21;          // int
let visible = true;     // boolean

// typeof 연산자로 자료형 확인
const name1Type = typeof(name1);
console.log(`name1 변수상자의 크기 : ${name1Type}`); // string

// 값이 없는 변수 선언
let name2;
const name2Type = typeof(name2); // undefined
console.log(`name2 변수상자의 크기 : ${name2Type}`)

// 문자열로 들어온 숫자
const age2 = '21'; //숫자로 입력해도 화면에서 가져올때 값은 string임
const age3 = '22A'; //하지만 문자를 낄 경우 Number로 바꿀 수 없음 Number는 숫자만 가져옴

// Number() 함수로 문자열을 숫자로 변환
const age2Int = Number(age2); //그래서 숫자로 변환 (정상 변환: 21)
const age3Int = Number(age3); //그래서 숫자로 변환 (NaN 발생)

// 숫자 덧셈
const result1 = age2Int + age3Int; // 21 + NaN → NaN
console.log(`더하기 결과 : ${result1}`);

// NaN(Not a Number) 판별
if (isNaN(age3Int)) { // age3Int 값이 NaN인지 확인
    console.log(`첫번째 글자는 숫자가 아닙니다.`);
}

if (isNaN(result1)) { // 덧셈 결과가 NaN인지 확인
    console.log(`더하기 결과가 숫자가 아닙니다.`)
}
