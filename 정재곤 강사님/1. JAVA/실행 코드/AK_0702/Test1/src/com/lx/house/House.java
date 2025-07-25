package com.lx.house;

import java.util.ArrayList;
import com.lx.animal.Dog;



public class House {
	
	String name;
	Dog dog;
	
	public int num = 0;

	public ArrayList<Dog> dogs = new ArrayList<Dog>(num);

	public Dog getDog() {
		return this.dog;
	}

	public void setDog(Dog dog) {
		dogs.add(dog);
		this.dog = dog;
		num += 1;

	}

	public House() {

	}

	public House(String name) {
		this.name = name;
	}

	public void run() {
		if (dogs.size() == 0) {
			System.out.println("강아지가 없습니다.");
		} else {
			System.out.println("첫번째 강아지의 이름은 : " + dogs.get(0).getName());
		}
	}

}
