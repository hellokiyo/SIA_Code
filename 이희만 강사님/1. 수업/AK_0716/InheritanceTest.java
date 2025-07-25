package basic.AK_0716;


public class InheritanceTest {
	public static void main(String[] args) {
		//Rectangle클래스의 print(	) 메서드를 실행하고 싶다.
		Rectangle rectangle = new Rectangle();
		rectangle.print();
		
		Shape shape = new Rectangle(); 
		// print는 Shape에 선언되어 있고 실제로 실행되는 구간은 Rectangle에서 실행된다.
		shape.print();
		
	}
//	Shape shape = new Shape();
	Shape shape;
}


//일종의 추상클래스, .class로 존재한다. 객체생성되지 않는다. 그러나, 타입으로는 생성가능하다.
//내부에 메서드를 선언하는 곳에 사용한다.

interface Shape {
	//define method, 추상 메서드라고도 한다. 바디 (={}를 뜻함) 를 갖지 않는다. 호출할 수는 없다.
	public abstract void print();// public abstract는 없어도 자동으로 적용된다.
	
}

 class Rectangle implements Shape {
//추상클래스 : 내부에 구현되지않음
	
	
	//정의란 {} 구간을 만드는 것이고 호출되었을 때 무엇이 실행될지를 기술해 둔다.
	@Override
	public void print() {
		
	}
}