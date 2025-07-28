package com.lx.animal;

public class Cat extends Animal {

	public Cat() {
		cnt += 1;
	}

	public Cat(String name,int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone =phone;
		cnt += 1;
		
		animalList.add(new Animal(name,age,phone));

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
