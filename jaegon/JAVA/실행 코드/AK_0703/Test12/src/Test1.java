
public class Test1 {
	public static void main(String[] args) {
		// 동물농장만들기
		Farm farm1 = new Farm();

		Dog dog1 = new Dog("미미");
		System.out.println("강아지가 태어난 시간 : " + dog1.birth);
		farm1.animals.put("mimi", dog1);

		Cat cat1 = new Cat("라라");
		farm1.animals.put("rara", cat1);

		System.out.println("미미를 찾아줘 : " + farm1.animals.get("mimi").name);

	}

}
