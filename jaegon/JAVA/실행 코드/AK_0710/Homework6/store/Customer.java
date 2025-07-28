package store;
import java.util.ArrayList;

public class Customer {
	
	public String name;
	int age;
	String phone;
	
	
	//내가 구매한 제품들 
	public ArrayList<Product> total_buy =  new ArrayList<Product>() ;
	
	
	public int total_price = 0;
	
	// 생성자 함수를 통해서 이름, 나이, 전번 받기
	public Customer(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	

 
}
