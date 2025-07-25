import java.util.ArrayList;

public class House{

	String name;
	ArrayList dogs;
	ArrayList cats;
	ArrayList person;

	House() {

	}

	House(String name, ArrayList person,ArrayList dogs, ArrayList cats) {
		this.name = name;
		this.person = person;
		this.dogs = dogs;
		this.cats = cats;
	}

}



