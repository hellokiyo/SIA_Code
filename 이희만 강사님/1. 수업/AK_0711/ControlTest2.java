package basic.AK_0711;

import java.util.Calendar;

public class ControlTest2 {
	static int FRIDAY =6;
	public static void main(String[] args) {
		// 오늘이 금요일이면? 불금이네요라는 문자열을 출력한다.
		
		Calendar cal = Calendar.getInstance(); //static <= ClasName.MethodName()  static일 수 밖에 없음
		//Calendar - 클래스
		//getInstance - Calendar의 메서드, 리턴타입은 Calender이다.
		//int today = cal.get(Calendar.DAY_OF_WEEK);
		int today = cal.get(7); //day of week
		System.out.println(today);
		if (today==6) { //금요일
			 System.out.println("불금이네용!!!");
		}
		
		
		
		
		//이렇게 쓰면 주석을 쓰지 않아도 됨
		int today2 = cal.get(Calendar.DAY_OF_WEEK); //day of week
		System.out.println(today2); 
		if (today2==Calendar.FRIDAY) { //금요일
			System.out.println("불금이네용!!!");
		}
		
		int today3 = cal.get(Calendar.DAY_OF_WEEK); //day of week
		System.out.println(today3); 
		if (today3==FRIDAY) { //금요일
			System.out.println("불금이네용!!!");
		}
		
	}
}
