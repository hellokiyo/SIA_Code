package basic;

public class StringTest {

	public static void main(String[] args) {
		String str = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str == str2);
		System.out.println(str.equals(str2));
		str = str.replace('H','h'); //새로 생성된 문자열, String 객체는 immutable(내부에서 변경이 불가능) 하다
		System.out.println(str);
		
		str = str + "ha"; // 기존의 str 내부의 문자열이 변경된는 것이 아니라 새로 문자열이 생성되어 할당된다
		// String, StringBuffer, StringBuilder
		// 문자열을 상당히 여러번 가공해야한다면, StringBuilder를 사용해야한다
		String product = "S25:Samsug:1500000";
		String[] productInfo = product.split(":");
	}

}
