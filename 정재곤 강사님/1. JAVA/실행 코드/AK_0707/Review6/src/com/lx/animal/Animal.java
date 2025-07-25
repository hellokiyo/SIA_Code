package com.lx.animal;

// 클래스는 붕어빵 틀이다
// 붕어빵 틀은 붕어빵을 만들기 위해서 만든다
// 붕어빵은 변수상자를 모아두기 위한 것
// 변수상자 외에 함수상자도 모아둘 수 있도록 해줌
// 붕어빵 틀은 틀일 뿐이고 진짜 붕어빵이 아님 = 붕어빵 틀에 들어간 코드는 붕어빵이 만들어졌을 때 붕어빵에 복제된다
public class Animal {

	// static을 붙이면 붕어빵에는 안 만들어지고 붕어빵 틀에 실제 변수상자가 붙어있게 됨
	// 클래스 변수라고 부름(class variable)
	public static int count = 0;

	// 클래스 메서드라고 부름(class method)
	public static void showCount() {
		System.out.println("만들어진 동물의 수 : " + count);
	}

	// 다른 가방(패키지)에 들어있는 클래스의 변수상자를 사용하고 싶다면 public을 붙여야 사용할 수 있음
	public String name;

	// 붕어빵 안에 들어가 있는 변쌍자는 필드(field) 또는 속성이라고도 부름
	public int age;

	// 함수상자 만들기
	// 붕어빵 안에 들어가 있는 함수상자는 메서드(method)라고 부름
	public void walk() {
		System.out.println("동물이 걸어갑니다.");
	}

	// 생성자 함수(constructor)
	// 특별한 함수 - 클래스(붕어빵 틀)의 이름과 같다, 이름 왼쪽에 함수상자 아래쪽 구멍의 크기를 표시하지 않는다.
	// 함수상자 위쪽 구멍이 없는 것(소괄호 안쪽이 비어있는 것)을 기본 생성자라고 한다 (default constructor)

	public Animal() {
		count +=1;
	}

	public Animal(String name, int age) {
		// 함수상자의 위쪽 구멍으로 들어온 값을 name 변수상자에 담아놓고 (= 기호 오른쪽)
		// 그것을 이 붕어빵의 name 변수상자에 넣어준다 (=기호 왼쪽)
		// 여기서 this는 붕어빵 자신을 가리킨다
		this.name = name;
		this.age = age;
		
		count +=1;
	}

}
