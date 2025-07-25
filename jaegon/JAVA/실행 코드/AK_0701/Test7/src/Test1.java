
public class Test1 {

	public static void main(String[] args) {
		
		//물고기 만들기
		Fish fish1 = new Fish();
		fish1.name = "니모";
		
		//바다 만들기
		Sea sea1 = new Sea();
		sea1.name = "태평양";
		sea1.fish = fish1;
				
		System.out.println("바다 안에 들어있는 물고기의 이름은? \n" + sea1.fish.name); //실제 바다 객체안에 있는
		
			

	}

}


