<template>
  <div>
    <!-- 페이지 제목 -->
    <div>
      <h1>홈 화면 </h1>
    </div>

    <!-- 서버 데이터 가져오기 버튼 -->
    <div>
      <button @click="requestPersonList()">웹서버에서 조회하기</button>
    </div>

    <div>
      <button @click ="requestPersonAdd">웹서버에서 추가하기</button>
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
        <tr v-for="(item, index) in persons" :key="item.id"> <!--id값에 따른 person찾기-->
          <td>{{ item.name }}</td>
          <td>{{ item.age }}</td>
          <td>{{ item.mobile }}</td>
        </tr>

      </tbody>

    </table>

    <!-- 페이지 이동 버튼 -->
    <div>
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

const persons = ref([]);    // 서버에서 가져올 사람 목록

const name = ref(''); // 태그감지
const age = ref('');


//고장난듯
/* onMounted: 화면이 처음 표시될 때 실행 */
onMounted(() => {
  console.log(`onMounted 호출됨`);
  requestPersonList(); // 페이지 시작 시 목록 조회
})


/* 서버에 요청해서 사람 목록 조회 (비동기) */
async function requestPersonList() {
  console.log('requestPersonList 함수 호출됨');

  try {
    const response = await axios.get('http://localhost:7001/person/list-data');
    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    // 서버에서 받은 JSON 데이터 배열을 persons에 저장
    persons.value = response.data.data;
  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}


async function requestPersonAdd() {
  console.log(`requestPersonAdd 함수 호출됨`);

  try {
    // addcustomer에서 받아오기
    const params = {
      name: name.value,
      age: age.value,
      mobile: mobile.value
    };

    // axios GET 요청 (쿼리 파라미터 방식)
    const response = await axios({
      method: 'get',
      url: 'http://localhost:7001/person/insert',
      params: params
    });

    console.log(`추가 응답 -> ${JSON.stringify(response.data)}`);

    // 추가 후 목록도 갱신
    persons.value = response.data.persons;

  } catch (err) {
    console.error(err);
  }
}













function goToAddCustomer() {
  // /add 페이지로 이동
  router.push('/add');
}
</script>

<style scoped>
/* 이 컴포넌트 안에서만 적용되는 스타일 */
</style>
