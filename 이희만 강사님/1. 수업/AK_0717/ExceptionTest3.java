package basic.AK_0717;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest3 {
	public static void main(String[] args) {
		// file reading
		FileReader fr = null;

		try {
			fr = new FileReader("list.txt");
			// FileReader()생성자를 만들때 throws절을 사용했기 때문에 예외처리를 해줘야함
			
			int read;
			read = fr.read();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {
			//예외가 발생여부 상관없이 실행되는 구간 
		}


	}
}
