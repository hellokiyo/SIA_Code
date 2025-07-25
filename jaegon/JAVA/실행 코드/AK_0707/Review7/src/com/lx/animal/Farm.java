package com.lx.animal;

import java.util.ArrayList;
import java.util.HashMap;

public class Farm {

	public int total = 0;
	
	public HashMap<String, ArrayList<IAnimal>> animalMap = new HashMap<String, ArrayList<IAnimal>>();

	// type으로 "dog"가 전달되면 강아지 한마리를 반환해주고, "cat"이 전달되면 고양이 한마리를 반환해준다
	// money : 지불할 금액

	public IAnimal pay(String type, int money) {
		System.out.println("pay 함수 호출됨 - > type : " + type + ", money : " + money);
		IAnimal output = null; //output의 기본값을 null로 입력  null : 비어있는 변수상자

		if (type.equals("dog")) {
			ArrayList<IAnimal> dogs = animalMap.get("dogs");
			// IAnimal output = dogs.getFirst();
			// dogs.removeFirst();
			output = dogs.removeFirst(); // dogs.removeFirst();를 사용할때 dogs.getFirst();를 생략가능하다.
		} else if (type.equals("cats")) {
			ArrayList<IAnimal> cats = animalMap.get("cats");
			output = cats.removeFirst();
		} else {
			System.out.println("type의 값이 틀렸습니다.");
		}
		total +=money; // 총 가격
		
		return output;
	}

}
