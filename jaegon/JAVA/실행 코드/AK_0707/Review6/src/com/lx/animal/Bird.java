package com.lx.animal;

// 이 붕어빵 틀은 IAnimal 이라는 약속을 지킨다
public class Bird implements IAnimal{

	String name;
	
	// 약속에 들어가지 않는 함수상자
	public void walk() {
		System.out.println("새가 걸어갑니다");
	}
	
	// IAnimal에서 약속한 함수상자
	// 약속한 함수상자를 만들어주는 것도 재정의(overriding)에 들어감
	public void run() {
		System.out.println("새가 달려갑니다.");
	}
	
	public String getName() {
		return this.name;
	}
}
