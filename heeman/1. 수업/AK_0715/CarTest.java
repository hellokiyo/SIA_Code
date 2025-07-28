package basic.AK_0715;

public class CarTest {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		Car car4 = new Car();

		car1.setName("Lightning Mcqueen");
		car1.setSpeed(300);

		car2.setName("Master");
		car2.setSpeed(80);

		car3.setName("Doc Hudson");
		car3.setSpeed(300);

		car4.setName("Sally Carrera");
		car4.setSpeed(200);

		System.out.println(car1.name + "의 스피드는 : " + car1.getSpeed());
		System.out.println(car2.name + "의 스피드는 : " + car2.getSpeed());
		System.out.println(car3.name + "의 스피드는 : " + car3.getSpeed());
		System.out.println(car4.name + "의 스피드는 : " + car4.getSpeed());

	}
}

class Car {
	String name;
	int speed;

	void setName(String name) {
		this.name = name;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

	int getSpeed() {
		return speed;
	}

}