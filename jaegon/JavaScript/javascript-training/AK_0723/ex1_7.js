// 붕어빵 만들기 - 객체 사용하기

let fish1 = { // 객체 리터럴 방식으로 붕어빵 하나 생성
    name: '홍길동1', // name 속성 정의
    age: 21          // age 속성 정의
}

console.log(`fish1 변수상자에 들어있는 붕어빵의 이름은? : ${fish1.name}`); // name 속성 출력


let fish2 = { // 함수 포함된 객체 생성
    name : '홍길동2',
    age : 22, //변수상자가 아니라 그냥 속성이다. 변수상자 함수상자 구분없이 그냥 속성이다.
    swim: function(){ // swim색깔이 바꼈다.
        console.log(`물고기가 헤엄칩니다. ${this.name}`); //화살표함수 썼을땐 this를 사용할 수 없다. function사용을 권장한다.
    }
}
fish2.swim(); // swim 함수 실행


class Fish { //클래스 만들때 첫글자 대문자 //자바에서는 파일이름도 Fish여야하지만 자바스크립트는 안그래도 된다.
    constructor(name,age) { // 객체 생성 시 자동 실행되는 함수
        this.name = name;   // 전달받은 name을 객체의 name 속성에 저장
        this.age = age;     // 전달받은 age를 객체의 age 속성에 저장
    }
    swim() { // 클래스 내부의 메서드 정의
        console.log(`붕어빵이 헤엄칩니다. : ${this.name}`) // this는 해당 객체 자신
    }
}

let fish3 = new Fish('붕어빵3',1); // Fish 클래스로 새로운 객체 생성 (붕어빵3, 나이 1)
console.log(`fish3 변수상자에 들어있는 붕어빵의 이름은? : ${fish3.name}`); // fish3의 name 속성 출력
fish3.swim(); // fish3의 swim 메서드 실행
