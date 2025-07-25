package heeman.quiz2;

import java.util.Scanner;

/*
 * 몸무게와 키를 입력 받아 그 사람이 다이어트가 필요한지를 결정하는 프로그램을 작성하세요.
 * 단, 몸무게>(키-100)*0.9 이면 다이어트가 필요한 것으로 한다.) (if문)
 * 
 * 몸무게가 만일 몸무게>(키-100)*0.9  보다 크면 "다이어트가 필요함" 아니면 "다이어트가 필요하지 않음"
 * BMI = 체중 / (키 * 키)
 */

public class quiz2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double weight = 0;
		double height = 0;
		
		System.out.print("키를 입력하세요 : ");
		height = sc.nextInt();
		
		System.out.print("몸무게를 입력하세요 : ");
		weight = sc.nextInt();
		
		
		String bmi = String.format("%.1f",(weight/(height/100 *height/100)));
		// String.format은 소숫점 n번째까지 자리 포멧 함수임
		
		
		if(weight >(height-100)*0.9) {
			System.out.println("BMI 수치 : " +bmi);
			System.out.println("다이어트가 필요합니다.");
			System.out.println("그만 드세요");
		}else {			
			System.out.println("BMI 수치 : " +bmi);
			System.out.println("다이어트가 필요하지않음");
		}
		

	}
}
