import com.lx.Fish;

public class Test1 {
	public static void main(String[] args) {
		
		Fish fish1 = new Fish("물고기1");
		fish1.setAge(10);
		
		
		System.out.println("fish1의 정보 - > 이름 : " + fish1.getName());
		System.out.println("fish1의 정보 - > 이름 : " + fish1.getAge());
		
		
		
	}
}
