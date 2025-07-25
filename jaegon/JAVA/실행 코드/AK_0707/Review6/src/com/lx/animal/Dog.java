package com.lx.animal;

//상속
// Dog 붕어빵 틀은 Animal 붕어빵 틀을 물려받는다
// 부모 붕어빵 틀에 들어있는 변수상자와 함수상자를 물려받는 것을 의미한다
// extends라는 키워드(미리 정해놓은 단어)를 사용한다
public class Dog extends Animal{

	// 부모 클래스(붕어빵틀)에 들어가 있는 함수 상자가 마음에 안들면 다시 만들 수 있음
	// 메서드 재정의라고 부름 (method overriding)
	public void walk() {
		System.out.println(super.name + " 강아지가 걸어갑니다."); // 오버라이딩 했을때 this를 super로도 쓸 수 있다.
	}
}
