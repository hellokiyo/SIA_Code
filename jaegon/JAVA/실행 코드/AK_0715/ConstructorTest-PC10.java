package basic.AK_0715;

public class ConstructorTest {

	public static void main(String[ ] args) {
		String str = new String(); 
		//int 타입의 매개변수를 받는 생성자가 정의되어 있지 않다.
		//좀 더 정제된 생성자가 정의되어
		User user1 = new User("heeman");
		//생성자는 없어도 되지만 있으면 존재하는 생성하는 생성자만 호출가능하다.
	}
}

class User {
	User(String name) {
		
	}
}