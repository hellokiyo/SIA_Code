// 웹서버 만들기

// 1. 다른 개발자가 만든 http라는 모듈을 불러오기
//1-1
const http  = require('http');
const express = require('express');
//2-1
const mariadb = require(`mariadb`);

//2-2
const pool = mariadb.createPool({
    host : 'localhost',
    port : 4406,
    user : 'root',
    password : 'admin'
})

//1-2
const  app = express();

//1-6
app.set('views', '/LX_AC/jaegon/javaScript/javascript-training/AK_0728/views');
app.set('view engine', 'ejs');

//1-4
const router = express.Router();
app.use('/', router);

//1-5
router.route('/page/first').get(async (req, res) => {
    console.log('/page/first 요청됨');

    let conn;

    try{
        //2-3 데이터베이스에서 SQL문 실행 요청하기
        conn = await pool.getConnection();
        const sql = `select id, name, age, mobile from test.person`;
        const rows = await conn.query(sql);

        //1-8
        const context = {
            username: rows[0].name
        }

        //1-7
        req.app.render('first', context, (err, html) => {
            if (err) return console.error(`뷰 처리 중 에러-> ${err}`);

            res.writeHead(200, {'Content-Type': 'text/html;charset=utf8'});
            res.end(html);
        })


    } catch(err) {
        console.error(`요청 처리 중 에러 ->${err}`)
    }finally {
        if(conn) {
            conn.end(); //pool쪽으로 반환하기
        }
    }
})


//1-3
const port = 7001;
http.createServer(app).listen(port,() => {
    console.log(`웹서버 실행됨 -> port : ${port}`)
})

