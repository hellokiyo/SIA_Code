package com.lx.store;
import java.util.ArrayList;

public class Customer {
	
	String name;
	int age;
	String modile;
	
	ArrayList<Product> buyPro = new ArrayList<Product>();
	
	int myTotalPrice = 0;
	
	
	
	public Customer(String name, int age, String modile){
		this.name = name;
		this.age = age;
		this.modile = modile;
		
	}

}
