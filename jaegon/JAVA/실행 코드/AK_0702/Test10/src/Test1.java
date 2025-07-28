import java.util.ArrayList;
import com.lx.animal.*;
import com.lx.fish.*;


public class Test1 {
	public static void main(String[] args) {
		Fish fish1 = new Fish();
		fish1.name ="붕어빵1";
		fish1.swim();
		
		Shark shark1 = new Shark();
		shark1.name = "상어빵1";
		shark1.swim();
		
		
		
		Animal animal1 = new Animal();
		animal1.name = "동물1";
		
		Dog dog1 = new Dog();
		dog1.name = "강아지1" ;
		dog1.age = 1;
		
		dog1.run();
		
		
		Animal dog2 = new Dog();
		dog2.walk();
		//dog2.run();
		
		Animal cat2 = new Cat();
		
		ArrayList<Animal> animals =new ArrayList<>();   // Animal로 연결된 모든 변수들은 들어갈 수 있음
									//대신 가지고 있는 함수들은 사용할 수 없고 Animal안에 있는 함수만 사용가능하다.
									//장점 : 코드의 양이 굉장히 줄어든다.
		
		animals.add(dog2);
		animals.add(cat2);
		
		
		
		//Dog dog3 = animals.get(0);  //강아지의 본성을 들고 있지만, animal을 사용할려면 의 크기를 가져야함
		Animal dog3 = animals.get(0);
		Animal cat3 = animals.get(1);
		
		
		Dog dog4 = (Dog) dog3;  // 자료형이 Animal인 dog3인 변수를 자료형이 Dog인 dog4로 만듦 
							    //  >> animal의 코드를 받고 다시 dog로 형태를 변환함
								// 장점... 코드의 양이 줄어든데요...
		
		
		//Cat dog3 = new Dog();
		
		
		
		
		
		
	}
}
