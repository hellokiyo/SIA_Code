package basic.AK_0715;

public class PloymorphismTest {
	public static void main(String[] args) {
		System.out.println(1); // 메서드는 소문자, 동사로 시작하여야한다.
		System.out.println("1"); // println() : 메서드를 실행시키는것
		// 5번줄과 6번줄은 서로 다르게 정의되어 있다. 받아오는 인자값이 5번줄은 Integer형 6번줄은 String

		//다형성, 재정의
		change(1);
		change("1");
	}


	

	// overload
	private static void change(String string) {

	}
	//overload
	private static void change(int i) {

	}

}
//클래스의 3가지 구성요소 : 변수 메서드 생성자


class Sample {
	void change() {
		
	}
}