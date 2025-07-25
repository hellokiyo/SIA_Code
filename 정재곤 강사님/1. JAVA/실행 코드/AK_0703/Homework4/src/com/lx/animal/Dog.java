package com.lx.animal;

public class Dog extends Animal {

	public Dog() {
		cnt += 1;
	}

	public void stand() { // 서있기 함수
		System.out.println(name + "가 서있습니다.");
	}

	public void sit() { // 앉기 함수
		System.out.println(name + "가 앉습니다.");
	}

	public void run() { // 뛰기 함수
		System.out.println(name + "가 뛰어갑니다.");
	}
}
