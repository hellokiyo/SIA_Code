package myjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest3 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		FileReader fr;
		try {
			fr = new FileReader("list.txt");
			int read;
			read = fr.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 예외가 발생되든 안되든지 실행되는 구간
		}
	}

}
