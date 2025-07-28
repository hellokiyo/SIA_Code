import java.util.ArrayList;

import com.lx.animal.*;
import com.lx.house.*;



public class Test1 {
	public static void main(String[] args) {
		House house =  new House("라움빌");
		
		Dog dog1 =new Dog("칙촉",2,"011");
		Dog dog2 =new Dog("빈츠",1,"013");
		Dog dog3 =new Dog("초코파이",5,"012");
		Dog dog4 =new Dog("김치",5,"012");
		Dog dog5 =new Dog("키위",5,"012");
		Dog dog6 =new Dog("칸쵸",5,"012");
		
		
		
		
		
		house.setDog(dog1);
		house.setDog(dog2);
		house.setDog(dog3);
		house.setDog(dog4);
		house.setDog(dog5);
		house.setDog(dog6);
		//house.Dogs.add(new Dogs());
		
		
		
		System.out.println("집에 있는 강아지 수는 : " + house.dogs.size()+ "마리 입니다.");
		
		for (int i = 0; i < house.dogs.size(); i++) {
			System.out.println(house.dogs.get(i).getName());
					
		}
		
		int lastDogNumber = house.dogs.size()-1;
		
		System.out.println("마지막 강아지의 이름은? : " + house.dogs.get(lastDogNumber).getName());
		System.out.println("마지막 강아지의 나이는? : " + house.dogs.get(lastDogNumber).getAge());
		System.out.println("마지막 강아지의 전화번호는? : " + house.dogs.get(lastDogNumber).getPhone());
		
		
		
		house.run();
		
		
		
	}
}
