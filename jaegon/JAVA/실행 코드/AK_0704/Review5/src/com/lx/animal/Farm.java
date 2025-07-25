package com.lx.animal;

import java.util.ArrayList;
import java.util.HashMap;

public class Farm {

	public Dog dog;
	public ArrayList<Dog> animals1 = new ArrayList<Dog>();

	public HashMap<String , Animal> animals2 = new HashMap<String , Animal>();
	
	public void setDog(Dog dog) {
		this.dog =dog;
	}
}
