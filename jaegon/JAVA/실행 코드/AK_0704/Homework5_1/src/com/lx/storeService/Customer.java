package com.lx.storeService;

import java.util.ArrayList;

import com.lx.storeService.*;


public class Customer extends Store{
	
	public int age;
	public String phone;
	
	public static ArrayList<Product> bag = new ArrayList<Product>();

	
	
	public Customer(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	

	
}
