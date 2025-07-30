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

const name = ref(''); // 태그감지
const age = ref('');
const mobile = ref('');

onMounted(() => {
  console.log(`AboutView 화면의 onMounted 호출됨`)

  name.value = route.query.addNameInput; //감지되고 있는 name value에 입력한 값 노출
  age.value = route.query.addAgeInput;
  mobile.value = route.query.addMobileInput;
})


function goToHome() {
  router.push({
    path: '/',
    query: {
      name: addNameInput.value,
      age: addAgeInput.value,
      mobile : addMobileInput.value
    }
  });
}
</script>
