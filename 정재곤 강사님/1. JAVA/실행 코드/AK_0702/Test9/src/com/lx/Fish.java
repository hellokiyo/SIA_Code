package com.lx;

public class Fish {

	String name; //필드라고도함
	int age;
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public int getAge() {
		return age;
		
	}
	
	public void setAge(int age) {
		if(age <20) {
			System.out.println("미성년자입ㅈ니다." );
			return;
		}
	}
	
	
	
	
	
	public Fish() {

	}

	public Fish(String name) {
		this.name = name;
	}

}
