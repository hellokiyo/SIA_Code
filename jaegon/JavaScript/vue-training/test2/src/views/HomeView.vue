<template>

  <div class="mt-4 d-flex justify-content-center ">  <!--flex로 잡고 justify로 정렬-->
    <span class="fs-4 fw-bold">고객 목록 : </span>
  </div>

  <div class="card mt-4 mx-4">
    <div class="card-body">

      <ul class="list-group">
        <li class="list-group-item">

          <div class="row d-flex align-items-center">


            <div class="col-3">
              <p>이름</p>
            </div>

            <div class="col-2">
              <p>나이</p>
            </div>

            <div class="col-3">
              <p>전화번호</p>
            </div>

          </div>


          <div v-for="(item, index) in persons" :key="item.id">
            <div class="row d-flex align-items-center">
              <div class="col-1">
                <img class = "rounded-circle" src="@/assets/customer.png" style ="width:1.5em; height:1.5em;">
              </div>

              <div class="col-3">
                <p>{{ item.name }}</p>
              </div>

              <div class="col-2">
                <p>{{item.age}}</p>
              </div>

              <div class="col-3">
                <p>{{ item.mobile }}</p>
              </div>

              <div class="col-3">
                <button class="btn btn-sm btn-primary" @click="goToUpdateCustomer()" >수정</button>
                <button class="btn btn-sm btn-danger" @click="DeletePerson(item.id)">삭제</button>
              </div>

            </div>
          </div>

        </li>
      </ul>

    </div>

    <div class="card-footer">

      <div class="d-flex justify-content-end mt-2 mb-2">
        <button class="btn btn-primary fw-bold" @click="goToAddCustomer()">추가하기</button>

      </div>

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
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'

/* 라우터 객체 (페이지 이동 용도) */
const router = useRouter();

const persons = ref([]);    // 서버에서 가져올 사람 목록


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
    const response = await axios.get('http://localhost:7001/person/select');
    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    // 서버에서 받은 JSON 데이터 배열을 persons에 저장
    persons.value = response.data.data;
    // response.data > 위쪽 서버로 받아온 json파일
    // response.data.data > json파일의 실제 데이터 값 (id,name,age,mobile)
  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

async function DeletePerson(id) {
  console.log('DeletePerson 함수 호출됨');
  try {
    const response = await axios.get('http://localhost:7001/person/delete', {
      params: {
        id: id,
      }
    });

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    requestPersonList();
    //화면 초기화
  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}


function goToUpdateCustomer(){
  router.push('/update');
}

function goToAddCustomer() {
  // /add 페이지로 이동
  router.push('/add');
}
</script>

<style scoped>
/* 이 컴포넌트 안에서만 적용되는 스타일 */
</style>
