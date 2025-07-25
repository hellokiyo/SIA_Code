
public class Test2 {

	public static void main(String[] args) {

		// 함수상자 실행하기(요청한다, 호출한다)
		int output1 = add(10, 10);
		System.out.println("더하기 결과 : " + output1);

		print1();
		print2("홍길동1");

	}

	static void print1() {
		System.out.println("print1 함수 호출됨");

	}

	static void print2(String name) {
		System.out.println("print2 함수 호출됨 - > " + name);
		
	}

	static int add(int a, int b) {
		int output = a + b;
		return output;
	}

}
