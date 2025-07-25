package team3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import pj1.Emp;

public class Country {
	static void searchByCountry() throws Exception, SQLException { // CounTry => country 오타 수정
		Scanner scan = new Scanner(System.in);
		System.out.println("나라를 입력해주세요  (ex US):");

		String CountryId = scan.nextLine();
		while (CountryId != null && CountryId.length() != 0) {
			List<Emp> empList = getEmpListByCounTry(CountryId);
			for (Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.println("\n나라 입력 (종료: 엔터):");
			CountryId = scan.nextLine();
		}

		System.out.println("프로그램 종료");
	}

	private static List<Emp> getEmpListByCounTry(String CountryId) throws ClassNotFoundException, SQLException {
		List<Emp> result = new ArrayList<>();

		Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC 드라이버 로딩

//		String sql = "SELECT concat(e.first_name, ' ', e.last_name) full_name, "
//				+ "e.salary, e.hire_date, " + "d.department_name, c.country_id"
//				+ "FROM employees e " + "JOIN departments d ON e.department_id = d.department_id "
//				+ "JOIN locations l ON d.location_id = l.location_id "
//				+ "JOIN countries c ON l.country_id = c.country_id " + "WHERE c.country_id = ?";
		
		// 위에 쿼리에서 오류 발생으로 수정. 누락된 ',' 추가
		String sql = "SELECT CONCAT(e.first_name, ' ', e.last_name) AS full_name, "
	             + "e.salary, e.hire_date, "
	             + "d.department_name, c.country_id " // <-- c.country_id 뒤에 쉼표 추가!
	             + "FROM employees e "
	             + "JOIN departments d ON e.department_id = d.department_id "
	             + "JOIN locations l ON d.location_id = l.location_id "
	             + "JOIN countries c ON l.country_id = c.country_id "
	             + "WHERE c.country_id = ?";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, CountryId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Emp emp = new Emp();
					emp.fullName = rs.getString("full_name");
					emp.hireDate = rs.getDate("hire_date");
					emp.salary = rs.getInt("salary");
					emp.deptName = rs.getString("department_name");
					result.add(emp);
				}
				rs.close();
				pstmt.close();
				conn.close();
			}
		}
		
		return result;

	}
}
