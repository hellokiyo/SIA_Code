// [연습] 함수 상자 연습

// 1. 빼기 함수 만들기
function sub(x, y) { // sub 함수 선언: 두 개의 입력값(x, y)을 받아서
    return x - y;    // 두 값의 차이를 반환 (뺄셈)
}

// sub 함수 호출 예시
console.log(`${sub(50, 20)}`); // 50 - 20 = 30 이므로 30이 출력됨

// 2. 콜백 함수 기본
// multiply 함수: 두 개의 값을 곱하고 그 결과를 callback 함수에 넘겨줌
const multiply = (x, y, callback) => {
    // 계산한 값을 return 하지 않고, callback(결과) 형태로 넘김
    callback(x * y);
}

// multiply 호출: 5 * 3 = 15를 callback으로 전달
multiply(5, 3, (res) => {
    // 여기서 res는 callback 함수의 매개변수 (결과값을 받음)
    console.log(`콜백으로 받은 곱셈 결과 : ${res}`)
})



// 3. 에러를 첫 번째 파라미터로 주는 콜백
// divide 함수: 나누기 연산 + 에러 처리 포함
const divide = (x, y, callback) => {
    // y가 0일 경우: 나눗셈 불가능 → 에러 발생
    if (y === 0) { //0으로 나누면 null값에 infinity가 출력됨
        callback('0으로 나눌 수 없습니다.', null); // 첫 번째 인자는 에러
        return; // 여기서 함수 종료
    }

    // y가 0이 아니면 결과 계산
    const res = x / y;
    // 첫 번째 인자는 에러(null), 두 번째 인자는 결과
    callback(null, res);
}

// divide 사용 예시
divide(100, 20, (err, res) => { // err = 첫 번째 값, res = 두 번째 값
    if (err) return console.error(`에러 발생 -> ${err}`); // 에러가 있으면 더 이상 실행하지 않고 종료

    // 에러가 없으면 결과 출력
    console.log(`나누기 결과 : ${res}`);
})


// 4. 콜백 중첩 (콜백 헬 예시)
// divide 함수 실행 → 결과(res1)를 이용해서 다시 multiply 실행
divide(100, 5, (err, res1) => {
    if (err) return console.error(err); // 에러 발생 시 중단

    // divide 결과값(res1)을 이용해서 multiply 실행
    multiply(res1, 2, (res2) => {
        // multiply 결과 출력
        console.log(`나누기 후 곱하기 결과 : ${res2}`)
    })
})
// 이런 식으로 콜백 안에 콜백을 넣다 보면 들여쓰기(피라미드)가 깊어지는 문제 → 콜백 헬



// 5. setTimeout을 이용한 비동기 함수
// addAsync: 0.5초 뒤에 두 값을 더한 결과를 callback으로 전달
const addAsync = (x, y, callback) => {
    setTimeout(() => { // setTimeout → 500ms 뒤 실행
        callback(null, x + y); // 첫 번째 인자 null(에러 없음), 두 번째는 결과
    }, 500); // 500ms속도    1초 = 1000ms
}

// divideAsync: 1초 뒤에 나누기 실행 (비동기)
const divideAsync = (x, y, callback) => {
    setTimeout(() => { // setTimeout → 1000ms 뒤 실행
        // 에러 처리: y가 0이면 에러
        if (y === 0) {
            callback('0으로 나눌 수 없습니다.', null);
            return;
        }
        // 에러가 없으면 결과 전달
        callback(null, x / y);
    }, 1000);
};



// 비동기 함수 실행 예제
divideAsync(50, 10, (err, res) => {
    // 1초 후에 실행되는 콜백
    if (err) return console.error(err); // 에러가 있으면 출력
    console.log(`비동기 나누기 결과 : ${res}`);
});



// 6. 비동기 콜백 중첩
// divideAsync 결과를 받아서 addAsync에 다시 넘기는 예
divideAsync(100, 10, (err, res1) => { // 첫 번째 비동기 작업
    if (err) return console.error(err);

    // 첫 번째 비동기 결과(res1)를 addAsync의 입력값으로 사용
    addAsync(res1, 30, (err2, res2) => { // 두 번째 비동기 작업
        if (err2) return console.error(err2);

        // 두 작업의 결과 출력
        console.log(`비동기 나누기 후 더하기 결과 : ${res2}`)
    });
});
// 여기서도 콜백 중첩 → 코드가 깊어짐



// 7. Promise로 감싸기 (다음 단계에서 개선 예정)
const addPromise = (x, y) => new Promise((resolve, reject) => {
    addAsync(x,y, (err,resolve) => {
        if(err) reject(err);
        else resolve(res);
    });
});

const dividePromise = (x, y) => new Promise((resolve,reject) => {
    divideAsync(x,y,(err,res) => {
        if(err) reject(err);
        else resolve(res);
    })
})

// 8. async/await 사용
const runCalc = async () => {
    try {
        const r1 = await dividePromise(100,20);
        console.log(`async/await 나누기 결과 : ${r1}`);

        const r2 = await addPromise(r1, 5);
        console.log(`async/await 더하기 결과 : ${r2}`);
    }catch (e) {
        console.error(`오류 : ${e}`);
    }
}

runCalc();