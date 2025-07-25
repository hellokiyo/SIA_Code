
public class Car {
	String manufacturer;// 제조사
	String model; // 모델
	int year; // 연식

	Car(String manufacturer, String model, int year) {
		this.manufacturer = manufacturer;
		this.model =model;
		this.year = year;
		}
	
	public void printInfo(Car car) {
		System.out.println("제조사: "+car.manufacturer + "모델: " + car.model + "연식: " + car.year );
		
	}
}
