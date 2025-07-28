import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in); // Scanner 객체 생성
		System.out.print("숫자를 입력하세요 : ");
		int calc1 = in.nextInt();
		int calc2 = in.nextInt();

		System.out.println("입력하신 숫자는 : " + calc1 + "와 " + calc2 + "입니다.");

		int add = add(calc1, calc2);
		int sub = sub(calc1, calc2);
		int mul = mul(calc1, calc2);
		int div = div(calc1, calc2);

		System.out.println(calc1 + " + " + calc2 + " = " + add);
		System.out.println(calc1 + " - " + calc2 + " = " + sub);
		System.out.println(calc1 + " x " + calc2 + " = " + mul);
		System.out.println(calc1 + " / " + calc2 + " = " + div);
		
		
		
		
		
		
		//print1 함수 실행
		print1();
		walk(8);
		walk(10);
		
		
		
	}
	
	static void walk(int speed) { //리턴값이 없으면 void  > 리턴하지않는다.
		System.out.println(speed + "km 속도로 걸어갑니다.");
	}

	static void print1() {
		System.out.println("print1 함수가 실행되었어요");
	}

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
