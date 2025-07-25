package com.lx.animal;

import java.util.ArrayList;

public class Animal {

	public static int cnt = 0;
	public String name;
	public int age;
	public String phone;

	public static ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	
	
	public Animal() {
		
	}
	
	public Animal(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone =phone;
	}
	
	public void stand() { // 서있기 함수
		System.out.println("동물이 서있습니다.");
	}

	public void sit() { // 앉기 함수
		System.out.println("동물이 앉습니다.");

	}

	public void run() { // 뛰기 함수
		System.out.println("동물이 뛰어갑니다.");
	}

	public void action() {
		sit();
		stand();
		run();
	}

}
