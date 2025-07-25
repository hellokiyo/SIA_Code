
public class Test1 {

	public static void main(String[] args) {

		/*
		 * // 변수상자 만들기 String name1; name1 = "홍길동1";
		 * 
		 * // 변수 선언과 동시에 초기화 String name2 = "홍길동2";
		 * 
		 * int age1 = 21; int age2 = 22;
		 * 
		 * int output1 = age1 + age2; System.out.println("더하기 결과 : " + output1);
		 * 
		 * // 함수상자 실행하기 print1(); print2(8); int output2 = add(10, 10);
		 * System.out.println("더하기 결과 : " + output2);
		 */
		
		
		
		
		
		
		
		//붕어빵 만들기 변수상자 정리

		Fish fish1 = new Fish();
		fish1.name = "물고기1";
		fish1.age = 1;
		fish1.babies.add(new Baby());
		fish1.babies.add(new Baby());
		
		System.out.println("아기 물고기는 몇마리? : " + fish1.babies.size());

		
		
		
	    
		/*println("물고기의 이름 : " + fish1.name + "\t물고기의 나이 : " + fish1.age);
		 * Person person1 = new Person(); boolean isPerson = person1.walk(8);
		 * 
		 * System.out.println("walk 함수 실행 결과 : " + isPerson);
		 * 
		 * Person person2 = new Person("홍길동2", 22); System.out.println("person2의 정보 : "
		 * + person2.name);
		 * 
		 */
		
		
		
	}

	/*
	 * static int add(int a, int b) { return a + b; }
	 * 
	 * static void print2(int speed) { System.out.println(speed + "km 속도로 걸어갑니다.");
	 * 
	 * }
	 * 
	 * static void print1() { System.out.println("아룡하세연"); }
	 */
}
