package myjdbc;

public class ExceptionTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		print(); // 예외처리를 하지 않은 채로 호춯
		} catch (RuntimeException e) {
			
		}
		/*
		 *  compile time exception , runtime exception : Runtime
		 *  checked exception, unchecked exception
		 */
	}

	private static void print() throws RuntimeException {
		// TODO Auto-generated method stub
		if (true)throw new RuntimeException("haha");
	}

}
