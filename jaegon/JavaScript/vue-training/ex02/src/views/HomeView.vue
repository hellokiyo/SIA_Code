<template>
  <div>
    <h1>홈 화면</h1>

    <!-- 1. 인사 + 이미지 -->
    <div>
      <p class="group1">안녕!</p>
      <img src="@/assets/images/blank.png">
    </div>

    <!-- 2. 이름, 나이, 전화번호 입력 -->
    <div>
      <label>이름 : </label>
      <input type="text" v-model="name" />
      <br/>

      <label>나이 : </label>
      <input type="text" v-model="age" />
      <br/>

      <label>전화번호 : </label>
      <input type="text" v-model="mobile" />
      <br/>

      <button @click="show">확인</button>
    </div>

    <!-- 3. show() 실행 결과 -->
    <div>
      <p>{{ name }}</p>
      <p>{{ output1 }}</p>
    </div>

    <!-- 4. 더하기 기능 -->
    <div>
      <input type="text" v-model="inputA" />
      <input type="text" v-model="inputB" />

      <button @click="add">더하기</button>

      <p>더하기 결과 : {{ result1 }}</p>
    </div>
  </div>
</template>

<script setup>

import { ref } from "vue";  // 항상 맨 위에서 import // require랑 비슷함

// ------------------------------
// 1. 반응형 변수 (ref)
// ------------------------------
const name = ref("");
const age = ref("");
const mobile = ref("");
const output1 = ref("결과 : ");

const inputA = ref("");
const inputB = ref("");
const result1 = ref(0);

// ------------------------------
// 2. 함수 정의
// ------------------------------
function show() {
  console.log("show 함수 호출됨");
  // ref 값은 .value로 접근
  output1.value = `결과 : ${name.value}, ${age.value}, ${mobile.value}`;
}

function add() {
  const a = Number(inputA.value);
  const b = Number(inputB.value);
  result1.value = a + b;
}
</script>

<style scoped>
.group1 {
  color: red;
}
</style>
