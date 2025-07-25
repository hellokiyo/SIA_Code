package com.lx.animal;

public class Farm {

	Animal animal;

	// animal 변수상자에 값을 직접 넣어주는 것이 아니라 setAnimal 함수상자를 이용해서 animal 변수상자에 값을 넣어줌
	// 함수상자의 위쪽 구멍으로 전달된 붕어빵이 animal변수상자로 넣어짐 
	public void setAnimal(Animal animal){
		this.animal =animal;
	}
	
	// animal 변수상자의 값을 직접 가져가는 것이 아니라 getAnimal 함수상장를 이용해서 animal 변수상자의 값을 가져감
	// 함수상자의 아래쪽 구멍으로 animal 변수상자에 들어가 있는 붕어빵을 던져줌
	public Animal getAnimal() {
		return this.animal;
	}
	
	
}
