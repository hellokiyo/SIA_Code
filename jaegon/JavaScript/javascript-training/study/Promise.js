// 콜백 함수를 Promise로 변환
const dividePromise = (x, y) => new Promise((resolve, reject) => {
    divideAsync(x, y, (err, res) => {
        if (err) reject(err);
        else resolve(res);
    });
});

const multiplyPromise = (x, y) => new Promise((resolve, reject) => {
    multiplyAsync(x, y, (err, res) => {
        if (err) reject(err);
        else resolve(res);
    });
});

const addPromise = (x, y) => new Promise((resolve, reject) => {
    addAsync(x, y, (err, res) => {
        if (err) reject(err);
        else resolve(res);
    });
});

// then 체인으로 사용
dividePromise(100, 10)
    .then(r1 => multiplyPromise(r1, 2))
    .then(r2 => addPromise(r2, 5))
    .then(r3 => console.log(`최종 결과: ${r3}`))
    .catch(err => console.error(err));
