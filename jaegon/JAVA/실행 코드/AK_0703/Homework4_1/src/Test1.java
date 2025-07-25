import com.lx.animal.*;
import java.lang.*;

public class Test1 {
	public static void main(String[] args) {


		Animal dog1 = new Dog("강아지1",2,"011");
		Animal dog2 = new Dog("강아지2",1,"012");
		
		Animal cat1 = new Cat("고양이1",2,"011");
		Animal cat2 = new Cat("고양이2",1,"012");
	
		//System.out.println(Animal.cnt);
		//System.out.println(Animal.animalList.size());

		for (int i = 0; i < Animal.animalList.size(); i++) {
			System.out.print(Animal.animalList.get(i).name + ", ");
			System.out.print(Animal.animalList.get(i).age + ", ");
			System.out.println(Animal.animalList.get(i).phone);
		}


		
		
		//dog1.action();
		//cat1.action();
	}
}
