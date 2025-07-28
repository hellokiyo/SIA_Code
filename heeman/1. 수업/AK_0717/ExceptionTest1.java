package basic.AK_0717;

public class ExceptionTest1 {
	public static void main(String[] args) throws Exception{
		//이 번거로운걸 없앨려고 main옆에 throws Exception을 작성한다.
		System.out.println("start");
		try {
			System.out.println("inside");
			printHello(-5);
			//19번줄 실행안됨, 10번줄 실행안됨
			System.out.println("inside end");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		System.out.println("end");
		//호출, 실행을 해야하는데 throw절에서 예외처리를 해야하는데 안되어 있음
		
		printHello(-5);
	}
	
	private static void printHello(int count) throws Exception {

		if (count <= 0)
			throw new Exception("마이너스는 안되거든요!");  
		//new Exception() < 예외 객체 생성후  catch문의 Exception e로 들어간다.
		for (int i = 0; i < count; i++) {
			System.out.println("Hello");
		}
	}
}
