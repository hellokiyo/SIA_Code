package javasql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// DB 접근 객체 생성
		EmpDaoImpl empDao = new EmpDaoImpl();
		// 표준 입력 객체 생성
		Scanner scan = new Scanner(System.in);

		// 직원정보 검색 기능구현 
		try {
			System.out.println("\n검색을 원하는 이름을 입력해주세요.");
			String name = scan.nextLine();

			List<Employee> empList = empDao.getByName(name);
			System.out.println("\n=== 직원이름 검색 결과 ===");
			for (int i = 0; i < empList.size(); i++) {
				Employee emp = empList.get(i);
				System.out.println(emp.toString());
			}
		} catch (Exception e) {
			System.err.println("오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
		
		//입사년도 검색 기능구현 
		try {
			System.out.println("\n검색을 원하는 입사년도를 입력해주세요.");
			String yearStr = scan.nextLine();
			int yearInt = Integer.parseInt(yearStr);
			List<Employee> empList = empDao.getByHireYear(yearInt);
			System.out.println("\n=== 입사년도 검색 결과 ===");
			for (int i = 0; i < empList.size(); i++) {
				Employee emp = empList.get(i);
				System.out.println(emp.toString());
			}

		} catch (Exception e) {
			System.err.println("오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}

		// 부서장 성으로 부서원 검색 기능 테스트
		try {
			// 부서장 성 검색 기능 테스트
			System.out.println("\n검색을 원하는 부서장 성을 입력해주세요.");
			String managerName = scan.nextLine();

			// 입력받는 도시명을 함수의 인자값으로 던지고 결과를 받음
			List<Employee> empListByManagerLastName = empDao.getByManagerLastName(managerName);

			System.out.println("\n=== 부서장 성 검색 결과 ===");
			for (Employee emp : empListByManagerLastName) {
				System.out.println(emp.toString());
			}

		} catch (Exception e) {
			System.err.println("오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
		
		// 도시이름 검색 기능 테스트
		try {
			// 도시이름 검색 기능 테스트
			System.out.println("\n검색을 원하는 도시를 입력해주세요.");
			String cityName = scan.nextLine();

			// 입력받는 도시명을 함수의 인자값으로 던지고 결과를 받음
			List<Employee> empListByCity = empDao.getByCity(cityName);
			
			System.out.println("\n=== 도시별 검색 결과 ===");
			for (Employee emp : empListByCity) {
				System.out.println(emp.toString());
			}

		} catch (Exception e) {
			System.err.println("오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}

		// 나라이름 검색 기능 테스트
		try {
			// 도시이름 검색 기능 테스트
			System.out.println("\n검색을 원하는 나라를 입력해주세요.");
			String countryName = scan.nextLine();

			// 입력받는 도시명을 함수의 인자값으로 던지고 결과를 받음
			List<Employee> empListByContry = empDao.getByCountryName(countryName);
			
			System.out.println("\n=== 나라별 검색 결과 ===");
			for (Employee emp : empListByContry) {
				System.out.println(emp.toString());
			}

		} catch (Exception e) {
			System.err.println("오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		} 
		
		// 직무 검색 기능 테스트
		try {
			// 직무 검색 기능 테스트
			System.out.println("\n검색을 원하는 직무를 입력해주세요.");
			String jobId = scan.nextLine();

			// 입력받는 직무명을 함수의 인자값으로 던지고 결과를 받음
			List<Employee> empListByJobId = empDao.getByJobTitle(jobId);

			System.out.println("\n=== 직무별 검색 결과 ===");
			for (Employee emp : empListByJobId) {
				System.out.println(emp.toString());
			}

		} catch (Exception e) {
			System.err.println("오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
		
		// 부서번호로 검색 기능 구현
		try {
			System.out.println("\n검색을 원하는 부서번호를 입력해주세요.");
			int departmentId = scan.nextInt();
			scan.nextLine();

			List<Employee> empListByDepartment = empDao.getByDepartmentId(departmentId);
			System.out.println("\n=== 부서번호 검색 결과 ===");
			for (Employee emp : empListByDepartment) {
				System.out.println(emp.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 통계치 기능 테스트
		try {
			// 통계치 기능 테스트
			System.out.println("\n통계치를 출력합니다.");
			@SuppressWarnings("unused")
			String enter = scan.nextLine();

			// 입력값 받지 않음 -> 통계 데이터 조회
			Map<String, Object> statisticsMap = empDao.getStatistics();

			// 1. 전체 통계 출력
		    System.out.println("📊 전체 직원 통계");
		    System.out.println("=".repeat(50));
		    System.out.println("총 직원 수   : " + statisticsMap.get("총직원수") + "명");
		    System.out.println("평균 급여    : $" + String.format("%,.2f", statisticsMap.get("평균급여")));
		    System.out.println("최고 급여    : $" + String.format("%,.2f", statisticsMap.get("최고급여")));
		    System.out.println("최저 급여    : $" + String.format("%,.2f", statisticsMap.get("최저급여")));
		    System.out.println("총 부서 수   : " + statisticsMap.get("총부서수") + "개");
		    System.out.println("총 직무 수   : " + statisticsMap.get("총직무수") + "개");
		    System.out.println("평균 근속년수 : " + String.format("%.1f", statisticsMap.get("평균근속년수")) + "년");
		    
		    System.out.println("\n");
		    
		    // 2. 부서별 상세 통계 출력
		    @SuppressWarnings("unchecked")
		    Map<String, Map<String, Object>> deptStats = 
		        (Map<String, Map<String, Object>>) statisticsMap.get("부서별상세통계");
		    
		    System.out.println("🏢 부서별 상세 통계");
		    System.out.println("=".repeat(80));
		    System.out.printf("%-15s %s %s %s %s %s%n", 
		        "부서명", "직원수", "평균급여", "최고급여", "최저급여", "평균근속년수");
		    System.out.println("-".repeat(80));
		    
		    for (Map.Entry<String, Map<String, Object>> entry : deptStats.entrySet()) {
		        String deptName = entry.getKey();
		        Map<String, Object> deptInfo = entry.getValue();
		        
		        System.out.printf("%-15s %3d명 $%,7.0f $%,7.0f $%,7.0f %,6.1f년%n",
		            deptName,
		            deptInfo.get("직원수"),
		            deptInfo.get("평균월급여"),
		            deptInfo.get("최고월급여"),
		            deptInfo.get("최저월급여"),
		            deptInfo.get("평균근속년수")
		        );
		    }
		    
		    System.out.println("\n");
		} catch (Exception e) {
			System.err.println("오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// scanner 자원 해제
			scan.close();
		}
	}
}	