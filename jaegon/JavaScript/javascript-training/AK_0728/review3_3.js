// 붕어빵 만들기 (객체와 클래스 연습)

// 1. 객체 리터럴로 만든 단일 객체
const fish1 = {
    name: '홍길동1', // 속성 name
    age: 21         // 속성 age
}
// fish1은 한 마리 물고기 정보(붕어빵 1개)

// ------------------------------------------------

// 2. 배열 안에 여러 개의 물고기 넣기 (배열을 이용한 여러 객체 관리)
const fishes = []; // 빈 배열 준비 (붕어빵 여러 개를 담는 박스)

// push() : 배열 끝에 새로운 객체 추가
fishes.push({
    name: '물고기1',
    age: 1
});

fishes.push({
    name: '물고기2',
    age: 2
});

// 배열에 두 개의 물고기가 들어있음
console.log(`fishes의 칸 개수 : ${fishes.length}`); // 2
console.log(`첫번째 칸에 있는 물고기의 이름 ${fishes[0].name}`); // 점 표기법
console.log(`첫번째 칸에 있는 물고기의 이름 ${fishes[0]['name']}`); // 대괄호 표기법
// 객체의 속성 접근은 .name 또는 ['name'] 두 가지 방법 모두 가능

// ------------------------------------------------

// 3. 클래스를 사용해서 붕어빵 찍어내기
class Fish {
    constructor(name, age) {
        // 생성자(constructor): new 키워드로 객체를 만들 때 자동 실행되는 함수
        this.name = name; // 전달받은 name 값을 객체 속성에 저장
        this.age = age;   // 전달받은 age 값을 객체 속성에 저장
    }
}

// new 키워드를 사용하면 위의 클래스(붕어빵 틀)로 새로운 객체(붕어빵) 생성 가능
const fish3 = new Fish('물고기3', 3);
const fish4 = new Fish('물고기4', 4);

// fish3, fish4는 Fish 클래스 기반으로 만들어진 새로운 객체
