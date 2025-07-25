package basic.AK_0711;

public class VariableTest {

	public static void main(String[] args) {
		//메모리, 할당, 이름
		//할당받은 메모리 공간에 대한 이름
		int count = 100; //메모리를 할당받고 그 공간을 count이름으로 참조하게한다.
		System.out.println(Integer.toBinaryString(count));
		//count : 사용자가 임의로 지정한 int크기를 할당받는 변수이름
		count = 100; //할당받은 메모리공간에 100이라는 숫자를 기입한다.
		count = Integer.MAX_VALUE; // Integer 클래스에서 int타입 변수가 담을 수 있는 최댓값 //상수
		System.out.println(count);
		System.out.println(Integer.toBinaryString(count));
		
		count = count +1;
		System.out.println	(count);
		System.out.println(Integer.toBinaryString(count));
		
		count = count -1;
		System.out.println(count);
		System.out.println(Integer.toBinaryString(count));
		
		String name =new String("haaa"); //생성된  객체의 주소를 name변수로 할당받은 공간에 기입한다. 
	}
	
}








