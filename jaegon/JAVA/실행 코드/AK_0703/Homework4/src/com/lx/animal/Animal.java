package com.lx.animal;

public class Animal {

	public static int cnt = 0;
	public String name;
	public int age;
	public String phone;

	public void stand() { // 서있기 함수
		System.out.println("동물이 서있습니다.");
	}

	public void sit() { // 앉기 함수
		System.out.println("동물이 앉습니다.");
	}

	public void run() { // 뛰기 함수
		System.out.println("동물이 뛰어갑니다.");
	}

}
