import com.lx.animal.*;

public class Test1 {
	public static void main(String[] args) {

		Animal animal = new Animal();

		Animal dog1 = new Dog();
		Animal dog2 = new Dog();
		Animal dog3 = new Dog();
		dog1.name = "강아지";

		Animal cat1 = new Cat();
		Animal cat2 = new Cat();
		Animal cat3 = new Cat();
		cat1.name = "고양이";

		System.out.println(animal.cnt);

		dog1.sit();
		dog1.stand();
		dog1.run();

		cat1.sit();
		cat1.stand();
		cat1.run();

	}
}
