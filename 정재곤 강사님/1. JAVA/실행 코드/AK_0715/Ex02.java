package basic.AK_0715;
import java.util.ArrayList;

public class Ex02 {

	// - 1. 1부터 1000까지의 임의의 수를 저장하는 100칸으로 이루어진 배열을 생성하는 함수를 호출하여 배열을 생성한다.
	// - 2. 인덱스가 홀수인 수들을 출력하는 함수
	// - 3. 배열의 수들의 합을 반환하는 함수
	// - 4. 가장 작은 수의 위치(인덱스)를 반환하는 함수
	// - 5. 3의 배수만을 새로운 배열에 복사하여 리턴하는 함수

	// option! - 배열의 수들을 한 줄에 10개씩 출력하는 함수, 이때 각 수들은 줄이 맞춰져야 함
	// 5번은 List Collection API를 사용하는 것이 더 적절한다.

	public static void main(String[] args) {
		// odd(makeArray()); // 2번문제
		// sum(makeArray()); //3번문제
		// changeMin(makeArray()); // 4번 문제
		// changeMin(makeArray());

		// 1번 문제
		System.out.println("1번 문제");
		for (int i = 0; i < makeArray().length; i++) {
			System.out.print(makeArray()[i] + "\t");
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		// 2번 문제

		System.out.println("2번 문제");
		for (int i = 0; i < makeArray().length / 2; i++) {
			System.out.print(odd(makeArray())[i] + "\t");

			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}

		// 3번 문제
		System.out.println("3번 문제");
		System.out.println("랜덤 배열의 총합은 " + sum(makeArray()));

		// 4번 문제
		System.out.println("4번 문제");
		changeMin(makeArray());

		// 5번 문제
		System.out.println("5번 문제");
		mul3(makeArray());
	}

	// 1번 문제
	private static int[] makeArray() {
		int[] result = new int[100];
		for (int i = 0; i < 100; i++) {
			result[i] = (int) (Math.random() * 1000) + 1;
		}
		return result;
	}

	// 2번 문제
	private static int[] odd(int[] randomArr) {
		int[] oddIndex = new int[randomArr.length];
		int j = 0;

		for (int i = 0; i < randomArr.length; i += 2) {
			oddIndex[j] = randomArr[i];
			j++;
		}
		return oddIndex;
	}

	// 3번 문제
	public static int sum(int[] randomArr) {
		int sum = 0;
		for (int i = 0; i < randomArr.length; i++) {
			sum = sum + randomArr[i];
		}

		return sum;
	}

	// 4번 문제
	public static void changeMin(int[] num) {
		int minIndex = 0; // 가장 작은 인덱스의 번호

		for (int i = 0; i < num.length; i++) { // 8번째 인덱스가 8 , min 0번째 10
			if (num[i] < num[minIndex]) {
				minIndex = i;
			}
		}
		System.out.println(minIndex + "번째 인덱스가 가장 작은 값이다.");

	}

	// 5번 문제
	public static void mul3(int[] randomArr) {
		ArrayList mul3 = new ArrayList();
		for (int i = 0; i < randomArr.length; i++) {
			if (randomArr[i] % 3 == 0) {
				mul3.add(randomArr[i]);
			}
		}
		for (int i = 0; i < mul3.size(); i++) {
			System.out.println(i + "번째 배열의 값" + mul3.get(i));
		}

	}
}
