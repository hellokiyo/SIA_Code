package com.lx.animal;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Dog extends Animal {

	public static int count = 0;

	public String birth;
	
	public Dog() {

	}

	public Dog(String name) {
		// this.name = name;
		// super.name = name;
		super(name);

		// count = count + 1;
		// count +=1;
		count++;

		// 생년월일 만들어주기
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		
		birth = format.format(date);
		
		
		
	}

}
