package com.lx.fish;

public class Shark extends Fish {
	String mobile;
	
	
	//main에서 swim을 가져올 수는 있는데 
	//shark.swim 위쪽에서 Fish에 해당하는 fish1.swim를 호출하면 shark.swim에 fish1.swim이 작성이 된다 

	
	
	// 그러기에 
	// 덮어쓰기 (Fish 붕어빵 틀에서 물려받은 swim 함수를 덮어쓰기)   
	public void swim() {
		System.out.println("이름이 "+ this.name + "인 상어빵이 헤엄칩니다.");
		
	}
	
	
}
