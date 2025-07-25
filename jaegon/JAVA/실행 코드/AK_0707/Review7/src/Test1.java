import java.util.ArrayList;
import com.lx.animal.*;

public class Test1 {
	public static void main(String[] args) {
		
		Farm farm1 = new Farm();
		
		// 강이지 여러 마리를 ArrayList에 추가하기
		ArrayList<IAnimal> dogs = new ArrayList<IAnimal>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		dogs.add(new Dog());
		
		// 강아지 여러 마리가 들어가 있는 ArrayList를 통째로 해시에 넣기 (이름은 dogs)
		farm1.animalMap.put("dogs",dogs);  //put > HashMap 함수

		
		ArrayList<IAnimal> cats = new ArrayList<IAnimal>();
		cats.add(new Cat());
		cats.add(new Cat());
		cats.add(new Cat());
		
		farm1.animalMap.put("cats",cats);  //put > HashMap 함수
		
		ArrayList<IAnimal> output1 = farm1.animalMap.get("dogs");
		ArrayList<IAnimal> output2 = farm1.animalMap.get("cats");
		
		System.out.println("농장의 동물 수 - > 강아지 : " + output1.size() + ", 고양이 : " + output2.size());
		
		// 강아지 사기
		IAnimal dog1 = farm1.pay("dog",20000);
		System.out.println("농장에서 판 총 금액 : " + farm1.total);
		
		IAnimal dog2 =  farm1.pay("dog", 30000);
		System.out.println("농장에서 판 총 금액 : " + farm1.total);
		
		
		
		
		
	}
}
