package com.lx.animal;

public class Dog extends Animal{
	public String dogName; //견종
	public boolean sick; // 아픈지 안아픈지 0이면 yes,1이면 no로 

	public Dog(String name, String dogName, boolean sick) {
		this.name = name;
		this.dogName = dogName;
		this.sick = sick;
	}
	
}
