// 웹서버 만들기

// 1. 다른 개발자가 만든 http라는 모듈을 불러오기
//1-1
const http = require('http');
const express = require('express');
//2-1
const mariadb = require(`mariadb`);

//2-2
const pool = mariadb.createPool({
    host: 'localhost', port: 4406, user: 'root', password: 'admin'
})

//1-2
const app = express();

//1-6
app.set('views', '/LX_AC/jaegon/javaScript/javascript-training/AK_0728/views');
app.set('view engine', 'ejs');

//1-4
const router = express.Router();
app.use('/', router);

//1-5
router.route('/login').get((req, res) => {
    //경로는 /부터 시작임
    console.log('/login 요청됨')

    const params = req.query;


    const contextLogin = {
        name: '정훈이', userid: params.id,  //login 페이지에서 input-text상자안에 넣으면 login 라우터로 request함 name이 id인 value의 값을 가져옴
        userpw: params.pw
    }

    req.app.render('login', contextLogin, (err, html) => {
        if (err) {
            console.log(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        res.writeHead(200, {'Content-Type': 'text/html;charset=utf8'})
        res.end(html);
    })
})


router.route('/main').get((req, res) => {
    console.log(`/main 요청됨`);

    const params = req.query;

    const context1 = {
        name1: '정훈이의 홈페이지', lastSelectScreen: params.lastSelectScreen
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


router.route('/select').get(async (req, res) => {
    console.log('/select 요청됨');

    let conn;

    try {
        //2-3 데이터베이스에서 SQL문 실행 요청하기
        conn = await pool.getConnection();
        const sql = `select id, name, age, mobile from test.person`;
        const rows = await conn.query(sql);

        //1-8
        const contextSelect = {
            // 숫자 받아오거나 해야할듯?
            // 아니면 사용자 검색으로 받아온 id로
            //id로 검색  username: rows[id-1].name,
            userName: rows[0].name,
            userAge: rows[0].age,
            userMobile: rows[0].mobile
        }

        //1-7
        req.app.render('select', contextSelect, (err, html) => {
            if (err) return console.error(`뷰 처리 중 에러-> ${err}`);

            res.writeHead(200, {'Content-Type': 'text/html;charset=utf8'});
            res.end(html);
        })


    } catch (err) {
        console.error(`요청 처리 중 에러 ->${err}`)
    } finally {
        if (conn) {
            conn.end(); //pool쪽으로 반환하기
        }
    }
})
router.route('/update').get((req, res) => {
    console.log(`/update 요청됨`);

    const contextUpdate = {

    };

    req.app.render('update', contextUpdate, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});

router.route('/insert').get((req, res) => {
    console.log(`/insert 요청됨`);

    const contextInsert = {

    };

    req.app.render('update', contextInsert, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});



router.route('/delete').get((req, res) => {
    console.log(`/delete 요청됨`);

    const contextDelete = {

    };

    req.app.render('update', contextDelete, (err, html) => {
        if (err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }

        res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
        res.end(html);
    });
});




//1-3
const port = 7001;
http.createServer(app).listen(port, () => {
    console.log(`웹서버 실행됨 -> port : ${port}`)
})

