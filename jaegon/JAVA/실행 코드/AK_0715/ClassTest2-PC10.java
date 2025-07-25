package basic.AK_0715;

public class ClassTest2 {
	public static void main(String[] args) {
		Util util = new Util();
		util.name = "hahaha";
		System.out.println(util.name);
		
		Util util2 = new Util();
		System.out.println(util2.name); 
		//static으로 선언했기 때문에 util2도 동일한 name을 가진다.
		
	}
}

class Util {
	static String name;
	public static String getName() {
		return name;
	}

}

class Sam2{
	int count; // instance 변수, 객체변수 => 객체를 생성하고나서 참조가능하기에
	static int amount; // 클래스 변수 => 이 클래스로 생성된 객체가 공유하기에
	void print() {
		int localCount; //로컬변수, 지역변수, 이 지역에서만 참조 가능하다. 지역은 {} 블럭이다.
		
		try {
			int myCount  =500; //로컬변수라고 해도 되지만 특별히 임시변수라고도 한다.
		}catch(Exception e) {
			
		}
		System.out.println();
	}
}
