// 비동기 함수 3개 (콜백 방식)
function divideAsync(x, y, cb) {
    setTimeout(() => {
        if (y === 0) return cb('0으로 나눌 수 없습니다.', null);
        cb(null, x / y);
    }, 500);
}

// 콜백 함수를 Promise로 변환
const dividePromise = (x, y) => new Promise((resolve, reject) => {
    //resolve는 성공(결과값), reject는 실패(에러값)
    //resolve: "모든 게 잘 끝났어! 이 값으로 성공 처리해."

    //reject: "문제가 생겼어! 이 이유로 실패 처리해."

    //Promise는 이 둘 중 하나만 딱 한 번 호출해서 결과를 확정짓는다.
    divideAsync(x, y, (err, res) => {
        if (err) reject(err);
        else resolve(res);
    });
});


function multiplyAsync(x, y, cb) {
    setTimeout(() => cb(null, x * y), 500);
}




function addAsync(x, y, cb) {
    setTimeout(() => cb(null, x + y), 500);
}




// 콜백 헬 시작!
divideAsync(100, 10, (err, r1) => {
    if (err) return console.error(err);

    multiplyAsync(r1, 2, (err2, r2) => {
        if (err2) return console.error(err2);

        addAsync(r2, 5, (err3, r3) => {
            if (err3) return console.error(err3);

            console.log(`최종 결과: ${r3}`);
        });
    });
});
