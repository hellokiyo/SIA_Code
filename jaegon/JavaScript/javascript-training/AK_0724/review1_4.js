// 객체(붕어빵) 만들기
let fish1  = {
    name : '홍길동1', // 이름 속성
    age : 21,         // 나이 속성
    swim : function() { // 메서드 정의
        console.log(`물고기가 헤엄칩니다.`); // 메서드 실행 시 출력
    }
}
fish1.swim(); // fish1의 swim 메서드 실행


// 붕어빵 틀에서 붕어빵 만들어내기
class Fish {
    constructor(name, age) { // 생성자 함수: 객체 생성될 때 자동 실행
        this.name = name;    // 전달받은 name을 속성으로 저장
        this.age = age;      // 전달받은 age를 속성으로 저장

        console.log(`물고기가 만들어졌어요`); // 생성 시 메시지 출력
    }
}

let fish2 = new Fish(`물고기1`, 1); // new 키워드로 클래스 인스턴스 생성
console.log(`fish2 변수상자에 들어있는 물고기의 이름 : ${fish2.name}`); // name 속성 출력
