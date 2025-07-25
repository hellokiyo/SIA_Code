import com.lx.store.*;

public class Task5 {

	public static void main(String[] args) {
		
		Store store1 = new Store("매장");
		
		Customer customer1 = new Customer("홍길동", 21, "010-1111-1111");
		Customer customer2 = new Customer("이순신", 24, "010-2222-2222");
		Customer customer3 = new Customer("이정민", 26, "010-3333-3333");
		
		store1.customers.add(customer1);
		store1.customers.add(customer2);
		store1.customers.add(customer3);
		
		Product product1 = new Product("아메리카노", 4000);
		Product product2 = new Product("쿠키", 1000);
		
		store1.products.add(product1);
		store1.products.add(product2);
		
		System.out.println("매장 내의 고객의 수 : " + store1.customers.size() + "명");
		System.out.println("매징 내의 제품의 수 : " + store1.products.size() + "개");
		System.out.println("------------------------------------------------------");
		
		store1.pay(customer1, product1);
		store1.pay(customer1, product2);
		store1.pay(customer1, product2);
		
		store1.pay(customer2, product1);

		store1.pay(customer3, product2);



		 
		

	}

}
