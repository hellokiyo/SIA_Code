package com.lx.sea;

public class Fish {
	public String name;
	
	public Fish(String name) {
		this.name = name;
		Sea.count =  Sea.count+1;
		
		
	}
}
