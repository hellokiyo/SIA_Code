package store;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Store {
	public String name;

	// 제품관리
	public ArrayList<Product> products = new ArrayList<Product>();

	// 고객관리
	public ArrayList<Customer> customers = new ArrayList<Customer>();

	// 매장관리
	public ArrayList<Store> stores = new ArrayList<Store>();

	
	//매일 팔린 물건, 팔린 총 금액
	ArrayList<Product> storeTotalPrice = new ArrayList<Product>();

	
	//오늘 팔린 물건들
	HashMap<String, ArrayList<Product>> dayToSoldProductList = new HashMap<String, ArrayList<Product>>();
	
	//오늘 매출
	HashMap<String, Integer> dayToTotal = new HashMap<String, Integer>();
	
	
	Date nowDate = new Date();
	public SimpleDateFormat today = new SimpleDateFormat("YYYY-MM-dd");
	
	
	public Store(
	String name)
	{
		this.name = name;
	}

	//
	public void pay(Customer customer, Product product) {

		// 고객의 장바구니
		customer.total_buy.add(product);

		customer.total_price = customer.total_price + product.price;
		
		// 가게의 총 매출
		storeTotalPrice.add(product);
		
		// 오늘 팔린 물건 넣기
		dayToSoldProductList.put(today.format(nowDate), products);
		
		
		

	}
}
