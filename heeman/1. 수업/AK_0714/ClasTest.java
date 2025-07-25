package basic.AK_0714;

import java.util.HashMap;

public class ClasTest {
	public static void main(String[] args) {
		// class 구성요소 : 메서드, 생성자, 변수(필드)
		
		
		Employee emp; 
		// emp : Emp타입의 변수 선언, 힙영역에 생선된 객체의 주소값을 저장할 수 있는 
		//메모리 공간 stack영역에 할당 받음
				
		//stack영역에 64비트 메모리 공간을 할당받아서 emp라는 이름으로 참조하게 되고
		//그 공간엔 객체의 주소값을 저장할 수 있다.
		
		//내 멋대로 이해하기 : Employee 클래스가 힙영역에 생성되고 
		//그 주소값을 emp라는 이름으로 stack영역에 할당받아서 그 공간에 주소 저장함 
		
		
		emp = new Employee(); 
		//new Employee() 생성자 호출
		//new Employee() 객체 생성
		//new Employee() : Emp라는 클래스를 외부에 생성함
		//line36
		
		
		emp.count =500;
		
		System.out.println(emp.count);
		
		change(emp);
		System.out.println(emp.count);
	}
	private static void change(Employee emp2) {
		emp2.count = 1000;
	}
}
class Employee {
	int count;
	Employee() { //line18
		System.out.println("Employee()");
	}
}
