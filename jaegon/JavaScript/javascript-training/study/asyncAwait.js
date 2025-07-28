async function runCalc() {
    try {
        const r1 = await dividePromise(100, 10);
        const r2 = await multiplyPromise(r1, 2);
        const r3 = await addPromise(r2, 5);

        console.log(`최종 결과: ${r3}`);
    } catch (err) {
        console.error(err);
    }
}

runCalc();
