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

public class Manager {
	public static void searchByManager() throws Exception, SQLException { // Manger => Manager 오타 수정
		System.out.println("부서장의 성을 입력해주세요(ex Fripp) : ");
		Scanner scan = new Scanner(System.in);
		String departManger = scan.nextLine();
		while (departManger != null && departManger.length() != 0) {
			System.out.println(departManger);
			List<Emp> empList = getEmpListBydepartManger(departManger);
			for (Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.print("부서장의 성을 입력해주세요(ex Fripp) : "); // 도시이름(0은 종료) : => 부서장의 성을 입력해주세요(ex Fripp) : 수정
			departManger = scan.nextLine();
		}

	}

	public static List<Emp> getEmpListBydepartManger(String departManger) throws Exception, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

//		String sql = "select concat(e.first_name, ' ', e.last_name) full_name, e.salary,"
//				+ " e.hire_date, d.department_name, from employees e "
//				+ "join employees m on e.department_id = m.department_id "
//				+ "join departments d on m.employee_id = d.manager_id " + "where m.last_name =  ?";
		
		// 위에 쿼리에서 오류 발생으로 수정. 불필요한 ',' 제거
		String sql = "SELECT CONCAT(e.first_name, ' ', e.last_name) AS full_name, "
		             + "e.salary, e.hire_date, d.department_name " 
		             + "FROM employees e "
		             + "JOIN employees m ON e.department_id = m.department_id "
		             + "JOIN departments d ON m.employee_id = d.manager_id " 
		             + "WHERE m.last_name = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, departManger);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Emp emp = new Emp();
			emp.fullName = rs.getString("full_name");
			emp.salary = rs.getInt("salary");
			emp.deptName = rs.getString("department_name"); // deptName 누락으로 추가
			emp.hireDate = rs.getDate("hire_date"); 
			result.add(emp);
		}
		rs.close();
		stmt.close();
		conn.close();
		return result;

	}
}
