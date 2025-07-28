package com.lx;

import com.lx.animal.*;

public class Test1 {

	public static void main(String[] args) {

		// 변수상자
		String name;
		name = "홍길동1";

		int age1 = 21;

		// 함수상자
		int a = 10;
		int b = 10;
		int output1 = add(a, b);

	//	System.out.println("더하기 결과 : " + output1);

		// 붕어빵 틀 (클래스) 붕어빵만들기
		Animal animal1 = new Animal("동물1");
	//	System.out.println("붕어빵의 이름 : " + animal1.getName());

		// 강아지 만들기
		Dog dog1 = new Dog("강아지1");
	//	System.out.println("강아지 이름 : " + dog1.getName());

		// 동물 농장 만들기
		Farm farm1 = new Farm();
		// farm1.dog =dog1;
		farm1.setDog(dog1);

		farm1.animals1.add(new Dog("강아지2"));
		farm1.animals1.add(new Dog("강아지3"));

		/*
		 * System.out.println("강아지는 몇 마리 : " + farm1.animals1.size());
		 * 
		 * for (int i = 0; i < farm1.animals1.size(); i++) {
		 * 
		 * System.out.println("강아지" + i + " : " + farm1.animals1.get(i).getName());
		 * 
		 * }
		 * 
		 * // Dog 붕어빵 틀에 들어가있는 count 변수상자의 값 확인하기 System.out.println("강아지 마리 수 : " +
		 * Dog.count);
		 */
		// 고양이 만들기
		Cat cat1 = new Cat();
		
		cat1.name = "미미";
		dog1.name = "마이";
		
		farm1.animals2.put("mimi", cat1);
		farm1.animals2.put("my", dog1);
		
		System.out.println("mimi를 찾아줘 : " + farm1.animals2.get("mimi").getName());
		
		System.out.println("my의 생년월일 : " + ((Dog)farm1.animals2.get("my")).birth);  //강제 형변환
	}

	// 함수상자 만들기
	static int add(int a, int b) {
		return a + b;
	}

}
