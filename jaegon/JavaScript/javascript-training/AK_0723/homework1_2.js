class dog{
    constructor(name) { // 객체 생성 시 자동 실행되는 함수
        this.name = name;   // 전달받은 name을 객체의 name 속성에 저장
    }
    bark() {
        console.log(`${this.name}가 멍멍!`);
    }
}

class cat{
    constructor(name) { // 객체 생성 시 자동 실행되는 함수
        this.name = name;   // 전달받은 name을 객체의 name 속성에 저장
    }
}
/*     방식         문법                        this 동작                 메서드 정의에 적합?
    일반 함수    function () {}	       호출한 객체를 this로 바인딩        	✅ 예
    화살표 함수	    () => {}	       자신의 외부 스코프의 this 사용   	❌ 객체 메서드에는 부적합
*/



let house = {
    person : {
        name : "홍길동",
        age : 22,
        mobile : "010-1000-1000"
    },

    dog1 : new dog("강아지1"),  //그냥 객체안에 있는 속성
    cat1 : new cat("고양이1"),


    print() { // print: function() {}
        console.log(`사람의 이름 : ${this.person.name}, 나이 ${this.person.age}, 전화번호 ${this.person.mobile} 입니다. `);
        //this를 붙이면 house내부에서 찾음  this 안 붙이면 house 외부의 전역변수에서 찾음
        console.log(`강아지의 이름은 : ${dog1.name}`);
        console.log(`고양이의 이름은 : ${cat1.name}`);
    }
}
/*
let house = {
  person: { name: '홍길동', age: 25, mobile: '010-1234-5678' },
  dog1: { name: '멍멍이' },
  cat1: { name: '야옹이' },

  print: () => { // ❌ 여기서 this는 house를 가리키지 않음!
    console.log(this.person); // ⚠️ undefined
  }
};

❌ this는 house가 아니라 **window (또는 전역 객체)**를 가리킴
따라서 this.person → undefined
*/




    // 기능 있는 "강아지" 객체를 만들고 싶다	
    let dog1 = new Dog('강아지1'); // 전역변수
    dog1.bark();

    // 이름만 저장하고 싶다	
    let dog2 = { name: '멍멍이' };
    // dog2.bark(); // ❌ 오류 발생 - 메서드 없음



house.print();