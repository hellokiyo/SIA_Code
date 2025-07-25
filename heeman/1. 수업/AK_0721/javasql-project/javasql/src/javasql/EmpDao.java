package javasql;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 필요한 검색기능
 * 1. 직원 이름으로 직원정보를 검색
 * 2. 입사년도로 검색
 * 3. 부서번호로 검색
 * 4. 직무로 검색
 * 5. 도시이름으로 검색
 * 6. 통계자료를 출력
 * 7. 부서장 성으로 부서원을 검색
 * 8. 나라이름으로 그 나라에 근무하는 직원을 조회
 **/
public interface EmpDao {

	// 1. 직원 이름으로 직원정보를 검색
	List<Employee> getByName(String name);

	// 2. 입사년도로 검색
	List<Employee> getByHireYear(int year);

	// 3. 부서번호로 검색
	List<Employee> getByDepartmentId(int departmentId);

	// 4. 직무로 검색
	List<Employee> getByJobTitle(String jobTitle);

	// 5. 도시이름으로 검색
	List<Employee> getByCity(String city);

	// 6. 통계자료를 출력
	Map<String, Object> getStatistics();

	// 7. 부서장 성으로 부서원을 검색
	List<Employee> getByManagerLastName(String lastName);

	// 8. 나라이름으로 그 나라에 근무하는 직원을 조회
	List<Employee> getByCountryName(String country);

}
