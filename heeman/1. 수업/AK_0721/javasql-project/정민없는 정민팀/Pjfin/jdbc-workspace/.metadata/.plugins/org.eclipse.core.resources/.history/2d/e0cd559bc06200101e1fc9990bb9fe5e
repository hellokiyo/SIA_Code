package basic;

import java.util.Scanner;

public class WhileTest {
	public static void main(String[] args) {
		// 입력한 문자에 대한 아스키 값을 출력
		// q 나 Q룰 입력하면 종료
		Scanner scan = new Scanner(System.in);
		System.out.println("문자 입력 : ");
		String input = scan.nextLine();
		char first = input.charAt(0);
		while(first != 'q') {
			System.out.println((int) first);
			System.out.println("문자입력 : ");
			input = scan.nextLine();
			first = input.charAt(0);
		}
	}
}
