import store.*;

public class main {
	public static void main(String[] args) {
		
	
		// 공장에서 제품 생성
		Product product1 = new Product("물건1", 1000);
		Product product2 = new Product("물건2", 2000);
		Product product3 = new Product("물건3", 3000);
		Product product4 = new Product("물건4", 4000);
		Product product5 = new Product("물건5", 5000);
		
		
		// 사람 탄생
		Customer customer1 = new Customer("고객1", 21, "010-1111-1111");
		Customer customer2 = new Customer("고객2", 21, "010-2222-2222");
		Customer customer3 = new Customer("고객3", 21, "010-3333-3333");
		
		// 매장 건설
		Store store1 = new Store("매장1");
		Store store2 = new Store("매장2");
		
		
		// 매장에 제품 입고하기
		store1.products.add(product1);
		store1.products.add(product2);
		store1.products.add(product3);
		store1.products.add(product4);
		store1.products.add(product5);
		
		// 매장에 장보러 온 사람들 
		store1.customers.add(customer1);
		store1.customers.add(customer2);
		store1.customers.add(customer3);
			
		
		System.out.println(store1.name + "에 있는 인원 : " + store1.customers.size() + "\t"+ store1.name + "에 있는 제품 재고 : " + store1.products.size());

		
		//고객1의 장바구니
		store1.pay(customer1, product1);		
		store1.pay(customer1, product2);		
		store1.pay(customer1, product3);		
		store1.pay(customer1, product4);		
		store1.pay(customer1, product5);
		
		//고객2의 장바구니
		store1.pay(customer2, product1);		
		store1.pay(customer2, product2);		
		store1.pay(customer2, product3);
		
		//고객3의 장바구니
		store1.pay(customer3, product5);		
		
		
		
		System.out.println(customer1.name+"님이 구매한 갯수 : " + customer2.total_buy.size());
		System.out.println(customer1.name+"님의 총 금액 : " + customer2.total_price);
		
		
	}
}
