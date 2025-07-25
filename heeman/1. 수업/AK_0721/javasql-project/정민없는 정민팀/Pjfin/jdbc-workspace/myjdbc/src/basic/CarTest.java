package basic;

public class CarTest {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.setName("Lightning Mcqueen");
		car1.setSpeed(300);
		System.out.println("차 이름: " + car1.getName());
		System.out.println("차 속력: " + car1.getSpeed());

		Car car2 = new Car();
		car2.setName("Master");
		car2.setSpeed(80);
		System.out.println("차 이름: " + car2.getName());
		System.out.println("차 속력: " + car2.getSpeed());
		
		Car car3 = new Car();
		car3.setName("Doc Hudson");
		car3.setSpeed(300);
		System.out.println("차 이름: " + car3.getName());
		System.out.println("차 속력: " + car3.getSpeed());
		
		Car car4 = new Car();
		car4.setName("Sally Carrera");
		car4.setSpeed(200);
		System.out.println("차 이름: " + car4.getName());
		System.out.println("차 속력: " + car4.getSpeed());
	}

}

class Car {
	String name;
	int speed;

	Car() {
		
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}
	
	void setSpeed(int speed) {
		this.speed = speed;
	}

	int getSpeed() {
		return speed;
	}

	
	

}