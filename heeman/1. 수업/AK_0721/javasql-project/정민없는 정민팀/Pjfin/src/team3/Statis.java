package team3;

import java.sql.*;
import java.util.Scanner;

// statistics(통계) 클래스로 빼서 SearchStatisics메소드로 뺌
public class Statis {
	public static void statisRead() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Statis stats = new Statis();

		while (true) {
			System.out.println("\n======= 통계 기능 선택 =======");
			System.out.println("1. 각 부서별 직원 수");
			System.out.println("2. 부서별 평균 급여");
			System.out.println("3. 직무별 최대/최소 급여");
			System.out.println("4. 월별 입사자 수");
			System.out.println("5. 직무별 평균 근속기간");
			System.out.println("0. 종료");
			System.out.print("선택 >> ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				stats.getEmpCountByDepartment();
				break;
                case 2:
                    stats.getAvgSalaryByDepartment();
                    break;
                case 3:
                    stats.getJobMaxMinSalary();
                    break;
                case 4:
                    stats.getMonthEmp();
                    break;
                case 5:
                    stats.getAvgHireDateByJob();
                    break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 선택입니다.");
			}
		}
	}

	private void getEmpCountByDepartment() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection 의 리턴 타입은 connection 타입의 객체
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = " SELECT d.department_name 부서이름, COUNT(*) AS employee_count FROM employees e JOIN departments d ON e.department_id = d.department_id GROUP BY e.department_id;";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("부서별 직원수");
		while (rs.next()) {
			String departmentName = rs.getString("부서이름");
			int count = rs.getInt("employee_count");
			System.out.println("departmentName = " + departmentName + ", count = " + count);
		}

	}

	private void getAvgSalaryByDepartment() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection 의 리턴 타입은 connection 타입의 객체
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "SELECT d.department_name 부서이름, ROUND(AVG(e.salary), 2) AS avg_salary FROM employees e JOIN departments d ON e.department_id = d.department_id GROUP BY d.department_id;";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("부서별 평균 급여");
		while (rs.next()) {
			String departmentName = rs.getString("부서이름");
			int salary = rs.getInt("avg_salary");
			System.out.println("departmentName = " + departmentName + ", salary = " + salary);
		}
	}

	private void getJobMaxMinSalary() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection 의 리턴 타입은 connection 타입의 객체
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "SELECT job_id, MAX(salary) AS max_salary, MIN(salary) AS min_salary FROM employees GROUP BY job_id;";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		System.out.printf("%-15s %-15s %-15s\n", "직무", "최대 급여", "최소 급여");
		System.out.println("--------------------------------------------------");

		while (rs.next()) {
			System.out.printf("%-15s %-15.2f %-15.2f\n", rs.getString("job_id"), rs.getDouble("max_salary"),
					rs.getDouble("min_salary"));
		}
	}



	private void getMonthEmp() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection 의 리턴 타입은 connection 타입의 객체
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "SELECT DATE_FORMAT(hire_date, '%Y-%m')  AS hire_month, COUNT(*) AS num_hired FROM employees GROUP BY hire_month ORDER BY hire_month";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("월별 입사자 수");
		while (rs.next()) {
			int count = rs.getInt("num_hired");
			String hireDate = rs.getString("hire_month");
			System.out.println("hireDate = " + hireDate + ", count = " + count);
		}
	}

	private void getAvgHireDateByJob() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection 의 리턴 타입은 connection 타입의 객체
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = " SELECT job_id jobId,\r\n"
				+ "ROUND(AVG(DATEDIFF(SYSDATE(), hire_date) / 365), 2) AS avg_years_worked\r\n"
				+ "FROM employees\r\n"
				+ "GROUP BY job_id;";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("직무별 평균 근속기간");
		while (rs.next()) {
			String jobId = rs.getString("jobId");
			int avg_years_worked = rs.getInt("avg_years_worked");
			System.out.println("jobId = " + jobId + ", avg_years_worked = " + avg_years_worked);
		}
	}

}
