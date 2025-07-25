/// 웹서버 만들기

// 1.다른 개발자가 만든 모듈 불러오기  // 프로토콜 = 인터페이스 = 약속
const http = require('http');
const express = require('express');

// 2. 익스프레스를 이용해서 웹서버를 위한 객체 만들기
const app = express();

//6. 뷰 사용하기
app.set('views','./views');
app.set('view engine', 'ejs');


// 4. 미들웨어 추가하기

// 5. 라우터 추가하기
const router = express.Router();
app.use('/', router);

router.route('/page/login').get((req,res) => {
    //경로는 /부터 시작임
    console.log('/page/login 요청됨')

    const context = {
        name : '정훈이'
    }

    req.app.render('login',context,(err, html)=> {
        if (err) {
            console.log(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'})
        res.end(html);
    })
})


router.route('/page/main').get((req, res) => {
    console.log(`/page/main 요청됨`);

    const context1 = {
        name : '정훈이의 홈페이지'
        
    };

    req.app.render('main', context1, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});

router.route('/page/product').get((req, res) => {
    console.log(`/page/product 요청됨`);

    const context1 = {

    };

    req.app.render('product', context1, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});

router.route('/page/customer').get((req, res) => {
    console.log(`/page/customer 요청됨`);

    const context1 = {

    };

    req.app.render('customer', context1, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});

router.route('/page/Management').get((req, res) => {
    console.log(`/page/Management 요청됨`);

    const context1 = {

    };

    req.app.render('Management', context1, (err, html) => {
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
