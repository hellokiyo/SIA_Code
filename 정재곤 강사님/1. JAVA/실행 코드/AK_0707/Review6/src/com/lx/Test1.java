package com.lx;

import com.lx.animal.Animal;
import com.lx.animal.Bird;
import com.lx.animal.Dog;
import com.lx.animal.Farm;
import com.lx.animal.IAnimal;

public class Test1 {

	public static void main(String[] args) {

		// 변수 상자 만들기 (variable)
		// 변수상자를 만드는 이유 값(글자나 숫자가 메모리에 혼자 있을 수 없기 떄문에)
		// 변수상자가 하는 역할 : 메모리라는 창고같은 공간 안에서 어느 위치에 있는지 정보를 알고 있으면 찾아주는 역할
		// c언어 -> 포인터를 이용해서 변수상자의 위치를 알아낼 수 있음
		// 자바언어 -> 포인터가 없고 변수상자의 이름으로만 위치를 알아낼 수 있음

		String name1;

		// 변수상자에 값을 넣기
		// name1이라는 변수상자는 12번째 줄에서 이미 만들었고, 여기에서는 변수상자의 이르만으로 상자를 찾아옴
		// = 기호를 이용해서 오른쪽에 있는 글자를 왼쪽에 있는 name1이라는 변수상자에 넣음
		// 변수상자에 값을 넣는 것을 할당이라고 함 (assignment)
		name1 = "홍길동";

		// 변수상자의 크기를 숫자가 들어갈 수 있는 int 크기로 만들기
		int age1;
		age1 = 21;

		// 변수상자를 만들면서 값을 넣어주기
		// 처음부터 값을 넣어주기 때문에 초기화라고 함 (initialization)
		int age2 = 22;

		// 값을 더해주기
		// + 기호를 사용허면 + 기호 왼쪽과 오른쪽에 있는 값을 더해줌
		// 값이 아니라 변수상자가 오면 변수상자에 들어있던 값이 튀어나와서 더해지게 됨
		int output1 = age1 + age2;

		// 콘솔 창에 글자를 뿌려주는 것을 출력이라고 함 (output)
		// + 기호의 왼쪽이나 오른쪽에 글자가 오면 + 기호가 양쪽에 있는 것을 붙여주게 된다.
		System.out.println("더하기 결과 : " + output1);

		// if문 사용하기
		// if문은 if 다음에 소괄호, 다음에 중괄호
		// 소괄호 안의 조건이 맞다면 그 다음 중괄호 안의 코드가 실행됨
		// 소괄호 안의 조건이 맞지 않다면 else 다음 중괄호 안의 코드가 실행됨
		// 중괄호가 사용되면 중괄호 안의 코드는 들여쓰기로 함
		if (output1 > 40) {
			System.out.println("더하기 결과가 40보다 큽니다.");
		} else {
			System.out.println("더하기 결과가 40보다 크지 않습니다.");
		}

		// 함수상자 사용하기
		// 함수상자를 실행(또는 호출)하려면 함수상자의 이름, 그 다음에 소괄호를 붙임
		// 함수상자를 만들 때 표시한 구멍의 개수만큼 값을 전달해주어야 함
		// 함수상자 위쪽의 각 구멍을 파라미터라고 부름(parameter)
		print1("홍길동2");
		
		print1(22);

		int output2 = add(age1, age2);
		System.out.println("더하기 결과 : " + output2);

		
		// 붕어빵 틀에서 붕어빵 만들어내기
		// new 다음에 붕어빵 틀의 이름, 다음에 소괄호
		// 붕어빵을 넣어둘 변수상자의 크기는 붕어빵틀의 이름이 된다
		Animal animal1 = new Animal();
		
		// animal1 변수상자 안에 들어있는 붕어빵에는 name과 age 변수상자가 들어있고, 
		// 붕어빵 안에 들어있는 변수상자를 찾아서 사용할 때는 점(.) 연산자를 사용한다
		animal1.name = "홍길동1";
		animal1.age	= 21;
		
		
		// 새로 추가한 생성자 함수를 이용하면서 붕어빵 만들기
		// 붕어빵 - > 객체(object) 또는 인스턴스 객체(instance object) 
		// 붕어빵 틀 -> 클래스(class)
		Animal animal2 = new Animal("홍길동2", 22);
		System.out.println("animal2 변수상자에 들어있는 붕어빵의 이름은? : " + animal2.name);
		
		
		// 농장만들기
		Farm farm1 = new Farm();
		//farm1.animal = animal1;
		farm1.setAnimal(animal1);
		System.out.println("농장 안에 있는 동물의 이름은? : " + farm1.getAnimal().name);
		
		
		//Animal에서 상속받은 Dog 붕어빵 틀을 이용해서 강아지 붕어빵 만들기
		// 상속을 받았기 때문에 코드에서는 보이지 않지만 name, age와 같은 변수상자를 그대로 물려받음
		Dog dog1 = new Dog();
		dog1.name ="강아지1";
		dog1.age = 1;
		
		dog1.walk();
		
		
		//만들어진 동물의 수 출력하기
		System.out.println("만들어진 동물의 수 : "+ Animal.count);
		Animal.showCount();
	
		
		// 새 만들기
		// 새라는 붕어빵을 만들고 변수상자에 넣을 때 변수상자의 크기를 Bird가 아니라 IAnimal로 만듬
		IAnimal bird1 = new Bird();
		
		///walk 함수상자가 IAnimal에서 약속한 것이 아니기 때문에
		//IAnimal 크기의 변수상자에 들어가 있는 새라는 붕어빵에 들어있는 함수라고 하더라도 실행할 수 없음
		//bird1.walk();
		
		bird1.run(); //인터페이스
		
		// 약속으로 정한 IAnimal을 이용해서 붕어빵 틀 없이 바로 붕어빵 1마리를 만들 수 있음
		// 약속을 정할 때는 함수상자의 실행 코드(중괄호 안에 들어가는 코드)가 없었기 때문에
		// 붕어빵을 만들면서 실행 코드를 직접 넣어줌
		IAnimal animal3 = new IAnimal() {
			String name = "타조1";
					
			public String getName() {
				return this.name;
			}
						
			public void run() {
				System.out.println("타조가 뛰어갑니다.");
			}
		};
		
		System.out.println("animal3의 이름 : " + animal3.getName());
		animal3.run();
	}

	// 함수상자 만들기
	// 함수상자는 함수상자 안에 만들 수 없음
	// 함수상자를 만들 때는 함수상자의 이름, 그 다음에 소괄호, 그 다음에 중괄호
	// 소괄호 안에는 함수상자 안에 있다고 했을 때, 함수상자 위쪽 구멍을 표시함
	// 함수 상자의 이름 왼쪽에는 아래쪽 구멍의 크기를 표시함
	static void print1(String name) {
		System.out.println("이름 출력하기 : " + name);
	}

	// 함수상자의 이름이 같아도 위쪽 구멍의 크기가 다르기 때문에 다른 함수로 인식함
	static void print1(int age) {
		System.out.println("나이 출력하기 : " + age);
	}

	static int add(int a, int b) {
		// 함수상자 안에서 만들어진 result 변수상자는 이 함수상자의 중괄호 안의 코드가 실행되고 나면 없어짐
		int result = a + b; // result : 함수 실행용 일회용 변수

		// return을 하면 그 뒤에 있는 값을 함숫상자의 아래쪽 구멍으로 떨어뜨려 줌
		return result;
	}
}
