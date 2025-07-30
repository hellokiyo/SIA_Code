<template>
  <div>
    <!-- 페이지 제목 -->
    <div>
      <h1>홈 화면 </h1>
    </div>

    <!-- 입력 영역 -->
    <div>
      <span>이름 : </span>
      <input type="text" v-model="nameInput"> <!-- 양방향 바인딩 -->
    </div>

    <div>
      <span>나이 : </span>
      <input type="text" v-model="ageInput">
    </div>

    <div>
      <span>전화번호 : </span>
      <input type="text" v-model="mobileInput">
    </div>

    <div>
      <button @click="show()">확인</button> <!-- 입력값 표시 -->
    </div>

    <!-- 입력한 이름 결과 표시 -->
    <div>
      <p>결과 : {{ name }}</p>
    </div>

    <!-- 서버 데이터 가져오기 버튼 -->
    <div>
      <button @click="requestPersonList()">웹서버에서 조회하기</button>
    </div>

    <div>
      <button @click ="requestPeronAdd">웹서버에서 추가하기</button>
    </div>
    <!-- 서버에서 가져온 목록 테이블 -->
    <table>
      <thead>
      <tr>
        <th>이름</th>
        <th>나이</th>
        <th>전화번호</th>
      </tr>
      </thead>

      <tbody>
      <!-- v-for: persons 배열을 반복 -->
      <tr v-for="(item, index) in persons" :key="item.id">
        <td>{{ item.name }}</td>
        <td>{{ item.age }}</td>
        <td>{{ item.mobile }}</td>
      </tr>
      </tbody>
    </table>

    <!-- 페이지 이동 버튼 -->
    <div>
      <button @click="goToAbout()">정보화면으로</button>
      <button @click="goToMenu()">메뉴화면으로</button>
      <button @click="goToAddCustomer()">고객 추가화면으로</button>
    </div>
  </div>
</template>

<script setup>
/* ------------------------------
   Vue 3 문법: <script setup>
-------------------------------- */
import { onMounted, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

/* 라우터 객체 (페이지 이동 용도) */
const router = useRouter();

/* 반응형 데이터 (ref) */
const nameInput = ref('');
const ageInput = ref('');
const mobileInput = ref('');

const name = ref('');       // 화면에 출력할 이름
const persons = ref([]);    // 서버에서 가져올 사람 목록

/* onMounted: 화면이 처음 표시될 때 실행 */
onMounted(() => {
  console.log(`onMounted 호출됨`);
  requestPersonList(); // 페이지 시작 시 목록 조회
})

/* 버튼 클릭 시 입력한 이름을 name 변수에 복사 */
function show() {
  console.log(`show 함수 호출됨`);
  name.value = nameInput.value;
}

/* 서버에 요청해서 사람 목록 조회 (비동기) */
async function requestPersonList() {
  console.log(`requestPersonList 함수 호출됨`);

  try {
    // axios GET 요청
    const response = await axios({
      method: 'get',
      url: 'http://localhost:7001/person/list-data',
      data: {} // GET에서는 필요 없음
    });

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    // 응답 데이터를 persons에 저장 (화면 자동 갱신)
    persons.value = response.data.data;

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}


async function requestPeronAdd() {
  console.log(`requestPerosnAdd 함수 호출됨`);

  try {
    const response = await axios ({
      method : 'get',
      url : 'http://localhost:7001/person/modify',
      data : {}
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    // 응답 데이터를 persons에 저장 (화면 자동 갱신)
    persons.value = response.data.data;

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}











/* 라우터 이동 함수들 */
function goToAbout() {
  // /about 페이지로 이동 + 쿼리 파라미터 전달
  router.push({
    path: '/about',
    query: {
      name: nameInput.value,
      age: ageInput.value
    }
  });
}

function goToMenu() {
  // /menu 페이지로 이동
  router.push('/menu');
}

function goToAddCustomer() {
  // /add 페이지로 이동
  router.push('/add');
}
</script>

<style scoped>
/* 이 컴포넌트 안에서만 적용되는 스타일 */
</style>
