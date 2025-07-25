package basic.AK_0717;

public class ExceptionTest4 {
	public static void main(String[] args) {
		try {
		print(); //예외처리를 하지 않은채 호출하고 있어서
		} catch(RuntimeException e) {
			
		}
		/*
		 * checked exception(compile time exception)
		 *  runtime exception(checked exception) : RuntimeException
		 */
	}

	private static void print() throws RuntimeException{
		if(true) throw new RuntimeException("haha");
		
	}
}
