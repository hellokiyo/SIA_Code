package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// Class : 메서드, 변수,생성자들이 모여있는 곳
		//class이름뒤에 바로 메서드를 실행하는건 반드시 static으로 정의되어있다.
		Connection conn =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr","root","rootroot"); 
		//getConnection의 턴타입이 connection임
		System.out.println(conn.getClass().getName());
		
		String sql = "select * from employees";
		Statement stmt = conn.createStatement();
		// createStatement()는 Connection안에 있음
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			String lastName = rs.getString("last_name");
			int salary = rs.getInt("salary");
			System.out.println("last_name = " +lastName + ", salary = " + salary);
			//last_name employees 테이블에 있는 컬럼명
		}
		//ResultSet에 선언된 next()라는 메서드를 실행한 것이다.
		conn.close();
		
		
	}
}
