<template>
  <div>
    <button class="btn btn-primary mt-5 ms-5 px-5 py-3"><span class = "fs-2 fw-bold">확인</span></button>
  </div>

  <div class="mt-4 d-flex justify-content-center">  <!--flex로 잡고 justify로 정렬-->
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
                <button class="btn btn-sm btn-primary">수정</button>
                <button class="btn btn-sm btn-danger">삭제</button>
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

import {ref,onMounted} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'


const router = useRouter();

const nameInput = ref('');
const ageInput = ref('');

const name = ref('');

const persons = ref([]);

    /*
  {
    id : 1,
    name : '홍길동1',
    age : 21,
    mobile : '010-1000-1000'
  },
  {
    id : 2,
    name : '홍길동2',
    age : 22,
    mobile : '010-2000-2000'
  },
  {
    id:3,
    name : '홍길동3',
    age : 23,
    mobile : '010-3000-3000'
  }
])
*/
// 페이지가 로딩되면 호출되는 콜백함수를 등록하기


onMounted(() => {// window.리스너 웹페이지가 준비되면~
  console.log(`onMounted 호출됨`);

  requestPersonList();
})

function show() {
  console.log(`show 함수 호출됨`);

  name.value = nameInput.value
}


async function requestPersonList() {
  console.log(`requestPersonList 함수 호출됨`)

   try{
     const response = await axios({
       method : 'get',
       url : 'http://localhost:7001/person/list-data',
       data : {}//요청파라미터 넣는곳인데 get방식에선 필요없다.
     })

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

     //url로 가져온 데이터를 데이터로 바꿔주겠다.
     //데이터베이스를 가지고와서 데이터로 바꿔주겠다.
     persons.value = response.data.data;


   }catch(err) {
    console.error(`에러 -> ${err}`);
   }

}

function goToAbout() {
  router.push({
    path: '/about',
    query : {
      name : nameInput.value,
      age : ageInput.value
    }

  });
}
function goToMenu() {
  router.push('/menu');
}


</script>

<style scoped>

</style>