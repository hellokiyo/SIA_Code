package com.lx.animal;

public class Cat implements IAnimal{
	String name;
	
	public void run() {
		System.out.println("고양이가 뛰어갑니다.");
	}
	public void setName(String name) {
		this.name = name;
		
	}
}
