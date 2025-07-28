import java.util.ArrayList;
import com.lx.animal.*;
import com.lx.person.Person;
import com.lx.sea.*;

public class Test1 {

	// System.out.println("안녕"); 실행을 위한 코드는 무조건 함수안에 있어야함
	// String name2 = "홍길동2"; //선언을 위한코드
	// name2 = "홍길동3"; //익스프레션 표현식 실행을 위한코드
	// static int count = 0;   // static(전역변수 : 어디서든 쓸 수 있음)을 안쓰면 다른 함수에서 사용할 수 없다
	

	public static void main(String[] args) {

		// 변수상자
		String name = "홍길동1";
		int age1 = 21;
		boolean isPerson = true;
		float weight = 80.5f;
		double weight2 = 80.5;

		int output1 = age1 + 20;
		System.out.println("더하기 결과 : " + output1);

		// 함수상자1
		int output2 = add(age1, 10);
		System.out.println("더하기 결과 : " + output2);

		// 붕어빵틀에서 붕어빵 만들기
		Person person1 = new Person();
		person1.name = "홍길동1";
		System.out.println("person1 변수상자에 들어가있는 붕어빵의 이름은 : " + person1.name + "입니다.");

		Person person2 = new Person("홍길동2");
		System.out.println("person1 변수상자에 들어가있는 붕어빵의 이름은 : " + person1.name + "입니다.");

		// 만들어진 붕어빵(동물)의 개수 저장하기
		// int count = 0;

		Animal animal1 = new Animal();
		
		// count = count + 1;    < 무식하게 count 세기
		// addCount();           < Test1에서 함수 상자 만들어서 세기
		//Animal.count = Animal.count + 1; <Animal에서 static사용한 변수를 만들어서 무식하게 count 세기
		
		
		animal1.name = "동물1";
		animal1.walk();

		Dog dog1 = new Dog();
		// count = count + 1; 
		//addCount();
		//Animal.count = Animal.count + 1;
		dog1.name = "강아지1";
		dog1.age = 1;
		dog1.walk();

		Cat cat1 = new Cat();
		// count = count + 1;
		//addCount();
		//Animal.count = Animal.count + 1;
		cat1.name = "고양이1";
		cat1.run();

		System.out.println("만들어진 동물 마리수 : " + Animal.count);

		// 하나의 변수상자안에 여러칸 만들기
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(dog1);
		animals.add(cat1);
		System.out.println("동물 마리수 : " + (animals.size() + 1));

		Animal out1 = animals.get(0);
		System.out.println("첫번째 동물의 이름 : " + out1.name);

		Animal out2 = animals.get(1);
		Cat out3 = (Cat) out2;
		out3.run();
				
		Sea sea = new Sea();
		sea.name = "대서양";
		
		Fish fish = new Fish("물고기");
				
		System.out.println("바다 생물의 갯수는 : " + sea.count);
		
	}

	/*
	 static void addCount() { count = count + 1; }
	 */
	
	
	// 함수상자 만들기
	static int add(int a, int b) {

		System.out.println("안녕");

		return a + b;
	}
}
