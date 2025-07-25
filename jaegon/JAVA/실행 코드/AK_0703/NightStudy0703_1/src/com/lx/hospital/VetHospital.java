package com.lx.hospital;

import java.util.ArrayList;

import com.lx.animal.*;

public class VetHospital {

	public static ArrayList<Animal> animals = new ArrayList<Animal>();

	public static void addAnimal(Animal animal) {
		animals.add(animal);
	}

	public static void printAllAnimals() { // 동물의 상태창

		for (int i = 0; i < animals.size(); i++) {

			// 자료형이 animal인 객체중 Dog인 객체는 Dog로 강제 형변환
			if (animals.get(i) instanceof Dog) {
				Dog dog = (Dog) animals.get(i);

				// 강아지의 병듦 여부
				if (dog.sick == true) {
					System.out.println(dog.name + "은 아픕니다.");
				} else {
					System.out.println(dog.name + "은 건강합니다.");

				}

			}
			// 자료형이 animal인 객체중 Cat인 객체는 Cat으로 강제 형변환
			else if (animals.get(i) instanceof Cat) {
				Cat cat = (Cat) animals.get(i);

				// 고양이의 털길에 따라 털관리 필요 여부
				if (cat.hairLength >= 5) {
					System.out.println(cat.name + "는 털관리가 필요합니다");
				} else {
					System.out.println(cat.name + "는 건강합니다.");
				}

			}
		}

	}

}
