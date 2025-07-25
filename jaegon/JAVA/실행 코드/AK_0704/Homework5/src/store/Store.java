package store;

import java.util.ArrayList;

import store.*;

public class Store {
	public String name;
	public Store(String name) {
		this.name=name;
	}
	
	public int num = 0;
	public int price = 0;
	
	
	public static ArrayList<Store> storeList = new ArrayList<Store>(); // store 배열

	public void pay(Customer customer, Product product) {
		
		Customer.bag.add(product);
		customer.price += product.price;
		
	}
	
	
	public static ArrayList<Product> products = new ArrayList<Product>();// product 배열
		
	public ArrayList<Product> getProduct() {
		return products;
	}
	
	public void setProduct(ArrayList<Product> products) {
		this.products =products;
	}
	
	
	public static ArrayList<Customer> customers = new ArrayList<Customer>(); // customer 배열
	
	public ArrayList<Customer> getCustomer(){
		return customers;
	}

	public void setCustomer(ArrayList<Customer> customer) {
		this.customers =customer;
	}
	
	
}
