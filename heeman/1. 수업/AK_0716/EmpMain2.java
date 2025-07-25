package basic.AK_0716;

import java.util.List;
import java.util.Scanner;

public class EmpMain2 {
	public static void main(String[] args) throws Exception {
		// 부서번호를 입력받아서 그 부서에 근무하는 사원들의 목록을 출력함
		System.out.println("hire_date : ");
		Scanner scan = new Scanner(System.in);
		String hire_date = scan.nextLine();

		while (hire_date != null && hire_date.length()!=0) {
			System.out.println(hire_date);

			// 부서번호를 전달받아서 그 부서의 부서원 정보를 리턴함
			// 매개변수 : int타입,리턴타입 :
			List<Emp> empList = EmpDAO.getEmpListByHireDate(hire_date); // DB접속
			for (Emp emp : empList) { // 데이터 저장
				System.out.println(emp);
			}
			System.out.println("hire_date(종료 : 엔터) : ");
			hire_date = scan.nextLine();
		}
	}

}
