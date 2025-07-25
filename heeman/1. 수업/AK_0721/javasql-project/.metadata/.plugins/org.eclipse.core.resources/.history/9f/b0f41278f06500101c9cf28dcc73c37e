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

public class City {
	static void searchByCity() throws Exception {

		System.out.println("도시이름을 입력해주세요 (ex London): ");
		Scanner scan = new Scanner(System.in);
		String city = scan.nextLine();
		while (city != null && city.length() != 0) {
			System.out.println(city);
			List<Emp> empList = getEmpListByCity(city);
			for (Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.print("도시이름(엔터는 종료) : ");
			city = scan.nextLine();
		}
	}
	//기능으로 들어갔는데 안된다-> 각 클래스 밑만든 매소드에 문제
	private static List<Emp> getEmpListByCity(String city) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		List<Emp> result = new ArrayList<Emp>();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

//		String sql = "select concat(e.first_name, ' ', e.last_name) full_name, e.salary,"
//				+ " e.hire_date, d.department_name," + " l.city, from employees e join departments d "
//				+ "on e.department_id = d.department_id join locations l "
//				+ "on l.location_id= d.location_id where l.city =  ?";
		
		// 위에 쿼리에서 오류 발생으로 수정. 불필요한 ',' 제거
		String sql = "SELECT CONCAT(e.first_name, ' ', e.last_name) AS full_name, "
	             + "e.salary, e.hire_date, d.department_name, l.city " 
	             + "FROM employees e "
	             + "JOIN departments d ON e.department_id = d.department_id "
	             + "JOIN locations l ON l.location_id = d.location_id "
	             + "WHERE l.city = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, city);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Emp emp = new Emp();
			emp.fullName = rs.getString("full_name");
			emp.salary = rs.getInt("salary");
			emp.deptName = rs.getString("department_name"); // deptName 누락으로 추가
			emp.hireDate = rs.getDate("hire_date");
			result.add(emp);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return result;

	}

}
