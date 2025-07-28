package com.lx.animal;
/*

강아지(Dog)클래스를 만들고 메인 함수 안에서 진짜 강아지를 만들 떄마다 만든 강아지를 집 안의 변수상자 안에 넣도록 한다.
강아지 클래스는 com.lx.animal 패키지 안에 만든다.
강아지 클래스 안에서는 강아지의 이름, 나이, 전화번호를 넣어둘 수 있는 변수상자를 정의한다.
변수상자는 다른 패키지에서 사용할 수 없도록 public을 붙이지 않고 get,set함수상자를 추가하여 함수상자를 이용해 접근할 수 있도록 한다.

*/
public class Dog {

	String name;
	int age;
	String phone;
	
	
	
	
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

		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {

		this.phone = phone;
	} 
	
		
	public Dog(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		
	}
	
	
}
