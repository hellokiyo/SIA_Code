package basic.AK_0715;

public class PersonTest {

	public static void main(String[] args) {
		Person person0 = new Person();
		Person person1 = new Person(14, "꾸미");
		Person person2 = new Person(16, "지미");
		Person person3 = new Person(29, "로미");
		Person person4 = new Person(27, "쥬미");
		Person person5 = new Person(9, "포미");
		Person person6 = new Person(82, "할미");

		person0.selfIntroduce();
		person1.selfIntroduce();
		person2.selfIntroduce();
		person3.selfIntroduce();
		person4.selfIntroduce();
		person5.selfIntroduce();
		person6.selfIntroduce();

		System.out.println(Person.getPopulation());
	}

}

class Person {
	static int numberOfPersons = 0;
	int age;
	String name;

	Person() {
		age = 12;
		name = "Anonymous";
		numberOfPersons++;
	}

	Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}

	void selfIntroduce() {
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "살 입니다.");
	}

	static int getPopulation() {
		return numberOfPersons;
	}
}
