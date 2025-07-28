package com.lx.animal;

// 인터페이스 : 약속을 정하는 것
public interface IAnimal {

	// 이 약속을 지키는 붕어빵 틀은 run이라는 함수상자를 꼭 가지고 있어야 한다
	// 여기에서는 약속만 한 것이므로 이 약속을 지키는 붕어빵 틀에서 run 함수상자를 만들어야한다
	public void run();
	
	public String getName();

}
