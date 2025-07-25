
public class Test1 {

	public static void main(String[] args) {

		// 콘솔에 출력하기
		System.out.println("안녕!");

		// 변수상자 만들기
		String name1;
		name1 = "안녕"; // 할당

		System.out.println("name1의 값 : " + name1);

		// 변수상자 만들면서 초기화하기
		String name2 = "안녕!";

		System.out.println(name2);

		int age1 = 21;
		int age2 = 22;

		int output1 = age1 + age2;

		System.out.println("더하기 결과 : " + output1);

		// if문(조건문) 사용하기
		if (age1 > 20) {
			System.out.println("age값이 20보다 큽니다. : " + age1);
			}
		else {
			System.out.println("age1위 값이 20보다 크지 않습니다.");
		}
		//for문(반복문) 사용하기
		
		int count  = 0;	
		for (int i = 0; i<10; i++) {
			count= count + (i+1);
			System.out.println("count" + i + " : " + count);
			
		}
		System.out.println("count의 값 : " + count);
		
		
	}

}
