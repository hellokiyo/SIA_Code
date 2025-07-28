
public class Person {
//변수상자 3개가 들어가 있는 붕어빵을 만드릭 위해서 Person이라는 이름의 붕어빵 틀 정의하기

	String name;
	int age;
	String mobile;

	Person() {

	}

	Person(String name, int age, String mobile) {

		// 생성자 함수 (반드시 class이름과 같아야함)
		// this.name을 5번줄에 있는 name에 넣음
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}

	void walk() {
		System.out.println("걸어갑니다.");
	}

}
