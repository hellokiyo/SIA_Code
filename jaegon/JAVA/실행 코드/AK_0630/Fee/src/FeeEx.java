/*
 * 입장료 계산 프로그램을 만들어본다.
 * 성인 수와 어린이 수를 변수에 넣은 후 [계산] 함수를 실행하면 콘솔 창에 입장료가 계산되어 표시된다.
 * 성인 1인당 입장료와 어린이 1인당 입장료는 하단의 안내글 안에 있는 입력상자의 값을 사용하여 계산한다.
 * 총 인원이 5명 이상일 때 안내그렝 표시된 단체 할인이 적용되도록 한다.
 * 
 *  조건에 따라 다른 계산을 할 때에는 if문을 사용한다.
 *  [계산] 함수 외에도 여러 개의 함수로 코드를 분리해도 좋다.
 */



public class FeeEx {

	public static void main(String[] args) {
		int kids = 1; // 어린이 수
		int adult = 4; // 성인 수

		if (people_count(kids, adult) >= 5) {
			System.out.println("총 입장료는 " + total_Fee(adult, kids) * 0.8 + "입니다.");
		} else {
			System.out.println("총 입장료는 " + total_Fee(adult, kids) + "입니다.");
		}

	}

	static int people_count(int adult, int kids) {
		return adult + kids;
	}

	static double total_Fee(int adult, int kids) {
		return adult * 20000 + kids * 9900;

	}

}

