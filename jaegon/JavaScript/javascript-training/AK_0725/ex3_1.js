/// 웹서버 만들기

// 1.다른 개발자가 만든 모듈 불러오기  // 프로토콜 = 인터페이스 = 약속
const http = require('http'); 
const express = require('express');

// 2. 익스프레스를 이용해서 웹서버를 위한 객체 만들기
const app = express();



// 4. 미들웨어 추가하기
app.use((req, res, next) => {
    console.log(`첫번째 미들웨어 호출됨`)
    
    next();
})
app.use((req,res,next) => {
    console.log(`두번째 미들웨어 호출됨`)

    res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});   //밑에 글자를 해석해서 보여줌
    res.end('<h1>웹서버에서 전달받은 페이지</h1>')
})


// 3. 웹서버 실행하기
//7001번 포트로 웹서버가 대기하게 됨
http.createServer(app).listen(7001, () => {
    console.log(`웹서버 실행됨`)
})



//실행할려면 cd (이 js파일이 있는 위치까지 들어오고)
//node (js파일명)

//cd  - change directory



//클라우드 > 리눅스 굳 윈도우 별로
//가격적인 면에서 윈도우가 별로다


// 앱개발 > 맥북 굳 윈도우 별로
// ios개발은 맥북에서만 된다.