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

router.route('/login').get((req,res) => {
    //경로는 /부터 시작임
    console.log('/login 요청됨')

    const params = req.query;


    const contextLogin = {
        name : '정훈이',
        userid : params.id,  //login 페이지에서 input-text상자안에 넣으면 login 라우터로 request함 name이 id인 value의 값을 가져옴
        userpw : params.pw
    }

    req.app.render('login',contextLogin,(err, html)=> {
        if (err) {
            console.log(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type':'text/html;charset=utf8'})
        res.end(html);
    })
})


router.route('/menu').get((req, res) => {
    console.log(`/menu 요청됨`);

    const params =req.query;

    const context1 = {
        userId :params.id,
        lastSelectScreen : params.lastSelectScreen
    };

    req.app.render('menu', context1, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});

router.route('/customer').get((req, res) => {
    console.log(`/customer 요청됨`);
    const contextMenu = {

        //login 페이지에서 input-text상자안에 넣으면 login 라우터로 request함 name이 id인 value의 값을 가져옴
        //let으로 선언하여 현재 페이지에서 사용하기

    };

    req.app.render('customer', contextMenu, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});

router.route('/product').get((req, res) => {
    console.log(`/product 요청됨`);

    const contextProduct = {

    };

    req.app.render('product', contextProduct, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});

router.route('/revenue').get((req, res) => {
    console.log(`/revenue 요청됨`);

    const contextRevenue = {

    };

    req.app.render('revenue', contextRevenue, (err, html) => {
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
