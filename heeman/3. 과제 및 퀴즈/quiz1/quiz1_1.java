package heeman.quiz1;

import java.util.Scanner;

public class quiz1_1 {

	public static void main(String[] args) {

		/*
		 * 버스요금이 어른 300원 청년이 200원 어린이가 100원이라고 할 때, 입력한 인원 전체의 버스 요금을 화면상에 표시하는 프로그램을
		 * 작성하세요. (단, 어른이 5명 이상 이면 어린이는 50원이다.) (if문) adult, youth, kid 중 하나가 0보다 작으면
		 * "잘못된 인원 수 입니다."를 출력한다. adult, youth, kid 중 하나가 0보다 작으면 "잘못된 인원 수 입니다."를 출력한다.
		 * total 요금 처리 total // 성인 및 청년 요금 어린이 요금 처리
		 */

		int adultFee = 300;
		int youthFee = 200;
		int kidFee = 100;

		Scanner scan = new Scanner(System.in);

		System.out.println("버스에 타는 인원을 순서대로 입력해주세요");
		System.out.println("어른이 5명 이상이면 어린이 요금은 50원입니다");
		int adultCount = 0;
		int youthCount = 0;
		int kidCount = 0;

		while (adultCount == 0 || youthCount == 0 || kidCount == 0) {

			System.out.print("어른 : ");
			adultCount = scan.nextInt();

			System.out.print("청년 : ");
			youthCount = scan.nextInt();

			System.out.print("어린이 : ");
			kidCount = scan.nextInt();
			
			if (adultCount == 0 || youthCount == 0 || kidCount == 0) {
				System.out.println("잘못된 인원 수 입니다.");
			}
		}

		if (adultCount >= 5) {
			kidFee = 50;
		}

		System.out.println("--------- 요금 계산기 --------");

		System.out.println("어른의 요금은 : " + adultCount * adultFee + "원 입니다.");
		System.out.println("청년의 요금은 : " + youthCount * youthFee + "원 입니다.");
		System.out.println("어린이의 요금은 : " + kidCount * kidFee + "원 입니다.");
		System.out.println(
				"따라서 총 요금은 : " + (adultCount * adultFee + youthCount * youthFee + kidCount * kidFee) + "원 입니다.");
		System.out.println("----------------------------");

	}

}
