package basic.AK_0717;

public class ExceptionTest2 {

	public static void main(String[] args) throws Exception{
		print();

		printHello(-5);

	}

	private static void print() throws Exception {
		printHello(-5);
		// printHello가 Exception을 했기때문에 print메서드도 Exception을 해야함
		// 하지만 여기서 끝낼려고 한다면 try-catch문으로 끝낼 수 있음 (더 이상 throws Exception을 안하기 위해)

	}

	private static void printHello(int count) throws Exception {

		if (count <= 0)
			throw new Exception("마이너스는 안되거든요!");
		// new Exception() < 예외 객체 생성후 catch문의 Exception e로 들어간다.
		for (int i = 0; i < count; i++) {
			System.out.println("Hello");
		}
	}

}