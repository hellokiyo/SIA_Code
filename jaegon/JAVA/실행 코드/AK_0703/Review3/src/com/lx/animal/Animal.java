package com.lx.animal;

public class Animal {

	public String name;

	public static int count  = 0; // static <붕어빵틀에 있음에도 진짜임 평소와 달리 붕어빵을 만들어도 붕어빵에는 없다.
									// 보통은 붕어빵의 기능을 만든다하면 static을 붙인 것은 붕어빵틀의 기능을 만든거임
	public Animal() {
		count =count+1;
	}
	
	
	public void walk() {
		System.out.println(this.name + " 걸어갑니다.");
	}
	

}
