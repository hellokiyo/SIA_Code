
public class Test5 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 10;
		
		
		
		//더하기 함수 실행
		int output1 = add(a,b);
		System.out.println("더하기 결과 : ");
		//더하기 함수 실행
		int output2 = (a,b);
		System.out.println("더하기 결과 : ");
		//더하기 함수 실행
		int output3 = add(a,b);
		System.out.println("더하기 결과 : ");
		//더하기 함수 실행
		int output4 = add(a,b);
		System.out.println("더하기 결과 : ");
		
		
	}
	// 더하기 함수 상자
	static int add(int a, int b) {
		return a + b;
	}
	static int sub(int a, int b) {
		return a - b;
	}
	static int mul(int a, int b) {
		return a * b;
	}
	static int div(int a, int b) {
		return a / b;
	}
}
