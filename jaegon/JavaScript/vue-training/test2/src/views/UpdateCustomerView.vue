<template>
  <div>
    <div>
      <h1>고객 추가 화면</h1>
    </div>

    <h3>고객 추가</h3>

    <div>
      <span>이름 : </span>
      <input type="text" v-model="addNameInput">
    </div>

    <div>
      <span>나이 : </span>
      <input type="text" v-model="addAgeInput">
    </div>

    <div>
      <span>전화번호 : </span>
      <input type="text" v-model="addMobileInput">
    </div>


    <div>
      <button @click="goToHome()">저장</button>
    </div>


  </div>
</template>

<script setup>

import {useRoute, useRouter} from "vue-router";
import {onMounted, ref} from "vue";
import axios from "axios";
const router = useRouter();
const route = useRoute();

// 반응형 입력값 변수 (이게 있어야 .value 사용 가능)
const addNameInput = ref('');
const addAgeInput = ref('');
const addMobileInput = ref('');

// onMounted 시 route.query 값이 있으면 초기화
onMounted(() => {
  console.log(`onMounted 호출됨`);

  addNameInput.value = route.query.addNameInput;
  addAgeInput.value = route.query.addAgeInput;
  addMobileInput.value = route.query.addMobileInput;
});


async function goToHome() {
  try {
    console.error("goToHome 함수 실행됨");

    await axios.get('http://localhost:7001/person/insert', {
      params: {
        name: addNameInput.value,
        age:  addAgeInput.value,
        mobile: addMobileInput.value
      }
    });
    router.push('/');
  } catch (err) {
    console.error(err);
  }
}


</script>
