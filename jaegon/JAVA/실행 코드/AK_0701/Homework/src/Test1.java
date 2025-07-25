import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {

		// 고양이 객체 생성
		Cat cat = new Cat("뇽뇽이");

		// 강아지 객체 생성
		Dog dog = new Dog("똘똘이");

		// 사람 객체 생성
		Person person = new Person("박정훈", 25, "01057882120");

		// 집 객체 생성
		House house1 = new House("라움빌", person, dog, cat);
		House house2 = new House("휴스빌", person, dog, cat);
		House house3 = new House("대성원룸", person, dog, cat);

		Scanner sc = new Scanner(System.in);

		System.out.println("몇번째 집에 방문할까요? : ");
		int num = sc.nextInt();

		for (int i = 0; i < 10; i++) {
			if (num == 0)
				break;
			else if (num < 1 || num > 3) {
				System.out.println("다시입력해주세요");
				num = sc.nextInt();
			}
			else if (num == 1) {
				System.out.println("집 이름(house1.name) : " + house2.name);
				System.out.println("집에 사는 사람 이름(house1.person.name) : " + house2.person.name);
				System.out.println("집에 사는 사람 나이(house1.person.age) : " + house2.person.age);
				System.out.println("집에 사는 사람 전화번호(house1.person.number) : " + house2.person.number);
				System.out.println("집에 사는 강아지 이름(house1.dog.name) : " + house2.dog.name);
				System.out.println("집에 사는 고양이 이름(house1.cat.name) : " + house2.cat.name);
				System.out.println();
				System.out.println("이번엔 몇번째 집");
				num = sc.nextInt();
			} else if (num == 2) {
				System.out.println("집 이름(house2.name) : " + house3.name);
				System.out.println("집에 사는 사람 이름(house2.person.name) : " + house3.person.name);
				System.out.println("집에 사는 사람 나이(house2.person.age) : " + house3.person.age);
				System.out.println("집에 사는 사람 전화번호(house2.person.number) : " + house3.person.number);
				System.out.println("집에 사는 강아지 이름(house2.dog.name) : " + house3.dog.name);
				System.out.println("집에 사는 고양이 이름(house2.cat.name) : " + house3.cat.name);
				System.out.println();
				System.out.println("이번엔 몇번째 집");
				num = sc.nextInt();
			} else if (num == 3) {
				System.out.println("집 이름(house.name) : " + house3.name);
				System.out.println("집에 사는 사람 이름(house3.person.name) : " + house3.person.name);
				System.out.println("집에 사는 사람 나이(house3.person.age) : " + house3.person.age);
				System.out.println("집에 사는 사람 전화번호(house3.person.number) : " + house3.person.number);
				System.out.println("집에 사는 강아지 이름(house3.dog.name) : " + house3.dog.name);
				System.out.println("집에 사는 고양이 이름(house3.cat.name) : " + house3.cat.name);
				System.out.println();
				System.out.println("이번엔 몇번째 집");
				num = sc.nextInt();

			}

		}
	}

}
