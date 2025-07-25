package com.lx.animal;

public class Dog implements IAnimal{

	String name;
	public void run() {
		System.out.println("강아지가 뛰어갑니다.");
	}
	public void setName(String name) {
		this.name = name;
		
	}
}
