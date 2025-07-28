/// 웹서버 만들기

// 1.다른 개발자가 만든 모듈 불러오기  // 프로토콜 = 인터페이스 = 약속
const http = require('http'); 
const express = require('express');
const {createNullProtoObjWherePossible} = require("ejs/lib/utils");

// 2. 익스프레스를 이용해서 웹서버를 위한 객체 만들기
const app = express();

//6. 뷰 사용하기
app.set('views','./views');
app.set('view engine', 'ejs');


// 4. 미들웨어 추가하기

// 5. 라우터 추가하기
const router = express.Router();

app.use('/', router);

router.route('/page/first').get((req, res) => {
    console.log(`/page/first 요청됨`);

    const context1 = {
        // 전달할 데이터가 있다면 여기에 작성
        username : '홍길동'
    };

    req.app.render('first', context1, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset = utf-8'});
        res.end(html);
    });
});

router.route('/page/second').get((req, res) => {//res = response, req = request
    console.log(`/page/second 요청됨`);

    const params = req.query;

    const context2 = {
        // 전달할 데이터가 있다면 여기에 작성
        name : params.name //첫번째 미들웨어 내에 context에서 생성된 username이 현재 미들웨어 내에서 사용할 수 있게함
    };

    req.app.render('second', context2,(err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});



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