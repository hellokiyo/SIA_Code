import java.util.ArrayList;
public class Test1 {

	public static void main(String[] args) {
		
		//집 만들기
		
		Dog dog1 = new Dog("강아지1");
		Cat cat1 = new Cat("고양이1");
		
		ArrayList<Dog> dogs = new ArrayList<Dog>(); 
		dogs.add(dog1);
		//<Dog>  ArrayList 안에 들어가는 자료형을 Dog로 한정시킨다.  권장하고 안전하다.
	    // dogs.add(10) 이런식으로 자료형을 넣으면 실행이 되지만 10은 dog이름이 아니다
		
		
		
		
		ArrayList cats = new ArrayList();
		cats.add(cat1);
		
	    House house1 = new House(dogs,cats);
		System.out.println("집안에 있는 강아지와 고양이의 이름 :" + 	         house1.dogs.size() + ", " + house1.cats.size());
		
		ArrayList names = new ArrayList(); //질문 1. arraylist라는 붕어빵틀에서 뽑았으니까 arraylist라고 써야함 < 질문2. 생성자 꼭써야하는지 
		names.add("홍길동1");
		names.add("홍길동2");
		names.add("홍길동3");
		
		System.out.println("names 안에 만들어진 칸의 개수 :" + names.size());
		System.out.println("names 안에 있는 칸 중에서 두번째 칸에 들어있는 이름은? : " + names.get(1));
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println("names의 "+ i + " 인덱스에 해당하는 칸의 값 : " + names.get(i));
			
		}
		

	}

}