
public class Dog {
	String name;

	// 기본 생성자 함수
	Dog() {
		
	}

	// 이름을 전달받는 생성자 함수
	Dog(String name) {
		this.name = name;
		System.out.println("강이지가 만들어졌어요 ->" + name);
	}
}
