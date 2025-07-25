import com.lx.animal.*;
import com.lx.hospital.*;
public class Test1 {

	public static void main(String[] args) {
	
		// 1
		Animal dog1 = new Dog("새우깡","푸들",true); //견종, 병듦여부
		VetHospital.addAnimal(dog1);
		
		// 2
		Animal dog2 = new Dog("꼬깔콘","시츄",false); //견종, 병듦여부
		VetHospital.addAnimal(dog2);
		
		// 3
		Animal cat1 = new Cat("빈츠",5,"고양이1"); // 털길이, 집사이름
		VetHospital.addAnimal(cat1);
		
		// 4
		Animal dog3 = new Dog("맛동산","리트리버",true); //견종, 병듦여부
		VetHospital.addAnimal(dog3);
		
		//5
		Animal cat2 = new Cat("아이비",2,"고양이2"); // 털길이, 집사이름
		VetHospital.addAnimal(cat2);

		
		System.out.println(VetHospital.animals.size());   //animals 배열리스트에 있는 동물 마리수
		
		VetHospital.printAllAnimals(); // 동물의 상태창
		
		
		
	}
}
