import java.text.SimpleDateFormat;
import java.util.Date;

public class Dog extends Animal {

	Dog(String name) {
		super();
		super.name =name;
		System.out.println("강아지가 만들어졌어요. 이름 : " + name);
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
		//생년월일 대소문자
		String now = format.format(date);
		super.birth = now;
		
	}
}
