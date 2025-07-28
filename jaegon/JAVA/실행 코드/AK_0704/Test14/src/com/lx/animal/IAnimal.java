package com.lx.animal;
//약속 정하기 (동물이라면 무조건 run이라는 함수상자가 있어야 해요)
public interface IAnimal {
	
	//붕어빵틀에 꼭 들어가야하는 것 정의
	//인터페이스에서는 함수만 만들 수 있고 전달받은 붕어빵틀은 꼭 함수를 받아서 적어야함
	// 다른 언어들은 프로토콜이라고 함
	
	public void run();
	
	public void setName(String name);
}
