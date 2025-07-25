import java.util.Scanner;

public class chul {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //scanner 호출
		
		System.out.println("총 몇명입니까?");
		int leng = sc.nextInt(); //총인원수 받아오기
		
				
		String[] pers = new String[leng]; //길이가 leng인(총인원수 입력받기) 클래브 타입 name배열 생성
				
		
		for (int i = 0; i < leng; i++) {   //총인원수에 대한 이름 입력받기
			System.out.println(i+1 + "번 이름을 입력하세요");	
			pers[i] = sc.next();
			
			System.out.println(i+1+ "번 을 입력하세요");	
			pers[i] = sc.nextInt();
			
			System.out.println(i+1 + "번 전화번호를 입력하세요");	
			pers[i] = sc.next();
			
			
		}
		
		
		
		
		
		
	}
}
