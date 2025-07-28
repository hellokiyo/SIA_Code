package projPure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpDAO {

	private static Scanner input = new Scanner(System.in);
	
	//1번
	public static void getEmpListByFirstName() throws Exception {
		System.out.println();
		System.out.println("직원의 이름을 입력하여 직원정보를 불러옵니다.--------------------");
		System.out.print("이름 : ");
		String scanResult = setScanResultAsString();
		
		String sql = "select employee_id, first_name, last_name, email, phone_number,"
				+ " hire_date, job_id, salary, ifnull(commission_pct, 0.0) as commission_pct, "
				+ "ifnull(manager_id, 0) as manager_id, "
				+ "ifnull(department_id, 0) as department_id from employees where first_name = ?";
		
		getEmpInfo(sql, scanResult);
	}
	
	// 2번
	public static void getEmpListByHireYear() throws Exception{
		System.out.println();
		System.out.println("입사년도를 입력하여 직원정보를 불러옵니다.--------------------");
		System.out.print("입사년도 : ");
		String scanResult = setScanResultAsString();
		
		String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, ifnull(commission_pct, 0.0) as commission_pct, "
				+ "ifnull(manager_id, 0) as manager_id, ifnull(department_id, 0) as department_id from employees where hire_date like ?";
		
		getEmpInfo(sql, scanResult + "%");
	}

	// 3번
	public static void getEmpListByDepartmentId() throws Exception{
		System.out.println();
		System.out.println("부서번호를 입력하여 직원정보를 불러옵니다.--------------------");
		System.out.print("부서번호 : ");
		
		String scanResultstr = setScanResultAsString();
		
		String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, ifnull(commission_pct, 0.0) as commission_pct, ifnull(manager_id, 0) as manager_id, ifnull(department_id, 0) as department_id from employees where department_id is not null and department_id = ?";
		
		getEmpInfo(sql, scanResultstr);
	}

	// 4번
	public static void getEmpListByJobId() throws Exception{
		System.out.println();
		System.out.println("직무 아이디를 입력하여 직원정보를 불러옵니다.--------------------");
		System.out.print("직무 아이디 : ");
		
		String scanResult = setScanResultAsString();
		
		String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, ifnull(commission_pct, 0.0) as commission_pct, ifnull(manager_id, 0) as manager_id, ifnull(department_id, 0) as department_id from employees where job_id = ?";
		
		getEmpInfo(sql, scanResult);
	}
	
	// 5번
	public static void getEmpListByCityName() throws Exception{
		System.out.println();
		System.out.println("도시를 입력하여 직원정보를 불러옵니다.--------------------");
		System.out.print("도시 이름 : ");
		
		String scanResult = setScanResultAsString();
		
		String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, ifnull(commission_pct, 0.0) as commission_pct, ifnull(manager_id, 0) as manager_id, ifnull(department_id, 0) as department_id from employees where department_id in (select department_id from departments where location_id in (select location_id from locations where city = ?))";
		
		getEmpInfo(sql, scanResult);
	}

	// 6번	
	public static void getYOEStatByDept() throws Exception {
		List<String> result = new ArrayList<>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "select department_id, avg(truncate(datediff(curdate(), hire_date) / 365.5, 1)) as avg_yoe, "
				+ "max(truncate(datediff(curdate(), hire_date) / 365.5, 1)) as max_yoe, "
				+ "min(truncate(datediff(curdate(), hire_date) / 365.5, 1)) as min_yoe, "
				+ "count(*) as count_num FROM employees group by department_id";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			int departmentId = rs.getInt("department_id");
	        double avgYOE = rs.getDouble("avg_yoe");
	        double maxYOE = rs.getDouble("max_yoe");
	        double minYOE = rs.getDouble("min_yoe");
	        int count = rs.getInt("count_num");

	        String row = "- 부서번호 : " + departmentId + " | 평균 근속년수 : " + avgYOE + 
	        		" | 최장기 근속 : " + maxYOE + " | 최단기 근속 : " + minYOE + " | 부서원 수 : " + count;
	        result.add(row);
		}
		conn.close();
		System.out.println("검색 결과 : ");
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	}

	// 7번
	public static void getEmpListByDepManagerLastName() throws Exception{
		System.out.println();
		System.out.println("부서장의 성을 입력하여 해당 부서 직원정보를 불러옵니다.--------------------");
		System.out.print("부서장의 성 : ");
		
		String scanResult = setScanResultAsString();
		
		String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, ifnull(commission_pct, 0.0) as commission_pct, ifnull(manager_id, 0) as manager_id, ifnull(department_id, 0) as department_id from employees where department_id in (select department_id from departments where manager_id in (select employee_id from employees where last_name = ?))";
		
		getEmpInfo(sql, scanResult);
	}

	// 8번
	public static void getEmpListByCountryName() throws Exception{
		System.out.println();
		System.out.println("나라이름을 입력하여 해당 부서 직원정보를 불러옵니다.--------------------");
		System.out.print("나라이름 : ");
		
		String scanResult = setScanResultAsString();
		
		String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, ifnull(commission_pct, 0.0) as commission_pct, ifnull(manager_id, 0) as manager_id, ifnull(department_id, 0) as department_id from employees where department_id in (select department_id from departments where location_id in(select location_id from locations where country_id in (select country_id from countries where country_name = ?)));";
	
		getEmpInfo(sql, scanResult);
		
	}

	public static String setScanResultAsString() {
		String scanResult = input.next();
		return scanResult;
	}
	
	//스캐너 닫는 함수 추가
	public static void closeScanner() {
	    if (input != null) {
	        input.close();
	    }
	}
	
	public static void getEmpInfo(String sql, String scanResult) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, scanResult);
		ResultSet rs = stmt.executeQuery();
		
		List<Emp> result = new ArrayList<Emp>();

		while(rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNumber = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getDouble("salary");
			emp.commissionPct = rs.getDouble("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
			result.add(emp);
		}
		
		if (result.isEmpty()) {
			System.out.println("해당 값이 존재하지 않습니다.");
		} else {
			System.out.println("검색 결과 : ");
			for(int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i).toString());
		}

		}
	}
	
}
