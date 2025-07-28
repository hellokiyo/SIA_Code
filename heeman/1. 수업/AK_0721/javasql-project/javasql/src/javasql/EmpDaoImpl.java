package javasql;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class EmpDaoImpl implements EmpDao {
	// 연결 정보를 저장할 필드
	private final String url;
	private final String username;
	private final String password;

	// static 블록에서 드라이버 로드 -> static 블록은 클래스가 메모리에 로드 시 한 번만 실행됨.
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("MySQL 드라이버를 찾을 수 없습니다.");
		}
	}

	// 생성자에서 파일 읽기
	public EmpDaoImpl() {
		Properties props = new Properties();
		try (FileReader reader = new FileReader("C:\\lx\\jdbc-workspace\\javasql\\dp-info.properties")) {
			props.load(reader);
			this.url = props.getProperty("url");
			this.username = props.getProperty("userName");
			this.password = props.getProperty("password");

			// 필수 값 체크
			if (url == null || username == null || password == null) {
				throw new RuntimeException("DB 연결 정보가 완전하지 않습니다");
			}
		} catch (IOException e) {
			throw new RuntimeException("DB 설정 파일을 읽어올 수 없습니다.");
		}
	}

	// Connection 얻는 메서드
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	// 인터페이스 내 메서드 구현
	@Override
	public List<Employee> getByName(String name) {
	
		List<Employee> empList = new ArrayList<>();

		String sql = """
					SELECT employee_id,
						   CONCAT(first_name, ' ', last_name) as 직원이름,
						   DATE_FORMAT(hire_date,'%Y-%m-%d') as 입사년도,
						   salary AS 월급여
					FROM
						employees
					WHERE
						CONCAT(first_name, ' ', last_name) LIKE ?
					""";

		// DB 연결
		try {
			Connection conn = this.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ? 자리에 값 설정
			String wildName = "%" + name + "%";
			pstmt.setString(1, wildName);

			// 쿼리문 실행
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					Employee e = new
							Employee();
					e.setEmployeeId(rs.getInt("employee_id"));
					e.setFullName(rs.getString("직원이름"));
					e.setHireDateString(rs.getString("입사년도"));
					e.setSalary(rs.getDouble("월급여"));
					empList.add(e);
				}
				;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empList;
		
	}

	@Override
	public List<Employee> getByHireYear(int year) {
        List<Employee> empList = new ArrayList<>();
        String sql = 
        		 """
				SELECT 
					employee_id, 
					CONCAT(first_name,' ' ,last_name) AS 직원이름, 
					DATE_FORMAT(hire_date,'%Y-%m-%d') AS 입사년도, 
					salary AS 월급여
        		FROM 
    		    	employees 
        		WHERE 
    		    	YEAR(hire_date) = ?;
				""";
        try {
			Connection conn = this.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, year);
			try (ResultSet rs = pstmt.executeQuery();) {					
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setEmployeeId(rs.getInt("employee_id"));
					emp.setFullName(rs.getString("직원이름"));
					emp.setHireDateString(rs.getString("입사년도"));
					emp.setSalary(rs.getDouble("월급여"));
					empList.add(emp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<Employee> getByDepartmentId(int departmentId) {
		// 직원들 객체 담을 리스트 생성
		List<Employee> employees = new ArrayList<>();
				
		// 쿼리문
		String sql = """
				SELECT
					employee_id AS 직원번호,
				    CONCAT(first_name, " ", last_name) AS 직원성명,
				    email AS 이메일,
				    phone_number AS 전화번호,
				    DATE_FORMAT(hire_date, "%Y-%m-%d") AS 입사일자,
				    job_id AS 직무,
				    salary AS 월급여,
				    manager_id AS 관리자번호,
				    department_id AS 부서번호
				FROM
					employees
				WHERE
					department_id = ?;
				""";
		// DB 연결
		try {
			Connection conn = this.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ? 자리에 값 설정
			pstmt.setInt(1, departmentId);
			// 쿼리문 실행
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					// 직원 객체들 리스트에 담기
					Employee emp = new Employee();
					// ResultSet에서 데이터 추출해서 객체에 설정
					emp.setEmployeeId(rs.getInt("직원번호"));
					emp.setFullName(rs.getString("직원성명"));
					emp.setEmail(rs.getString("이메일"));
					emp.setPhoneNumber(rs.getString("전화번호"));
					emp.setHireDateString(rs.getString("입사일자"));
					emp.setJobId(rs.getString("직무"));
					emp.setSalary(rs.getDouble("월급여"));
					emp.setManagerId(rs.getInt("관리자번호"));
					emp.setDepartmentId(rs.getInt("부서번호"));
					employees.add(emp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public List<Employee> getByJobTitle(String jobTitle) {

		// 직원들 객체 담을 리스트 생성
		List<Employee> employees = new ArrayList<>();

		// 쿼리문
		String sql = """
				SELECT
					employee_id  AS 직원번호,
				    CONCAT(first_name, " ", last_name) AS 직원성명,
				    email AS 이메일,
				    phone_number AS 전화번호,
				    DATE_FORMAT(hire_date, "%Y-%m-%d") AS 입사일자,
				    job_id AS 직무,
				    salary AS 월급여,
				    commission_pct AS 보너스,
				    manager_id AS 관리자번호,
				    department_id AS 부서번호
				FROM
					employees
				WHERE
					job_id = ?;
				""";

		// DB 연결
		try {

			Connection conn = this.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ? 자리에 값 설정
			pstmt.setString(1, jobTitle);

			// 쿼리문 실행
			try (ResultSet rs = pstmt.executeQuery()) {

				// 직원 객체들 리스트에 담기
				while (rs.next()) {
					Employee emp = new Employee();
					// ResultSet에서 데이터 추출해서 객체에 설정
					emp.setEmployeeId(rs.getInt("직원번호"));
					emp.setFullName(rs.getString("직원성명"));
					emp.setEmail(rs.getString("직원성명"));
					emp.setPhoneNumber(rs.getString("직원성명"));
					emp.setHireDateString(rs.getString("직원성명"));
					emp.setJobId(rs.getString("직무"));
					emp.setSalary(rs.getDouble("보너스"));
					emp.setManagerId(rs.getInt("관리자번호"));
					emp.setDepartmentId(rs.getInt("부서번호"));

					employees.add(emp); // 리스트에 추가
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public List<Employee> getByCity(String city) {
		// 직원들 객체 담을 리스트 생성
		List<Employee> employees = new ArrayList<>();

		// 쿼리문
		String sql = """
				SELECT
					e.employee_id AS 직원번호,
				    CONCAT(e.first_name, " ", e.last_name) AS 직원성명,
				    e.email AS 직원이메일,
				    e.phone_number AS 전화번호,
				    DATE_FORMAT(e.hire_date, "%Y-%m-%d") AS 입사일자,
				    e.job_id AS 직무,
				    l.city AS 근무도시명
				FROM
				 employees AS e
				 JOIN departments AS d ON e.department_id = d.department_id
				 JOIN locations AS l ON d.location_id = l.location_id
				WHERE
					l.city = ?
				""";

		// DB 연결
		try {
			Connection conn = this.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ? 자리에 값 설정
			pstmt.setString(1, city);

			// 쿼리문 실행
			try (ResultSet rs = pstmt.executeQuery()) {

				// 직원 객체들 리스트에 담기
				while (rs.next()) {
					Employee emp = new Employee();
					// ResultSet에서 데이터 추출해서 객체에 설정
					emp.setEmployeeId(rs.getInt("직원번호"));
					emp.setFullName(rs.getString("직원성명"));
					emp.setEmail(rs.getString("직원이메일"));
					emp.setPhoneNumber(rs.getString("전화번호"));
					emp.setHireDateString(rs.getString("입사일자"));
					emp.setJobId(rs.getString("직무"));
					emp.setCityName(rs.getString("근무도시명"));

					employees.add(emp); // 리스트에 추가
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public Map<String, Object> getStatistics(){
		Map<String, Object> statistics = new HashMap<>();

		String sql = """
				SELECT
				    COUNT(*) AS 총직원수,
				    AVG(salary) AS 평균월급여,
				    MAX(salary) AS 최고월급여,
				    MIN(salary) AS 최소월급여,
				    COUNT(DISTINCT department_id) AS 총부서갯수,
				    COUNT(DISTINCT job_id) AS 총직무갯수,
				    AVG(DATEDIFF(CURDATE(), hire_date)/365.25) AS 평균근속년수
				FROM employees
				""";

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				// 별칭과 일치하도록 수정
				statistics.put("총직원수", rs.getInt("총직원수"));
				statistics.put("평균급여", rs.getDouble("평균월급여"));
				statistics.put("최고급여", rs.getDouble("최고월급여"));
				statistics.put("최저급여", rs.getDouble("최소월급여"));
				statistics.put("총부서수", rs.getInt("총부서갯수"));
				statistics.put("총직무수", rs.getInt("총직무갯수"));
				statistics.put("평균근속년수", rs.getDouble("평균근속년수"));
			}

			// 부서별 직원 수 통계
			String deptSql = """
					SELECT
					    d.department_name AS 부서명,
					    COUNT(e.employee_id) AS 직원수,
					    ROUND(AVG(e.salary), 2) AS 평균월급여,
					    ROUND(MAX(e.salary), 2) AS 최고월급여,
					    ROUND(MIN(e.salary), 2) AS 최저월급여,
					    ROUND(AVG(DATEDIFF(CURDATE(), e.hire_date) / 365.25), 1) AS 평균근속년수
					FROM
					    departments AS d
					LEFT JOIN employees e
					    ON d.department_id = e.department_id
					GROUP BY
					    d.department_id,
					    d.department_name
					ORDER BY
					    직원수 DESC
					""";

			// 부서별 상세 통계를 저장할 리스트
			Map<String, Map<String, Object>> deptDetailStats = new HashMap<>();

			try (PreparedStatement deptPstmt = conn.prepareStatement(deptSql);
					ResultSet deptRs = deptPstmt.executeQuery()) {

				while (deptRs.next()) {
					// 상세 부서 통계
					// 부서명을 바깥 HashMap의 키로 사용
					String deptName = deptRs.getString("부서명");

					// 해당 부서의 상세 정보를 담을 내부 Map
					Map<String, Object> deptInfo = new HashMap<>();
					deptInfo.put("직원수", deptRs.getInt("직원수"));
					deptInfo.put("평균월급여", deptRs.getDouble("평균월급여"));
					deptInfo.put("최고월급여", deptRs.getDouble("최고월급여"));
					deptInfo.put("최저월급여", deptRs.getDouble("최저월급여"));
					deptInfo.put("평균근속년수", deptRs.getDouble("평균근속년수"));

					// 부서명을 키로 해서 바깥 Map에 저장
					deptDetailStats.put(deptName, deptInfo);
				}

				statistics.put("부서별상세통계", deptDetailStats);

			} catch (SQLException e) {
				e.printStackTrace();
			} // 자동으로 rs.close(), pstmt.close() 호출됨
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return statistics;
	}

	@Override
	public List<Employee> getByManagerLastName(String lastName) {
		// 직원들 객체 담을 리스트 생성
		List<Employee> employees = new ArrayList<>();
				
		//쿼리문
		String sql = """
					SELECT 
						e.manager_id AS 부서장번호, 
				     	CONCAT(e.first_name, " ", e.last_name) AS 직원성명
					FROM 
						employees AS e
					WHERE 
						e.manager_id IN (SELECT 
											employee_id
										 FROM 
										 	employees
			                    		 WHERE 
				                  		 	last_name = ?)
						""";
				
		// DB 연결
		try {
			Connection conn = this.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			// ?자리에 값 결정
			pstmt.setString(1, lastName);
					
			// 쿼리문 실행
			try(ResultSet rs = pstmt.executeQuery()) {
				// 직원 객체들 리스트에 담기
				while(rs.next() ) {
					Employee emp = new Employee();
					// ResultSet에서 데이터 추출해서 객체에 설정
					emp.setManagerId(rs.getInt("부서장번호"));
					emp.setFullName(rs.getString("직원성명"));
					employees.add(emp);
					}	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
				return employees;
		}

	@Override
	public List<Employee> getByCountryName(String countryName) {
		// 직원들 객체 담을 리스트 생성
		List<Employee> employees = new ArrayList<>();

		// 쿼리문
		String sql = """
				SELECT
					c.country_name AS 국가명,
					CONCAT(e.first_name, " ", e.last_name) AS 직원성명
				FROM
					countries AS c
				    JOIN locations AS l ON l.country_id = c.country_id
				    JOIN departments AS d ON d.location_id = l.location_id
				    JOIN employees AS e on e.department_id = d.department_id
				WHERE c.country_name = ?
				""";

		// DB 연결
		try {
			Connection conn = this.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ? 자리에 값 설정
			pstmt.setString(1, countryName);

			// 쿼리문 실행
			try (ResultSet rs = pstmt.executeQuery()) {

				// 직원 객체들 리스트에 담기
				while (rs.next()) {
					Employee emp = new Employee();
					// ResultSet에서 데이터 추출해서 객체에 설정
					emp.setCountryName(rs.getString("국가명"));
					emp.setFullName(rs.getString("직원성명"));

					employees.add(emp); // 리스트에 추가
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

}
