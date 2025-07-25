import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {

		String[] str1 = {"주택","아파트","빌라"};
		
		ArrayList<Person> pers = new ArrayList<Person>();
		pers.add(new Person("엄마",45,"010"));
		pers.add(new Person("아빠",50,"010"));
		
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog("똘이"));
		dogs.add(new Dog("뭉이"));
					
		ArrayList<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat("뇽이"));
		cats.add(new Cat("냥이"));
		
		
		House house1 = new House(str1[0],pers,dogs, cats); 
		
		System.out.println(house1.person);
		
		for(Person person : pers) {
			System.out.println(house1.person.name);
		}
		
		
		ArrayList names = new ArrayList();
		// 질문 1. arraylist라는 붕어빵틀에서 뽑았으니까 arraylist라고 써야함 < 질문2. 생성자 꼭써야하는지

		System.out.println("names 안에 만들어진 칸의 개수 :" + names.size());

		for (int i = 0; i < names.size(); i++) {
			System.out.println("names의 " + i + " 인덱스에 해당하는 칸의 값 : " + names.get(i));

		}

	}

}
