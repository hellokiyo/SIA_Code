// 웹 서버 만들기
const http = require('http');
const express = require('express');
const cors = require('cors');
const mariadb = require('mariadb');

const pool = mariadb.createPool({
    host: 'localhost',
    port: '3307',
    user: 'root',
    password: 'rootroot',
    supportBigNumbers: true
});

const app = express();
app.use(cors());

const router = express.Router();
app.use('/', router);

// 공통 함수: JSON 응답
function sendJSON(res, data) {
    res.writeHead(200, { 'Content-Type': 'application/json;charset=utf8' });
    res.end(JSON.stringify(data));
}

// ------------------------------
// /person/select
// ------------------------------
router.get('/person/select', async (req, res) => {
    console.log('/person/select 요청경로로 요청됨');

    let conn;
    try {
        conn = await pool.getConnection();
        const sql = `select id, name, age, mobile from test.person`;
        const rows = await conn.query(sql);

        sendJSON(res, { code: 200, message: 'ok', data: rows });
    } catch (err) {
        console.error(err);
        sendJSON(res, { code: 500, message: '에러', error: err.toString() });
    } finally {
        if (conn) conn.end();
    }
});

// ------------------------------
// /person/insert
// ------------------------------
router.get('/person/insert', async (req, res) => {
    console.log('/person/insert 요청됨');
    const params = req.query;

    let conn;
    try {
        conn = await pool.getConnection();
        let sql = `insert into test.person(name, age, mobile)
                   values ('${params.name}', ${params.age}, '${params.mobile}')`;
        const rows = await conn.query(sql);

        sendJSON(res, { data: rows });
    } catch (err) {
        console.error(err);
        sendJSON(res, { code: 500, message: '에러', error: err.toString() });
    } finally {
        if (conn) conn.end();
    }
});
// ------------------------------
// /person/update
// ------------------------------
router.get('/person/update', async (req, res) => {
    console.log('/person/update 요청경로로 요청됨');

    const params = req.query;

    let conn;
    try {
        conn = await pool.getConnection();
        let sql = `update test.person
                   set name='${params.name}', age=${params.age}, mobile='${params.mobile}'
                   where id=${params.id}`;
        const rows = await conn.query(sql);

        sendJSON(res, { data: rows });
    } catch (err) {
        console.error(err);
        sendJSON(res, { code: 500, message: '에러', error: err.toString() });
    } finally {
        if (conn) conn.end();
    }
});


// ------------------------------
// /person/delete
// ------------------------------
router.get('/person/delete', async (req, res) => {
    console.log('/person/delete 요청됨');

    let conn;
    try {
        conn = await pool.getConnection();
        const sql = `delete from test.person where id = ${req.query.id}`;
        const rows = await conn.query(sql);

        sendJSON(res, { code: 200, message: '삭제 완료', rows });
    } catch (err) {
        console.error(err);
        sendJSON(res, { code: 500, message: '에러', error: err.toString() });
    } finally {
        if (conn) conn.end();
    }
});


// ------------------------------
// 서버 실행
// ------------------------------
const port = 7001;
http.createServer(app).listen(port, () => {
    console.log(`웹 서버 실행됨 : port -> http://localhost:${port}/person/select`);
});
