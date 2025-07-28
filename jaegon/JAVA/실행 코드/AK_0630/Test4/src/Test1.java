public class Test1 {

	public static void main(String[] args) {

		// if문 사용하기
		int age1 = 20;

		if (age1 > 20) {
			System.out.println("나이가 20보다 많아요");
		} else {
			System.out.println("나이가 20보다 적거나 같아요");
		}

		// for문 사용하기
		int count = 0;

		count = count + 1;
		count = count + 2;
		count = count + 3;
		count = count + 4;
		count = count + 5;
		count = count + 6;
		count = count + 7;
		count = count + 8;
		count = count + 9;
		count = count + 10;
		System.out.println("1부터 10까지 더한 값 : " + count);

		
		int count2 = 0;
		
		for (int i = 0; i < 100; i++) {
			count2 = count2 + (i+1);
		}
		System.out.println("1부터 100까지 더한 값 : " + count2);
		
		//함수 상자 실행하기
		int output1 = add(10,10);
		System.out.println(output1);
		
	}

	// 더하기 함수상자 사용하기 - main밖에서 작성

	static int add(int a, int b) {
		int c = a + b;
		return c;
	}
}
