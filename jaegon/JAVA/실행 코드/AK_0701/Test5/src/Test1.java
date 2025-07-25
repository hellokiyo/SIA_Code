
public class Test1 {

	public static void main(String[] args) {

		// 붕어빵 틀에서 붕어빵 만들기
		Fish fish1 = new Fish();

		// 붕어빵 안에 들어잇는 변수상자에 값을 넣기
		fish1.name = "붕어빵1";
		fish1.age = 1;

		System.out.println("붕어빵의 이름 : " + fish1.name);

		Person person1 = new Person("홍길동1", 21, "010-1000-1000"); // 생성자함수
		Person person2 = new Person("홍길동2", 22, "010-2000-2000");
		Person person3 = new Person("", 0, ""); // 생성자 함수를 자동 실행돼서 Person 생성자 함수는 구멍이 3개기 때문에 값을 3개 입력해줘야함
												//생성자 함수를 만들지 않는다면 내부에 자동적으로 Person () {}라는 디폴트 생성자를 생성함
		
		
		System.out.println("이름은 " + person1.name + "이고 나이는 " + person1.age + "이며 전화번호는 " + person1.mobile + "입니다.");
		System.out.println("이름은 " + person2.name + "이고 나이는 " + person2.age + "이며 전화번호는 " + person2.mobile + "입니다.");

		person1.walk();
	}

}
