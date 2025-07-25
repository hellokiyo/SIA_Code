class dog{
    constructor(name) { // 객체 생성 시 자동 실행되는 함수
        this.name = name;   // 전달받은 name을 객체의 name 속성에 저장
    }
}

class cat{
    constructor(name) { // 객체 생성 시 자동 실행되는 함수
        this.name = name;   // 전달받은 name을 객체의 name 속성에 저장
    }
}
    

let dog1 = new dog('강아지1'); 
let cat1 = new cat('고양이1'); 

let house = {
    person : {
        name : "홍길동",
        age : 22,
        mobile : "010-1000-1000"
    },
    dog,
    cat,   
    
    print: function() {
        console.log(`집안에 있는 사람의 이름 : ${this.person.name}, 나이 ${this.person.age}, 전화번호 ${this.person.mobile} 입니다. `);
        console.log(`집안에 있는 강아지의 이름은 : ${dog1.name}`);
        console.log(`집안에 있는 고양이의 이름은 : ${cat1.name}`);
    }
}

house.print();