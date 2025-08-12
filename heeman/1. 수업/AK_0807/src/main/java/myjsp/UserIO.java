package myjsp;

import java.io.FileWriter;
import java.io.PrintWriter;

public class UserIO {
	// 사용자의 정보를 전달받아서 파일에 저장한다.
	public void addUser(UserVO user, String fileName) throws Exception {
		
		FileWriter fr = new FileWriter(fileName, true);
		PrintWriter out = new PrintWriter(fr,true); // append
		// FileWriter는 throws절로 정의되어있기 때문에
		// FileWrier 생성자 호출할때 Exception해줘야함

		String str = user.getLastName() + "|" + user.getFirstName() + "|" + user.getEmail();
		out.println(str);
		out.close();
	}
}
