// 함수상자

// A 개발자 -> 더하기 함수상자 만들기 : a, b라는 2개의 위쪽 구멍을 만들어둠
function add(a, b) { // 2개의 매개변수를 받아 더하는 함수
    return a + b;    // 합계를 반환
}

// B 개발자 -> A 개발자가 만든 더하기 함수상자의 위쪽 구멍은 2개라고 이미 정의되어 있음
const a = 10; // 첫 번째 숫자
const b = 20; // 두 번째 숫자

const result1 = add(a, b); // add 함수 실행
console.log(`더하기 결과 : ${result1}`); // 결과 출력

// 콜백함수
// 함수를 일급객체로 다룬다. -> 함수를 변수에 할당할 수 있다. -> 함수상자를 변수상자에 넣을 수 있다.

const add2 = function (a, b) { // 익명함수 = 이름이 중복되니 함수의 이름은 지운다.
    return a + b;
}

const add3 = (a, b) => { // 화살표 함수
    return a + b;
}

// A 개발자가 콜백 함수를 사용하는 형태로 함수를 정의함
const add4 = (a, b, callback) => {  // 콜백 함수는 빠져나가는 구멍이 없다. 대신 다른 함수구멍으로 나간다.
    callback(a + b); // 계산한 결과를 callback 함수에 넘겨줌
}

// B 개발자가 콜백 함수를 사용함
// 위쪽 구멍으로 던져줄 값의 개수는 A 개발자가 정의한 개수와 동일하게 맞춰줌
add4(a, b, (result) => { // add4의 세 번째 인자로 콜백 전달
    console.log(`콜백 함수 안에서 더하기 결과 : ${result}`); // 콜백 안에서 결과 처리
})


// 콜백함수를 여러 개 연속해서 사용하는 경우

// null 알아보기 (값이 비어 있는 상태를 표현)
let fish1 = {
    name: '물고기1',
    age: 1
}

let fish2 = null;

// add5: 에러를 첫 번째 파라미터로 전달하고, 두 번째 파라미터로 결과 전달
const add5 = (a, b, callback) => {
    const result = a + b;
    callback(null, result); // 첫 번째 null: 에러 없음
}

// add5 호출
add5(10, 10, (err, result) => { // 보통 콜백의 첫 번째 구멍은 에러(err)를 넣음
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return; // 에러가 있으면 함수 중단
    }

    console.log(`더하기 결과 : ${result}`);
})


// 나누기 함수 - 에러 처리 포함
const divide5 = (a, b, callback) => { // 콜백쓰는 이유는 비동기식 처리할려고
    if (b == 0) {
        callback('두번째 값이 0입니다.', null); // 두 번째 값이 0이면 에러
        return;
    }

    const result = a / b;
    callback(null, result); // 에러 없으면 null, 결과 반환
}

// 나누기 함수 사용
divide5(200, 10, (err, result) => {
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`콜백함수 안에서 나누기 결과 : ${result}`);
})


// A 개발자가 만들어 둔 더하기 함수와 나누기 함수가 있을 때,
// 나누기 함수를 실행한 결과값에 다른 값을 더하고 싶은 경우 (콜백 중첩 → 콜백 헬)
divide5(200, 10, (err, result) => {
    if (err) {
        console.log(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`나누기 결과 : ${result}`);

    add5(result, 10, (err2, result2) => { // 나누기 결과로 다시 add5 호출
        if (err2) {
            console.log(`에러 발생 -> ${err2}`);
            return;
        }

        console.log(`더하기 결과 : ${result2}`);
    })
})


// 비동기식 처리 예시 (setTimeout 사용)
// setTimeout을 사용하면 일정 시간 뒤에 함수 실행 → 결과를 즉시 return 할 수 없고, 콜백으로 전달해야 함
const add6 = (a, b, callback) => {
    setTimeout(() => { // 0.5초 후 실행
        const result = a + b;
        callback(null, result);
    }, 500)
}

const divide6 = (a, b, callback) => {  // 콜백쓰는 이유는 비동기식 처리할려고
    // 콜백 함수를 사용하면 리턴을 사용하지 않기 때문에 콜백 함수를 통해서
    // 작성하기 때문에 콜백함수는 필수다.
    setTimeout(() => { // 1초 후 실행
        if (b == 0) {
            callback('두번째 값이 0입니다.', null);
            return;
        }

        const result = a / b;
        callback(null, result);
    }, 1000)
}


// 비동기 함수 실행 (결과는 지연되어 나옴)
divide6(200, 10, (err, result) => {
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`divide6 안에서 나누기 결과 : ${result}`);
})

add6(10, 10, (err, result) => {
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`add6 안에서 더하기 결과 : ${result}`);
})


// 비동기 콜백 중첩 예 (콜백 헬)
divide6(200, 10, (err, result) => {
    if (err) {
        console.log(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`나누기 결과 : ${result}`);

    add6(result, 10, (err2, result2) => { // 나누기 결과를 다시 add6에 사용
        if (err2) {
            console.log(`에러 발생 -> ${err2}`);
            return;
        }

        console.log(`더하기 결과 : ${result2}`);
    })
})


// async ~ await
// 비동기 코드를 좀 더 깔끔하게 작성할 수 있는 방법

// add6을 Promise로 감싸서 비동기 처리
const add7 = (a, b) => new Promise((resolve, reject) => {
    add6(a, b, (err, result) => {
        if (err) {
            reject(err); // 에러 발생 시 reject 호출
            return;
        }

        resolve(result); // 성공 시 resolve 호출
    })
})

// divide6을 Promise로 감싸서 비동기 처리
const divide7 = (a, b) => new Promise((resolve, reject) => {
    // resolve는 성공(결과값), reject는 실패(에러값)
    // resolve: "모든 게 잘 끝났어! 이 값으로 성공 처리해."
    // reject: "문제가 생겼어! 이 이유로 실패 처리해."
    // Promise는 이 둘 중 하나만 딱 한 번 호출해서 결과를 확정짓는다.

    divide6(a, b, (err, result) => {
        if (err) {
            reject(err);
            return;
        }

        resolve(result);
    })
})


// 나누기를 먼저 하고 그 결과를 이용해서 더하기하기
const doCalc = async () => { // async 함수 정의
    try {
        // const result1 = await divide7(200, 10); // 성공 예시
        const result1 = await divide7(200, 0); // 0으로 나눠서 에러 발생 (reject)
        console.log(`doCalc 안에서 나누기 결과 : ${result1}`);

        const result2 = await add7(result1, 10);
        console.log(`doCalc 안에서 더하기 결과 : ${result2}`);

    } catch(err) { // 에러 잡기
        console.error(`doCalc 안에서 에러 발생 : ${err}`);
    }
}

doCalc(); // 실행
