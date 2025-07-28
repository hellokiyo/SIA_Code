package com.lx.store;
import java.util.ArrayList;

public class Store {
	
	String name;
	
	public static ArrayList<Customer> customers = new ArrayList<Customer>();
	public static ArrayList<Product> products = new ArrayList<Product>();
	

	
	public void pay(Customer customer, Product product) {
	d	customer.buyPro.add(product);
		customer.myTotalPrice += product.price;
		System.out.println(customer.name + "산 물건 : " + product.name + " ," + customer.name + "산 총 금액 : " + customer.myTotalPrice +"원");
		product.totalPrice += product.price;
		System.out.println("매장내의 총 매출 " + product.totalPrice + "원");
	}
	
	public Store(String name){
		this.name = name;
	}

}
