// 웹 서버 만들기

//다른 개발자가 만들어둔 모듈 불러오기
const http = require('http');
const express = require('express');
const mariadb = require('mariadb');


const pool = mariadb.createPool({
    host : 'localhost',
    port : '4406',
    user : 'root',
    password : 'admin'
})
// 웹서비스를 위한 객체 만들기
const app = express();

// 웹페이지 파일을 저장해두고 불러와서 사용하기 위해 사용되는 모듈에 대한 설정
app.set('views', './views'); //현재 views폴더에 views 넣기
app.set('view engine', 'ejs');

// 라우터 설정하기
// 클라이언트 (요청을 하는 쪽, 웹 브라우저)에서 요청 경로로 요청하는 것을
// 어떤 함수로 실행시켜서 응답을 보내줄 지를 결정해주는것
// 요청 경로 -> 함수 매칭
const router = express.Router();
app.use('/',router);

router.route('/person/delete').get(async (req,res) => {
    console.log('/person/delete 요청됨');

    let conn = await pool.getConnection();

    let sql = `delete from test.person WHERE id = 2`;
    let rows = await conn.query(sql, []);

    try{
        conn
    }catch(err) {
        console.log(`요청 처리중 에러 : ${err}`)
    }finally {

    }
})




router.route('/person/add').get(async (req, res) => {
    console.log('/person/add 요청됨');

    try {

        const context = {

        }

        req.app.render('add', context, (err, html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
            }

            res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
            res.end(html);

        })

    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    }

})

router.route('/person/insert').get(async (req, res) => {
    console.log('/person/insert 요청됨');

    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`);

    let conn;
    try {
        // 데이터베이스로 SQL문 실행 요청하기
        conn = await pool.getConnection();

        let sql = `insert into test.person(name, age, mobile) values ('${params.name}', ${params.age}, '${params.mobile}')`;
        let rows = await conn.query(sql, []);

        sql = `select id, name, age, mobile from test.person`;
        rows = await conn.query(sql, []);

        const context = {
            persons: rows
        }

        req.app.render('list', context, (err, html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
            }

            res.writeHead(200, {'Content-Type':'text/html;charset=utf8'});
            res.end(html);

        })

    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }

})

router.route('/person/list').get(async (req,res) => {
    console.log('/person/list 요청경로로 요청됨');

    let conn;

    try{
        // 데이터베이스로 SQL문 실행 요청하기
        conn = await pool.getConnection();

        // 데이터베이스에서 데이터 조회하기
        const sql = `select id, name, age, mobile from test.person`;
        let rows = await conn.query(sql, []);

        const context = {
            persons: rows
        }


        // views 폴더 안에 있는 list.ejs 웹페이지 파일을 읽어오고
        // context 객체(붕어빵) 안에 있는 속성들을 웹페이지와 결합해서
        // 콜백함수의 두번째 구멍으로 전달해줌
        req.app.render('list',context, (err,html) =>{
            // 만약 첫번째 구멍으로 에러가 전달된다면

            if(err) return console.error(`뷰 처리중 에러 -> ${err}`);

            // 정상적으로 두번째 구멍으로 웹페이지가 전달된다면
            // 클라이언트(요청한 쪽, 웹브라우저) 쪽으로 응답을 보내줌
            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf8'});
            res.end(html);
        })
    }catch (err){
        console.error(`에러발생 -> err: ${err}}`);
    }finally {
        if(conn) conn.end();
    }

})

//모든 DB 작업 순서는 항상 이 순서를 따라야 함
//1. conn = await pool.getConnection()
//2. await conn.query(...)
//3. (작업 끝나면) conn.end() 또는 conn.release()





// /person/modify 요청경로로 요청이 들어오면 설정한 콜백함수를 실행함
router.route('/person/modify').get(async (req,res) => {
    console.log('/person/modify 요청경로로 요청됨');
    //클라이언트로부터 전달받은 요청 파라미터 확인하기
    const params =  req.query;
    console.log(`요청 파라미터  -> params : ${JSON.stringify(params)}`);

    // 데이터베이스에서 데이터 조회하기
    let conn;

    try{
        conn = await pool.getConnection();
        // 클라이언트(웹 브라우저)가 보내준 요청 파라미터를 SQL문과 합쳐서 업데이트 실행
        let sql = `update test.person 
                        set name ='${params.name}',age = ${params.age}, mobile = '${params.mobile}'
                        where id = ${params.id}`;
        let rows = await conn.query(sql, []);

        //업데이트한 결과로 고객 목록을 볼 수 있도록 list.ejs파일을 웹페이지 파일을 불러온 후 DB의 데이터와 결합해서 응답 보내기
        sql = `select id, name, age, mobile from test.person`;
        rows = await conn.query(sql, []);


        const context = {
            persons: rows
        }


        // views 폴더 안에 있는 list.ejs 웹페이지 파일을 읽어오고
        // context 객체(붕어빵) 안에 있는 속성들을 웹페이지와 결합해서
        // 콜백함수의 두번째 구멍으로 전달해줌
        req.app.render('list',context, (err,html) =>{
            // 만약 첫번째 구멍으로 에러가 전달된다면

            if(err) return console.error(`뷰 처리중 에러 -> ${err}`);

            // 정상적으로 두번째 구멍으로 웹페이지가 전달된다면
            // 클라이언트(요청한 쪽, 웹브라우저) 쪽으로 응답을 보내줌
            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf8'});
            res.end(html);
        })
    }catch (err){
        console.error(`에러발생 -> err: ${err}}`);
    }finally {
        if(conn) conn.end();
    }

})
// /person/update 요청경로로 요청이 들어오면 설정한 콜백함수를 실행함
router.route('/person/update').get(async (req,res) => {
    console.log('/person/update 요청경로로 요청됨');
    //클라이언트로부터 전달받은 요청 파라미터 확인하기
    const params =  req.query;
    console.log(`요청 파라미터  -> params : ${JSON.stringify(params)}`);

    try{

        const context = {
            params : params  //요청 파라미터
        }


        // views 폴더 안에 있는 update.ejs 웹페이지 파일을 읽어오서 요청 파라미터로 전달받은 데이터를 결합한 후
        // 콜백함수의 두번째 구멍으로 전달해줌
        req.app.render('update',context, (err,html) =>{
            // 만약 첫번째 구멍으로 에러가 전달된다면

            if(err) return console.error(`뷰 처리중 에러 -> ${err}`);

            // 정상적으로 두번째 구멍으로 웹페이지가 전달된다면
            // 클라이언트(요청한 쪽, 웹브라우저) 쪽으로 응답을 보내줌

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf8'});
            res.end(html);
        })
    }catch (err){
        console.error(`에러발생 -> err: ${err}}`);
    }
})



//웹서버 실행하기
const port = 7001;  //포트 번호 7001
http.createServer(app).listen(port, () => {  //웹서버가 포트에 맞는 번호로 대기를 함
    console.log(`웹 서버 실행됨 : port -> ${port}`);
})

