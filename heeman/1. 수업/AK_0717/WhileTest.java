package basic.AK_0717;

import java.util.Scanner;

public class WhileTest {
	public static void main(String[] args) {
		// 입력한 문자에 대한 아스키값을 출력함
		// q나 Q를 입력하면 종료
		Scanner scan = new Scanner(System.in);

		System.out.println("문자입력 : ");
		String input = scan.nextLine();
		char first = input.charAt(0) ; //0번째 글자만 따오기
		while(first != 'q') { // while의 조건문엔 꼭 true 나 false가 들어가야함
			System.out.println((int)first);
			input = scan.nextLine();
			first = input.charAt(0);
		}
		
	}
}
