import com.lx.sachik.*;
import java.util.Scanner;



public class Test1 {
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("정수를 두개 입력하세요");
		
		Sachik sa = new Sachik();
		
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		sa.add(a, b);
		sa.sub(a, b);
		sa.mul(a, b);
		sa.div(a, b);
		
		
		
		
		
	}
}
