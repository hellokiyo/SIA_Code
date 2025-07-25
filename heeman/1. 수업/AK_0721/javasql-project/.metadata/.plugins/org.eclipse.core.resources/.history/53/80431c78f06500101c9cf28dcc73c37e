package team3;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Name {
	public static void searchByName() throws Exception {

		// 1.이름으로 직원정보 출력

		Scanner scan1 = new Scanner(System.in);

		while (true) {
			System.out.print("이름을 입력하세요(종료 : 0) : ");
			String fullName = scan1.nextLine();

			if (fullName.equals("0")) {
				System.out.println("직무 검색을 종료합니다.");
				break;
			}

			try {
				List<Emp> result1 = getEmpListByFullName(fullName);
				if (result1.isEmpty()) {
					System.out.println("입력하신 이름에 해당하는 직원이 없습니다.");
				} else {
					for (Emp emp : result1) {
						System.out.println(emp);
					}
				}
			} catch (Exception e) {
				System.err.println("직무 검색 중 오류 발생: " + e.getMessage());
				e.printStackTrace();
			}
		}

	}

	public static List<Emp> getEmpListByFullName(String fullName) throws Exception {
		List<Emp> result1 = new ArrayList<Emp>();

		Properties props = new Properties();
		FileReader fr = new FileReader("db-info.properties");
		props.load(fr);

		Class.forName(props.getProperty("driverClassName"));

		Connection conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("userName"),
				props.getProperty("password"));

		String sql = "select concat(e.first_name, ' ', e.last_name) 'full_name', e.salary, e.hire_date, d.department_name\r\n"
				+ "from employees e join departments d on e.department_id = d.department_id\r\n"
				+ "where concat(e.first_name, ' ', e.last_name) = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, fullName);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Emp emp = new Emp();
			emp.fullName = rs.getString("full_name");
			emp.hireDate = rs.getDate("hire_date");
			emp.deptName = rs.getString("department_name");
			emp.salary = rs.getInt("salary");
			result1.add(emp);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return result1;

	}

}
