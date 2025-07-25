package myjdbc;

import java.util.List;
import java.util.Scanner;

public class EmpMain2 {
	public static void main(String[] args) throws Exception {
		// 부서번호를 입력받아서 그 부서에 근무하는 사원들의 목록을 출력함
		System.out.println("jobId : ");
		Scanner scan = new Scanner(System.in);
		String jobId = scan.nextLine();

		while (jobId != null && jobId.length()!=0) {
			System.out.println(jobId);

			// 부서번호를 전달받아서 그 부서의 부서원 정보를 리턴함
			// 매개변수 : int타입,리턴타입 :
			List<Emp> empList = EmpDAO.getEmpListByjobId(jobId); // DB접속
			for (Emp emp : empList) { // 데이터 저장
				System.out.println(emp);
			}
			System.out.println("job_id(종료 : 엔터) : ");
			jobId = scan.nextLine();
		}
	}

}
