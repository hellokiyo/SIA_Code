package com.lx.sea;

public class Fish {
	public int age;
	public String name;
	
	public Fish(String name) {
		this.name =name;
		Sea.count +=1;
	}

}
