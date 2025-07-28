package basic;

public class InheritanceTest {

	public static void main(String[] args) {
		// Rectangle 클래스의 print()메서드를 실행하고 싶다
		Shape shape = new Rectangle();
		shape.print();
	}
	

	
}

// 일종의 추상클래스, .class로 존재한다. 객체생성되지 않는다. 그러나 타입으로 생성가능
// 내부에 메서드를 선언하는 곳에 사용
interface Shape {
	 
	// declare method, 추상메서드, 바디를 갖지 않는다. 호출할 수는 없다
	// public abstract 는 없어도 자동으로 적용
	// 선언은 바디 {}를 갖지 않는다
	public abstract void print();
}

// implements Shape 이란는 부분으로 인터페이스에 선언된 메서드들 정의 해야한다. 
class Rectangle implements Shape{
	 // 정의란 {}구간을 만드는 것이고, 호출되었을 때 무엇이 실행될지 기술
	public void print() {
		System.out.println("Rectangle");
	}
}

abstract class Circle implements Shape{
	public void print() {
		
	}
}
