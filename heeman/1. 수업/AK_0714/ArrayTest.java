package basic.AK_0714;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayTest {

	public static void main(String[] args) {
		// array : 배열, 선언, 생성, 할당, 참조
		// int[10] list; // 선언할 때 갯수를 지정하지 않는다.
		int[] list;
		int list2[];
		// list = new int[3]; //생성할 땐 갯수를 지정해야함
		list = new int[10]; // 생성할 땐 갯수를 지정해야함
		list[0] = 55;
		//list[10] = 100; // 0~9칸이 생성되어서 10번째칸은 사용할 수 없다
		//동일타입, 크기변경 불가
		// ArrayList => Collection API 		

		int [] list3 = {23,45,7,12,46};
		
		for (int ele :list3) {
			System.out.println(ele);
		}
		
		for (int i = 0; i < list3.length; i++) {
			System.out.println(list3[i]);
		}
		
	}

}
