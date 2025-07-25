import com.lx.animal.*;

public class Test1 {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		animal.name = "동물";
		animal.makeSound();
		
		
		Dog dog = new Dog();
		dog.name = "강아지";
		dog.makeSound();
		
		
		Cat cat = new Cat();
		cat.name = "고양이";
		cat.makeSound();
		
	}
}
