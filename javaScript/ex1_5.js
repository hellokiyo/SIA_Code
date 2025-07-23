console.log('안녕!');

// 변수상자 만들기

//자바스크립트는 변수상자의 크기를 명시하지 않음
//자바의 경우
//String name1;

let name1;
name1 = '홍길동1';
console.log(`name1 변수상자의 값 : ` + name1);
console.log(`name1 변수상자의 값 : ${name1} ` );

let name2 = '홍길동2';
console.log(`name2 변수상자의 값 : ${name2}`);

let age1 =21;
console.log(`age1 변수상자의 값 : ${age1}`);

console.log(`name1 변수상자의 크기 : ${typeof(name1)}`);
console.log(`age1 변수상자의 크기 : ${typeof(age1)}`);

let visible = true;
console.log(`visible 변수상자의 크기 : ${typeof(visible)}`);